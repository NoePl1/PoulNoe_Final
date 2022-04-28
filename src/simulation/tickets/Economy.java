package simulation.tickets;


import Skeleton.SimulationInput;
import Skeleton.Statistic;
import Skeleton.WorkerStatistic;

public class Economy extends Ticket {

    public Economy(String flightName, SimulationInput input) {
        super(flightName, input);
    }

    @Override
    public int cost() {
        return input.getIntegerInput("EconomyPrice");
    }
}
