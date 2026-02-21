import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private List<Animal> animales;
    private List<Cuidador> cuidadores;
    private List<Visitante> visitantes;

    public Zoologico() {
        this.animales = new ArrayList<>();
        this.cuidadores = new ArrayList<>();
        this.visitantes = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void agregarCuidador(Cuidador cuidador) {
        cuidadores.add(cuidador);
    }

    public void agregarVisitante(Visitante visitante) {
        visitantes.add(visitante);
    }

    public void mostrarAnimales() {
        System.out.println("\n=== ANIMALES DEL ZOOLÓGICO ===");
        animales.forEach(a -> {
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Tipo: " + a.getClass().getSimpleName());
            System.out.println("Edad: " + a.getEdad() + " años");
            System.out.println("Sonido: " + a.emitirSonido());
            System.out.println("Estado: " + a.getEstadoSalud());
            System.out.println("---");
        });
    }

    public void mostrarCuidadores() {
        System.out.println("\n=== CUIDADORES ===");
        cuidadores.forEach(c -> {
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Especialidad: " + c.getEspecialidad());
            System.out.println("Animales asignados: " + c.getAnimalesAsignados().size());
            System.out.println("---");
        });
    }

    public List<Animal> getAnimales() { return animales; }
    public List<Cuidador> getCuidadores() { return cuidadores; }
    public List<Visitante> getVisitantes() { return visitantes; }
}