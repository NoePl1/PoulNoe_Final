package simulation.tickets;

import Skeleton.SimulationInput;

public class FirstClass extends Ticket{

    public FirstClass(String flightName, SimulationInput input){
        super(flightName, input);
    }
    @Override
    public int cost() {
        return input.getIntegerInput("FirstClassPrice") ;
    }
}
