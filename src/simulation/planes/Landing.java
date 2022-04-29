package simulation.planes;

/**
 * Landing state
 */
public class Landing extends State {

    /**
     * Constructor
     *
     * @param plane plane
     */
    public Landing(Plane plane) {
        super(plane);
    }

    /**
     * Plane is on Runway so Runway is locked using the semaphore.
     */
    @Override
    public void performAction() {
        try {
            plane.getRunway().getPlaneSem().acquire();
            Thread.sleep(r.nextInt(40) + 10);
            System.out.println(plane.getName() + " landed at origin airport.");
            plane.getRunway().getPlaneSem().release();

            plane.changeState(new Boarding(plane));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Submits the statistics for the number of roundtrips done by the plane
     */
    @Override
    public void submitStatistics() {
        plane.getStats().getStatistic("Roundtrips").addValue(1);
    }
}
