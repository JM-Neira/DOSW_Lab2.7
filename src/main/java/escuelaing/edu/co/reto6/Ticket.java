public class Ticket {

    private final int id;
    private final String descripcion;
    private final NivelDificultad nivel;
    private final Prioridad prioridad;

    private EstadoTicket estado;
    private String tecnicoQueResolvio;

    public Ticket(int id, String descripcion,
                  NivelDificultad nivel,
                  Prioridad prioridad) {

        this.id = id;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.prioridad = prioridad;
        this.estado = EstadoTicket.PENDIENTE;
    }

    public NivelDificultad getNivel() {
        return nivel;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void marcarResuelto(String tecnico) {
        this.estado = EstadoTicket.RESUELTO;
        this.tecnicoQueResolvio = tecnico;
    }

    public void marcarPendiente() {
        this.estado = EstadoTicket.PENDIENTE;
    }

    public EstadoTicket getEstado() {
        return estado;
    }

    public String getTecnicoQueResolvio() {
        return tecnicoQueResolvio;
    }

    public int getId() {
        return id;
    }
}
