package simulation.planes;

/**
 * Takeoff State
 */
public class Takeoff extends State {

    /**
     * Constructor
     *
     * @param plane Plane
     */
    public Takeoff(Plane plane) {
        super(plane);
    }

    /**
     * Plane takes off
     */
    @Override
    public void performAction() {
        try {
            plane.getRunway().getPlaneSem().acquire();
            Thread.sleep(r.nextInt(40) + 10);
            System.out.println(plane.getName() + " took off");
            plane.getRunway().getPlaneSem().release();

            plane.changeState(new InAir(plane));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void submitStatistics() {

    }
}
