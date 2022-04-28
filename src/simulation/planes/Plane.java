package simulation.planes;

import Skeleton.SimulationInput;
import Skeleton.Unit;
import Skeleton.WorkerStatistic;
import simulation.FlightList;
import simulation.Observer;
import simulation.Passenger;
import simulation.Runway;

import java.util.ArrayList;
import java.util.Random;

/**
 * Plane class
 */
public class Plane extends Unit {

    private Runway runway;
    private Random r = new Random();
    private State state;
    private FlightList flightList;

    private ArrayList<Passenger> awaitingPassengers = new ArrayList();
    private ArrayList<Passenger> onBoardPassengers = new ArrayList();

    /**
     * Constructor for the Plane
     * @param name name of the Plane(flight)
     * @param input input
     * @param runway Runway
     */
    public Plane(String name, char state, SimulationInput input, Runway runway) {
        super(name, input);
        this.runway = runway;
        this.state = new Boarding(this);

        switch (state){
            case 'a': this.state = new Arrival(this); break;
            case 'b': this.state = new Boarding(this); break;
            case 'i': this.state = new InAir(this); break;
            case 'l': this.state = new Landing(this); break;
            case 't': this.state = new Takeoff(this); break;
            default : this.state = new Boarding(this); break;




        }


        this.getStats().addStatistic(
                "PassengersTransported",
                new WorkerStatistic("PassengersTransported")
        );

        this.getStats().addStatistic(
                "Roundtrips",
                new WorkerStatistic("Roundtrips")
        );

        flightList.getInstance().addPlane(this);
    }

    /**
     * Performs the actions at which State the Plane is at
     */
    @Override
    public void performAction() {
        state.performAction();
    }

    /**
     * Submits the statistics at which State the Plane is at
     */
    @Override
    public void submitStatistics() {
        state.submitStatistics();
    }

    /**
     * Changes the State of the Plane
     * @param state State to change to
     */
    public void changeState(State state) {
        this.state = state;
    }

    /**
     * Getter for the Runway
     * @return Runway
     */
    public Runway getRunway() {
        return runway;
    }

    /**
     * Getter for the Passengers on board of the Plane
     * @return the list of Passengers on board
     */
    public synchronized ArrayList<Passenger> getOnBoardPassengers() {
        return onBoardPassengers;
    }

    /**
     * Subscribes a Passenger to the Plane
     * @param p Passenger to subscribe to the Plane
     */
    public synchronized void observe(Passenger p){
        awaitingPassengers.add(p);
    }

    /**
     * Unsubscribes a Passenger to the Plane
     * @param p Passenger to unsubscribe to the Plane
     */
    public synchronized void unobserve(Passenger p){
        awaitingPassengers.remove(p);
    }

    /**
     * Notifies the Passengers subscribed to the Plane
     */
    public void notifyObservers(){
        for (int i = awaitingPassengers.size() - 1; i >= 0; i--) {
            awaitingPassengers.get(i).update(this);
        }
    }

    /**
     * Adds the Passenger on board of the Plane
     * @param p Passenger to add in the Plane
     */
    public synchronized void board(Passenger p){
        onBoardPassengers.add(p);
    }

    /**
     * Unboards all Passengers from the Plane
     */
    public void unboardAll() {
        while (!onBoardPassengers.isEmpty()){
            System.out.println(onBoardPassengers.get(0).getName() + " left the plane: " + getName());
            onBoardPassengers.remove(0);
        }
    }
}
