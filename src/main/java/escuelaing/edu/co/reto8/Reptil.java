public class Reptil extends Animal {
    private String tipoEscamas;

    public Reptil(String nombre, int edad, String dieta, String alimentoPreferido, double peso, double altura, String estadoSalud, String habitat, String tipoEscamas) {
        super(nombre, edad, dieta, alimentoPreferido, peso, altura, estadoSalud, habitat);
        this.tipoEscamas = tipoEscamas;
    }

    @Override
    public String emitirSonido() {
        return "Siseo";
    }

    public String getTipoEscamas() { return tipoEscamas; }
    public void setTipoEscamas(String tipoEscamas) { this.tipoEscamas = tipoEscamas; }
}
