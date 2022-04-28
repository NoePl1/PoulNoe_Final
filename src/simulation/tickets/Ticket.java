package simulation.tickets;

import Skeleton.SimulationInput;

/**
 * Abstract class to represent a Ticket. Implements a Decorator design pattern
 */
public abstract class Ticket {

    private String flightName;
    protected SimulationInput input;
    private Boolean used;

    /**
     * Constructor for a Ticket without Extras
     * @param flightName name of the flight
     * @param input input to set the price of the different options
     */
    public Ticket(String flightName, SimulationInput input) {
        this.flightName = flightName;
        this.input = input;
        used = false;
    }

    /**
     * Getter for the flightName
     * @return the name of the flight
     */
    public String getFlightName() {
        return flightName;
    }

    /**
     * Cost of the Ticket
     * @return the cost of the Ticket
     */
    public abstract int cost();

    /**
     * Checks if the Ticket is used
     * @return used
     */
    public boolean isUsed(){
        return used;
    }

    /**
     * Sets used to true
     */
    public void use(){
        used = true;
    }
}

