package simulation;

import simulation.planes.Plane;

import java.util.ArrayList;

/**
 * Singleton class for the list of flights. Is checked using a double lock design pattern
 */
public class FlightList {

    private static volatile FlightList instance;
    private ArrayList<Plane> flightList = new ArrayList<Plane>();

    private FlightList(){
    }

    /**
     * Creates a Single instance of FlightList. Is verified using a double lock in order to
     * avoid the creation of two instances of FlightList in case the threads are executed at the same time.
     * @return the instance of FligthList
     */
    public static FlightList getInstance() {
        FlightList localRef = instance;
        if (localRef == null) {
            synchronized (FlightList.class) {
                localRef = instance;
                if (localRef == null) {
                    instance = localRef = new FlightList();
                }
            }
        }
        return localRef;
    }

    /**
     * Getter for the list of Flights
     * @return an array of planes
     */
    public synchronized ArrayList<Plane> getFlightList() {
        return flightList;
    }

    /**
     * Adds a plane to the list
     * @param plane plane to add
     */
    public synchronized void addPlane(Plane plane){
        flightList.add(plane);
    }

    /**
     * Removes a plane from the list
     * @param plane plane to remove
     */
    public synchronized void removePlane(Plane plane){
        flightList.remove(plane);
    }
}
