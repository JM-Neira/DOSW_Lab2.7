public class Mamifero extends Animal {
    private String colorPelaje;

    public Mamifero(String nombre, int edad, String dieta, String alimentoPreferido,
                    double peso, double altura, String estadoSalud, String habitat, String colorPelaje) {
        super(nombre, edad, dieta, alimentoPreferido, peso, altura, estadoSalud, habitat);
        this.colorPelaje = colorPelaje;
    }

    @Override
    public String emitirSonido() {
        return "Rugido";
    }

    public String getColorPelaje() { return colorPelaje; }
    public void setColorPelaje(String colorPelaje) { this.colorPelaje = colorPelaje; }
}
