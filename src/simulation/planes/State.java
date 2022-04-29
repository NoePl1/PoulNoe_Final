package simulation.planes;

import java.util.Random;

/**
 * Abstract method to implement the State design pattern
 */
public abstract class State {

    protected Plane plane;
    protected Random r = new Random();

    /**
     * Constructor for the State
     *
     * @param plane plane
     */
    public State(Plane plane) {
        this.plane = plane;
    }

    /**
     * performAction of a State
     */
    public abstract void performAction();

    /**
     * submitStatistics of a State
     */
    public abstract void submitStatistics();
}
