package simulation.tickets;

/**
 * Abstract class for the Extras of the Ticket. Implements a Decorator design pattern
 */
public abstract class Extra extends Ticket {
    protected Ticket ticket;

    /**
     * Constructor for a Ticket with Extras
     *
     * @param t Ticket
     */
    public Extra(Ticket t) {
        super(t.getFlightName(), t.input);
        this.ticket = t;
    }
}
