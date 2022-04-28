package simulation.tickets;

public class ExtraInsurance extends Extra {

    public ExtraInsurance(Ticket t){
        super(t);
    }

    @Override
    public int cost() {
        return ticket.cost() + ticket.input.getIntegerInput("ExtraInsurancePrice");
    }
}
