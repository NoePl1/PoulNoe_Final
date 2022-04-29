package simulation.tickets;

public class ExtraLuggage extends Extra {

    public ExtraLuggage(Ticket t) {
        super(t);
    }

    @Override
    public int cost() {
        return ticket.cost() + ticket.input.getIntegerInput("ExtraLuggagePrice");
    }
}
