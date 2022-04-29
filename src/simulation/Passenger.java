package simulation;

import Skeleton.*;
import simulation.planes.Plane;
import simulation.tickets.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Passenger class, capable of buying a ticket and observing a Plane
 */
public class Passenger extends Unit implements Observer {

    private Ticket ticket;
    private int money;
    private final String flightName;
    private FlightList flightList;
    private static Statistics passengerStats;

    private final Random r = new Random();

    /**
     * Constructor for Passenger.
     *
     * @param name       name of the Passenger
     * @param input      input
     * @param flightName name of the flight
     */
    public Passenger(String name, SimulationInput input, String flightName) {
        super(name, input);
        this.flightName = flightName;
        int min = input.getIntegerInput("MinMoney");
        int max = input.getIntegerInput("MaxMoney");
        this.money = r.nextInt(max - min) + min;
        passengerStats = StatisticsContainer.getInstance().addComponent("GlobalStats");

        this.getStats().addStatistic(
                "StartMoney",
                new WorkerStatistic("StartMoney")
        );

        this.getStats().addStatistic(
                "EndMoney",
                new WorkerStatistic("EndMoney")
        );

        this.getStats().addStatistic(
                "NumberOfExtras",
                new WorkerStatistic("NumberOfExtras")
        );

        passengerStats.addStatistic(
                "AverageMoneySpent",
                new AverageStatistic("AverageMoneySpent")
        );

        passengerStats.addStatistic(
                "FirstClassBought",
                new WorkerStatistic("FirstClassBought")
        );

        passengerStats.addStatistic(
                "BusinessBought",
                new WorkerStatistic("BusinessBought")
        );

        passengerStats.addStatistic(
                "EconomyBought",
                new WorkerStatistic("EconomyBought")
        );
    }

    /**
     * Method called when Passenger is notified.
     *
     * @param plane plane to board/unobserve
     */
    @Override
    public void update(Plane plane) {
        plane.board(this);
        System.out.println("Passenger : " + getName() + " Boarded the flight : " + plane.getName());
        plane.unobserve(this);
    }

    /**
     * Passenger buys a ticket if it doesn't have one and observes the Plane corresponding to it.
     */
    @Override
    public void performAction() {
        if (ticket == null) {
            buyTicket();
        }
        if (ticket != null) {
            if (ticket.isUsed() == false) {
                ArrayList<Plane> flights = flightList.getInstance().getFlightList();
                for (int i = 0; i < flights.size(); i++) {
                    if (flights.get(i).getName().equals(ticket.getFlightName())) {
                        flights.get(i).observe(this);
                        ticket.use();
                    }
                }
            }
        }
    }

    @Override
    public void submitStatistics() {

    }

    /**
     * Method to buy a ticket and the extras.
     */
    public void buyTicket() {
        int startMoney = money;

        if (money >= getSimInput().getIntegerInput("FirstClassPrice")) {
            ticket = new FirstClass(flightName, getSimInput());
            System.out.println("Passenger : " + getName() + " bought a FirstClass ticket for flight : " + flightName);
            passengerStats.getStatistic("FirstClassBought").addValue(1);
        } else if (money >= getSimInput().getIntegerInput("BusinessPrice")) {
            ticket = new Business(flightName, getSimInput());
            System.out.println("Passenger : " + getName() + " bought a Business ticket for flight : " + flightName);
            passengerStats.getStatistic("BusinessBought").addValue(1);
        } else if (money >= getSimInput().getIntegerInput("EconomyPrice")) {
            ticket = new Economy(flightName, getSimInput());
            System.out.println("Passenger : " + getName() + " bought an Economy ticket for flight : " + flightName);
            passengerStats.getStatistic("EconomyBought").addValue(1);
        }

        if (ticket != null) {
            int balance = money - ticket.cost();

            if (balance >= getSimInput().getIntegerInput("ExtraInsurancePrice") && r.nextInt(2) == 0) {
                ticket = new ExtraInsurance(ticket);
                balance = money - ticket.cost();
                getStats().getStatistic("NumberOfExtras").addValue(1);
            }
            if (balance >= getSimInput().getIntegerInput("ExtraLuggagePrice") && r.nextInt(2) == 0) {
                ticket = new ExtraLuggage(ticket);
                balance = money - ticket.cost();
                getStats().getStatistic("NumberOfExtras").addValue(1);
            }
            if (balance >= getSimInput().getIntegerInput("ExtraWindowSeatPrice") && r.nextInt(2) == 0) {
                ticket = new ExtraWindowSeat(ticket);
                balance = money - ticket.cost();
                getStats().getStatistic("NumberOfExtras").addValue(1);
            }

            money = balance;

            getStats().getStatistic("StartMoney").addValue(startMoney);
            getStats().getStatistic("EndMoney").addValue(money);
            passengerStats.getStatistic("AverageMoneySpent").addValue(startMoney - money);
        }
    }
}
