package simulation.planes;

/**
 * Boarding State
 */
public class Boarding extends State {

    /**
     * Constructor
     * @param plane plane
     */
    public Boarding(Plane plane) {
        super(plane);
    }

    /**
     * Passengers are notified that the plane is ready for boarding
     */
    @Override
    public void performAction() {

        System.out.println("Passengers notified for boarding " + plane.getName());
        plane.notifyObservers();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        plane.changeState(new Takeoff(plane));
    }

    @Override
    public void submitStatistics() {

    }
}
