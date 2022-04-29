package simulation.tickets;

import Skeleton.SimulationInput;

public class Business extends Ticket {

    public Business(String flightName, SimulationInput input) {
        super(flightName, input);
    }

    @Override
    public int cost() {
        return input.getIntegerInput("BusinessPrice");
    }
}
