import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaSoporte {

    public static void run() {

        Scanner scanner = new Scanner(System.in);

        // Construcción de la cadena
        SoporteHandler basico = new TecnicoBasico();
        SoporteHandler intermedio = new TecnicoIntermedio();
        SoporteHandler avanzado = new TecnicoAvanzado();

        basico.setSiguiente(intermedio);
        intermedio.setSiguiente(avanzado);

        List<Ticket> tickets = new ArrayList<>();

        System.out.print("¿Cuántos tickets desea ingresar?: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cantidad; i++) {

            System.out.println("\nTicket #" + i);

            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();

            System.out.println("Nivel de dificultad:");
            System.out.println("1. BASICO");
            System.out.println("2. INTERMEDIO");
            System.out.println("3. AVANZADO");
            int nivelInput = Integer.parseInt(scanner.nextLine());

            NivelDificultad nivel = switch (nivelInput) {
                case 1 -> NivelDificultad.BASICO;
                case 2 -> NivelDificultad.INTERMEDIO;
                case 3 -> NivelDificultad.AVANZADO;
                default -> throw new IllegalArgumentException("Nivel inválido");
            };

            System.out.println("Prioridad:");
            System.out.println("1. BAJA");
            System.out.println("2. MEDIA");
            System.out.println("3. ALTA");
            int prioridadInput = Integer.parseInt(scanner.nextLine());

            Prioridad prioridad = switch (prioridadInput) {
                case 1 -> Prioridad.BAJA;
                case 2 -> Prioridad.MEDIA;
                case 3 -> Prioridad.ALTA;
                default -> throw new IllegalArgumentException("Prioridad inválida");
            };

            tickets.add(new Ticket(i, descripcion, nivel, prioridad));
        }

        System.out.println("\n--- Procesando Tickets ---\n");

        tickets.forEach(basico::procesar);

        generarEstadisticas(tickets);
    }

    private static void generarEstadisticas(List<Ticket> tickets) {

        System.out.println("\n--- Estadísticas ---");

        long basico = tickets.stream()
                .filter(t -> "Técnico Básico".equals(t.getTecnicoQueResolvio()))
                .count();

        long intermedio = tickets.stream()
                .filter(t -> "Técnico Intermedio".equals(t.getTecnicoQueResolvio()))
                .count();

        long avanzado = tickets.stream()
                .filter(t -> "Técnico Avanzado".equals(t.getTecnicoQueResolvio()))
                .count();

        long pendientes = tickets.stream()
                .filter(t -> t.getEstado() == EstadoTicket.PENDIENTE)
                .count();

        double promedioPrioridad = tickets.stream()
                .filter(t -> t.getEstado() == EstadoTicket.RESUELTO)
                .mapToInt(t -> t.getPrioridad().getValor())
                .average()
                .orElse(0);

        System.out.println("Tickets resueltos:");
        System.out.println("Básico: " + basico);
        System.out.println("Intermedio: " + intermedio);
        System.out.println("Avanzado: " + avanzado);
        System.out.println("Tickets pendientes: " + pendientes);
        System.out.println("Promedio prioridad resueltos: " + promedioPrioridad);
    }
}
