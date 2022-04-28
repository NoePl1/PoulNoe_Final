package simulation;

import simulation.planes.Plane;

/**
 * Interface for the Observer design pattern
 */
public interface Observer {

    void update(Plane plane);
}
