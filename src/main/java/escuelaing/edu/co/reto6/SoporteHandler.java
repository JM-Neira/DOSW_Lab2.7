public abstract class SoporteHandler {

    protected SoporteHandler siguiente;

    public void setSiguiente(SoporteHandler siguiente) {
        this.siguiente = siguiente;
    }

    public void procesar(Ticket ticket) {

        if (puedeResolver(ticket)) {
            resolver(ticket);
        } else if (siguiente != null) {
            siguiente.procesar(ticket);
        } else {
            ticket.marcarPendiente();
            System.out.println("Ticket " + ticket.getId()
                    + ": Ningún técnico disponible. Pendiente de escalamiento.");
        }
    }

    protected abstract boolean puedeResolver(Ticket ticket);

    protected abstract void resolver(Ticket ticket);
}
