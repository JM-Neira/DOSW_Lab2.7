import java.util.*;

public class Cuidador {
    private String nombre;
    private int edad;
    private String especialidad;
    private List<Animal> animalesAsignados;

    public Cuidador(String nombre, int edad, String especialidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.especialidad = especialidad;
        this.animalesAsignados = new ArrayList<>();
    }

    public void alimentar(Animal animal) {
        System.out.println(nombre + " alimenta a " + animal.getNombre() + " con " + animal.getAlimentoPreferido());
    }

    public void banar(Animal animal) {
        System.out.println(nombre + " baña a " + animal.getNombre());
    }

    public void limpiarHabitat(Animal animal) {
        System.out.println(nombre + " limpia el hábitat de " + animal.getNombre());
    }

    public void asignarAnimal(Animal animal) {
        animalesAsignados.add(animal);
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getEspecialidad() { return especialidad; }
    public List<Animal> getAnimalesAsignados() { return animalesAsignados; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}