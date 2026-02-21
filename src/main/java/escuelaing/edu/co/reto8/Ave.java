public class Ave extends Animal {
    private double envergaduraAlas;

    public Ave(String nombre, int edad, String dieta, String alimentoPreferido, double peso, double altura, String estadoSalud, String habitat, double envergaduraAlas) {
        super(nombre, edad, dieta, alimentoPreferido, peso, altura, estadoSalud, habitat);
        this.envergaduraAlas = envergaduraAlas;
    }

    @Override
    public String emitirSonido() {
        return "Canto";
    }

    public double getEnvergaduraAlas() { return envergaduraAlas; }
    public void setEnvergaduraAlas(double envergaduraAlas) { this.envergaduraAlas = envergaduraAlas; }
}