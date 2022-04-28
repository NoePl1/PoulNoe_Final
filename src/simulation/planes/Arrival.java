package simulation.planes;

/**
 * Arrival State
 */
public class Arrival extends State{

    /**
     * Constructor
     * @param plane plane
     */
    public Arrival(Plane plane) {
        super(plane);
    }

    /**
     * Plane has arrived at destination, Passengers leave the plane.
     */
    @Override
    public void performAction() {

        System.out.println(plane.getName() + " arrived at destination.");
        plane.unboardAll();

        try {
            Thread.sleep(r.nextInt(100)+100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        plane.changeState(new Landing(plane));
    }

    @Override
    public void submitStatistics() {

    }
}
