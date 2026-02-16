public class TecnicoBasico extends SoporteHandler {

    @Override
    protected boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel() == NivelDificultad.BASICO;
    }

    @Override
    protected void resolver(Ticket ticket) {
        ticket.marcarResuelto("Técnico Básico");
        System.out.println("Ticket " + ticket.getId()
                + ": Técnico Básico resolvió el problema.");
    }
}
