package escuelaing.edu.co.reto7;

public interface Comando {
    void ejecutar();
    void deshacer();
    String getDescripcion();
    String getUsuario();
}