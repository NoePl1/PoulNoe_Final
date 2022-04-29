package simulation.tickets;

public class ExtraWindowSeat extends Extra {

    public ExtraWindowSeat(Ticket t) {
        super(t);
    }

    @Override
    public int cost() {
        return ticket.cost() + ticket.input.getIntegerInput("ExtraWindowSeatPrice");
    }
}
