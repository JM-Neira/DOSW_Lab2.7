import java.util.ArrayList;
import java.util.List;

public class Visitante {
    private String nombre;
    private int edad;
    private List<Animal> animalesFavoritos;
    private List<String> fotografias;

    public Visitante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.animalesFavoritos = new ArrayList<>();
        this.fotografias = new ArrayList<>();
    }

    public void agregarAnimalFavorito(Animal animal) {
        animalesFavoritos.add(animal);
        System.out.println(nombre + " agrega a " + animal.getNombre() + " como favorito");
    }

    public void alimentarAnimal(Animal animal) {
        System.out.println(nombre + " alimenta a " + animal.getNombre());
    }

    public void darPropina(Cuidador cuidador, double monto) {
        System.out.println(nombre + " da propina de $" + monto + " a " + cuidador.getNombre());
    }

    public void tomarFotografia(Animal animal) {
        String foto = "Foto de " + animal.getNombre();
        fotografias.add(foto);
        System.out.println(nombre + " toma foto de " + animal.getNombre());
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public List<Animal> getAnimalesFavoritos() { return animalesFavoritos; }
    public List<String> getFotografias() { return fotografias; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
}