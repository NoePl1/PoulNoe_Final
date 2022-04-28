package simulation.planes;

import java.util.Random;

/**
 * InAir State
 */
public class InAir extends State {

    /**
     * Constructor
     * @param plane plane
     */
    public InAir(Plane plane) {
        super(plane);
    }

    /**
     * Plane is flying to destination
     */
    @Override
    public void performAction() {
        try {
            System.out.println(plane.getName() + " in air");
            Thread.sleep(r.nextInt(40)+10);

            plane.changeState(new Arrival(plane));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Submits the statistic of the number of Passengers being transported
     */
    @Override
    public void submitStatistics() {
        plane.getStats().getStatistic("PassengersTransported").addValue(plane.getOnBoardPassengers().size());
    }
}
