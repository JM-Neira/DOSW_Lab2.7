public abstract class Animal {
    private String nombre;
    private int edad;
    private String dieta;
    private String alimentoPreferido;
    private double peso;
    private double altura;
    private String estadoSalud;
    private String habitat;

    public Animal(String nombre, int edad, String dieta, String alimentoPreferido, double peso, double altura, String estadoSalud, String habitat) {
        this.nombre = nombre;
        this.edad = edad;
        this.dieta = dieta;
        this.alimentoPreferido = alimentoPreferido;
        this.peso = peso;
        this.altura = altura;
        this.estadoSalud = estadoSalud;
        this.habitat = habitat;
    }

    public abstract String emitirSonido();

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getDieta() { return dieta; }
    public String getAlimentoPreferido() { return alimentoPreferido; }
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public String getEstadoSalud() { return estadoSalud; }
    public String getHabitat() { return habitat; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setDieta(String dieta) { this.dieta = dieta; }
    public void setAlimentoPreferido(String alimentoPreferido) { this.alimentoPreferido = alimentoPreferido; }
    public void setPeso(double peso) { this.peso = peso; }
    public void setAltura(double altura) { this.altura = altura; }
    public void setEstadoSalud(String estadoSalud) { this.estadoSalud = estadoSalud; }
    public void setHabitat(String habitat) { this.habitat = habitat; }
}