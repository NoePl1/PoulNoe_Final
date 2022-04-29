package simulation;

import simulation.planes.Plane;

import java.util.concurrent.Semaphore;

/**
 * Runway class
 */
public class Runway {

    private Semaphore planeSem = new Semaphore(1);
    private Plane plane = null;

    /**
     * Constructor for the Runway
     */
    public Runway() {

    }

    /**
     * Adds a Plane to the Runway
     *
     * @param plane Plane to add to the Runway
     */
    public void addPlane(Plane plane) {
        if (plane != null) {
            this.plane = plane;
        }
    }

    /**
     * Removes a Plane from the Runway
     */
    public void removePlane() {
        this.plane = null;
    }

    /**
     * Getter for the semaphore
     *
     * @return returns the semaphore
     */
    public Semaphore getPlaneSem() {
        return planeSem;
    }
}
