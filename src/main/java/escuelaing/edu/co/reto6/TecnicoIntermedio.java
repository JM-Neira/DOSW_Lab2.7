public class TecnicoIntermedio extends SoporteHandler {

    @Override
    protected boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel() == NivelDificultad.INTERMEDIO;
    }

    @Override
    protected void resolver(Ticket ticket) {
        ticket.marcarResuelto("Técnico Intermedio");
        System.out.println("Ticket " + ticket.getId()
                + ": Técnico Intermedio resolvió el problema.");
    }
}
