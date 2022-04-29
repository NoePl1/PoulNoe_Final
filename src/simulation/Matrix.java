/*
 * Name : Noé Poulain
 * Date : 25/04/2022
 * Description : This program simulates an airport and gathers data on the Passengers and Flights.
 * */
package simulation;

import Skeleton.SimulationInput;
import simulation.planes.Plane;

/**
 * The class that is responsible for running the simulation.
 * <p>
 * You will need to modify the run method to initialize, and run all of your units.
 */
public class Matrix {
    public static void run(SimulationInput input) {
        // Run units
        Runway runway = new Runway();

        switch (input.getIntegerInput("Scenario")) {
            case 1:
                Plane plane1 = new Plane("AC817", 'l', input, runway);
                Plane plane2 = new Plane("AF213", 't', input, runway);
                Thread tp1 = new Thread(plane1);
                Thread tp2 = new Thread(plane2);

                Passenger pass1 = new Passenger("John", input, "AC817");
                Passenger pass2 = new Passenger("Sarah", input, "AC817");
                Passenger pass3 = new Passenger("Sacha", input, "AC817");
                Passenger pass4 = new Passenger("Audrey", input, "AF213");
                Thread tpass1 = new Thread(pass1);
                Thread tpass2 = new Thread(pass2);
                Thread tpass3 = new Thread(pass3);
                Thread tpass4 = new Thread(pass4);

                tp1.start();
                tp2.start();

                tpass1.start();
                tpass2.start();
                tpass3.start();
                tpass4.start();

                try {
                    tp1.join();
                    tp2.join();

                    tpass1.join();
                    tpass2.join();
                    tpass3.join();
                    tpass4.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                Plane plane4 = new Plane("AC817", 'b', input, runway);
                Plane plane5 = new Plane("AF213", 'b', input, runway);
                Plane plane6 = new Plane("TR344", 'b', input, runway);
                Thread tp4 = new Thread(plane4);
                Thread tp5 = new Thread(plane5);
                Thread tp6 = new Thread(plane6);

                Passenger pass6 = new Passenger("Cabe", input, "TR344");
                Passenger pass7 = new Passenger("Theo", input, "TR344");
                Passenger pass8 = new Passenger("Josh", input, "TR344");
                Passenger pass9 = new Passenger("Lea", input, "TR344");
                Thread tpass6 = new Thread(pass6);
                Thread tpass7 = new Thread(pass7);
                Thread tpass8 = new Thread(pass8);
                Thread tpass9 = new Thread(pass9);

                tp4.start();
                tp5.start();
                tp6.start();

                tpass6.start();
                tpass7.start();
                tpass8.start();
                tpass9.start();

                try {
                    tp4.join();
                    tp5.join();
                    tp6.join();

                    tpass6.join();
                    tpass7.join();
                    tpass8.join();
                    tpass9.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                Plane plane3 = new Plane("BN123", 'b', input, runway);
                Thread tp3 = new Thread(plane3);

                tp3.start();

                try {
                    tp3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case 4:
                Passenger pass5 = new Passenger("Arianne", input, "LA583");
                Thread tpass5 = new Thread(pass5);

                tpass5.start();

                try {
                    tpass5.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case 5:
                Plane plane7 = new Plane("AC817", 't', input, runway);
                Thread tp7 = new Thread(plane7);

                Passenger pass10 = new Passenger("Gary", input, "AC817");
                Thread tpass10 = new Thread(pass10);

                tp7.start();
                tpass10.start();

                try {
                    tp7.join();
                    tpass10.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
