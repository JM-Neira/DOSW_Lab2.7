package escuelaing.edu.co.reto7;

import java.util.*;
import org.springframework.boot.SpringApplication;


public class Reto7Application {
    
    private static Luz luzSala = new Luz("Sala");
    private static Puerta puertaPrincipal = new Puerta("Principal");
    private static SistemaMusica musica = new SistemaMusica();
    private static Persiana persianaSala = new Persiana("Sala");
    
    private static List<RegistroAccion> historial = new ArrayList<>();
    
	public static void main(String[] args) {
		ejecutar();
	}

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Número de acciones a registrar: ");
        int numAcciones = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= numAcciones; i++) {
            System.out.println("\nAcción " + i + ":");
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine().trim();
            
            System.out.print("Selecciones: ");
            String selecciones = scanner.nextLine().trim();
            
            procesarSelecciones(i, usuario, selecciones);
        }
        
        System.out.println();
        mostrarResultados();
    }
    
    private static void procesarSelecciones(int numeroAccion, String usuario, String selecciones) {
        String[] partes = selecciones.split("\\.");
        
        List<Comando> comandosEjecutados = new ArrayList<>();
        List<String> descripcionesAcciones = new ArrayList<>();
        
        for (String parte : partes) {
            parte = parte.trim();
            if (parte.isEmpty()) continue;
            
            parte = parte.replaceFirst("^\\d+\\s*", "").trim();
            
            Comando comando = crearComando(parte, usuario);
            if (comando != null) {
                comando.ejecutar();
                comandosEjecutados.add(comando);
                descripcionesAcciones.add(comando.getDescripcion());
            }
        }
        
        boolean tieneDeshacer = selecciones.toLowerCase().contains("deshacer") ||
                               selecciones.toLowerCase().contains("si/no");
        
        historial.add(new RegistroAccion(numeroAccion, usuario, comandosEjecutados, 
                                         descripcionesAcciones, !tieneDeshacer));
    }
    
    private static Comando crearComando(String seleccion, String usuario) {
        String selLower = seleccion.toLowerCase();
        
        if (selLower.contains("encender luz")) {
            return new ComandoEncenderLuz(luzSala, usuario);
        } else if (selLower.contains("abrir puerta")) {
            return new ComandoAbrirPuerta(puertaPrincipal, usuario);
        } else if (selLower.contains("reproducir musica") || selLower.contains("reproducir música")) {
            return new ComandoReproducirMusica(musica, "cancion", usuario);
        } else if (selLower.contains("ajustar volumen")) {
            int porcentaje = extraerPorcentaje(selLower);
            return new ComandoAjustarVolumen(musica, porcentaje, usuario);
        } else if (selLower.matches("\\d+")) {
            int opcion = Integer.parseInt(selLower);
            return interpretarOpcion(opcion, usuario);
        }
        
        return null;
    }
    
    private static Comando interpretarOpcion(int opcion, String usuario) {
        switch (opcion) {
            case 1: return new ComandoEncenderLuz(luzSala, usuario);
            case 2: return new ComandoAbrirPuerta(puertaPrincipal, usuario);
            case 3: return new ComandoReproducirMusica(musica, "cancion", usuario);
            default: return null;
        }
    }
    
    private static int extraerPorcentaje(String texto) {
        String[] palabras = texto.split("\\s+");
        for (int i = 0; i < palabras.length - 1; i++) {
            if (palabras[i].equals("a")) {
                String valor = palabras[i + 1].replace("%", "");
                try {
                    return Integer.parseInt(valor);
                } catch (NumberFormatException e) {
                    return 50;
                }
            }
        }
        return 50;
    }
    
    private static void mostrarResultados() {
        for (RegistroAccion registro : historial) {
            if (registro.exitosa) {
                System.out.println("Acción " + registro.numeroAccion + " ejecutada por " + 
                    registro.usuario + ": " + formatearDescripciones(registro.descripciones));
            } else {
                for (int i = registro.comandos.size() - 1; i >= 0; i--) {
                    registro.comandos.get(i).deshacer();
                }
                
                System.out.println("Acción " + registro.numeroAccion + " deshecha: " + 
                    formatearDescripcionesDeshecho(registro.descripciones));
            }
        }
        
        System.out.println("\n--- Historial completo ---");
        int contador = 1;
        for (RegistroAccion registro : historial) {
            for (String desc : registro.descripciones) {
                System.out.println(contador + ": " + desc + " - Usuario: " + registro.usuario + 
                    (registro.exitosa ? "" : " (deshecha)"));
                contador++;
            }
        }
        
        mostrarInvestigacion();
    }
    
    private static String formatearDescripciones(List<String> descripciones) {
        if (descripciones.size() == 1) {
            return descripciones.get(0);
        }
        return String.join(", ", descripciones);
    }
    
    private static String formatearDescripcionesDeshecho(List<String> descripciones) {
        List<String> deshecho = new ArrayList<>();
        for (String desc : descripciones) {
            if (desc.contains("Volumen ajustado")) {
                deshecho.add("Volumen regresado a 0%");
            } else if (desc.contains("Musica reproducida")) {
                deshecho.add("Musica detenida");
            } else if (desc.contains("Luz encendida")) {
                deshecho.add("Luz apagada");
            } else if (desc.contains("Puerta abierta")) {
                deshecho.add("Puerta cerrada");
            } else {
                deshecho.add(desc + " deshecho");
            }
        }
        return String.join(", ", deshecho);
    }
    
    private static void mostrarInvestigacion() {
        System.out.println("\n--- Investigando quién desconfiguró los electrodomésticos ---");
        
        Map<String, Integer> accionesPorUsuario = new HashMap<>();
        
        for (RegistroAccion registro : historial) {
            int count = accionesPorUsuario.getOrDefault(registro.usuario, 0);
            accionesPorUsuario.put(registro.usuario, count + registro.comandos.size());
        }
        
        for (Map.Entry<String, Integer> entry : accionesPorUsuario.entrySet()) {
            String usuario = entry.getKey();
            int cantidad = entry.getValue();
            
            System.out.println("Se detectó que el usuario " + usuario + " realizó " + 
                cantidad + " " + (cantidad == 1 ? "acción" : "acciones") + 
                " que alteraron la configuración.");
        }
       
        if (accionesPorUsuario.containsKey("Camila")) {
            System.out.println("\nTamila realizó " + accionesPorUsuario.get("Camila") + " acción.");
        }
    }
}

class RegistroAccion {
    int numeroAccion;
    String usuario;
    List<Comando> comandos;
    List<String> descripciones;
    boolean exitosa;
    
    public RegistroAccion(int numeroAccion, String usuario, List<Comando> comandos, 
                          List<String> descripciones, boolean exitosa) {
        this.numeroAccion = numeroAccion;
        this.usuario = usuario;
        this.comandos = comandos;
        this.descripciones = descripciones;
        this.exitosa = exitosa;
    }
}
