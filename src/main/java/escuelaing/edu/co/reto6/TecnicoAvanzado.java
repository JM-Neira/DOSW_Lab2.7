public class TecnicoAvanzado extends SoporteHandler {

    @Override
    protected boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel() == NivelDificultad.AVANZADO;
    }

    @Override
    protected void resolver(Ticket ticket) {
        ticket.marcarResuelto("Técnico Avanzado");
        System.out.println("Ticket " + ticket.getId()
                + ": Técnico Avanzado resolvió el problema.");
    }
}
