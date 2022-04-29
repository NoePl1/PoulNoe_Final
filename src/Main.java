import Skeleton.SimulationInput;
import Skeleton.StatisticsContainer;
import Skeleton.Unit;
import Skeleton.WorkerStatistic;
import simulation.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class is responsible for the testing. It has a helper method
 * that makes it easier to run many tests.
 **/
public class Main {
	/**
	 * Runs a test with the given input and returns the statistics
	 * produced from the test run. Simplifies the testing process.
	 * 
	 * @param input The input to run the test with.
	 * @return The statistics of the test run.
	 **/
	public static StatisticsContainer runTest(SimulationInput input) {
		// Initialize the stats singleton here so the input can
		// be ignored in future calls
		StatisticsContainer stats = StatisticsContainer.getInstance(input);
		Matrix.run(input);

		return stats;
	}

	/**
	 * See method above for details.
	 **/
	public static StatisticsContainer runTest(ArrayList<ArrayList<String>> input) {
		return runTest(new SimulationInput(input));
	}

	public static void main(String[] args) {

		//--------------TEST 1-----------------
		SimulationInput si = new SimulationInput();

		//Change these values to modify the duration and the number of actions per second of the simulation
		si.addInput("Time", List.of("10")); // In seconds
		si.addInput("ActionsPerSecond", List.of("1"));

		//Change these values to change the minimum and maximum amount of money of the passengers
		si.addInput("MinMoney", List.of("250"));
		si.addInput("MaxMoney", List.of("3000"));

		//Change these values to modify the price of tickets and extras
		si.addInput("EconomyPrice", List.of("250"));
		si.addInput("BusinessPrice", List.of("1000"));
		si.addInput("FirstClassPrice", List.of("3000"));
		si.addInput("ExtraInsurancePrice", List.of("40"));
		si.addInput("ExtraLuggagePrice", List.of("100"));
		si.addInput("ExtraWindowSeatPrice", List.of("20"));

		/*Change this value to select a scenario for testing
		* 1 - 2 planes 4 passengers
		* 2 - 3 planes 4 passengers all in the same plane
		* 3 - 1 plane  0 passengers
		* 4 - 0 plane  1 passenger
		* 5 - 1 plane  1 passenger
		* */
		si.addInput("Scenario", List.of("5"));

		// Run the simulation
		StatisticsContainer stats = runTest(si);

		// Post the finalized statistics
		stats.printStatisticsContainer();

		//--------------TEST 2-----------------
		SimulationInput si2 = new SimulationInput();

		//Change these values to modify the duration and the number of actions per second of the simulation
		si2.addInput("Time", List.of("20")); // In seconds
		si2.addInput("ActionsPerSecond", List.of("1"));

		//Change these values to change the minimum and maximum amount of money of the passengers
		si2.addInput("MinMoney", List.of("0"));
		si2.addInput("MaxMoney", List.of("1"));

		//Change these values to modify the price of tickets and extras
		si2.addInput("EconomyPrice", List.of("250"));
		si2.addInput("BusinessPrice", List.of("1000"));
		si2.addInput("FirstClassPrice", List.of("3000"));
		si2.addInput("ExtraInsurancePrice", List.of("40"));
		si2.addInput("ExtraLuggagePrice", List.of("100"));
		si2.addInput("ExtraWindowSeatPrice", List.of("20"));

		/*Change this value to select a scenario for testing
		 * 1 - 2 planes 4 passengers
		 * 2 - 3 planes 4 passengers all in the same plane
		 * 3 - 1 plane  0 passengers
		 * 4 - 0 plane  1 passenger
		 * 5 - 1 plane  1 passenger
		 * */
		si2.addInput("Scenario", List.of("5"));

		//Resets the stats container
		StatisticsContainer.resetInstance(si2);

		// Run the simulation
		stats = runTest(si2);

		// Post the finalized statistics
		stats.printStatisticsContainer();

		//--------------TEST 3-----------------
		SimulationInput si3 = new SimulationInput();

		//Change these values to modify the duration and the number of actions per second of the simulation
		si3.addInput("Time", List.of("10")); // In seconds
		si3.addInput("ActionsPerSecond", List.of("0"));

		//Change these values to change the minimum and maximum amount of money of the passengers
		si3.addInput("MinMoney", List.of("250"));
		si3.addInput("MaxMoney", List.of("3000"));

		//Change these values to modify the price of tickets and extras
		si3.addInput("EconomyPrice", List.of("250"));
		si3.addInput("BusinessPrice", List.of("1000"));
		si3.addInput("FirstClassPrice", List.of("3000"));
		si3.addInput("ExtraInsurancePrice", List.of("40"));
		si3.addInput("ExtraLuggagePrice", List.of("100"));
		si3.addInput("ExtraWindowSeatPrice", List.of("20"));

		/*Change this value to select a scenario for testing
		 * 1 - 2 planes 4 passengers
		 * 2 - 3 planes 4 passengers all in the same plane
		 * 3 - 1 plane  0 passengers
		 * 4 - 0 plane  1 passenger
		 * 5 - 1 plane  1 passenger
		 * */
		si3.addInput("Scenario", List.of("5"));

		//Resets the stats container
		StatisticsContainer.resetInstance(si3);

		// Run the simulation
		stats = runTest(si3);

		// Post the finalized statistics
		stats.printStatisticsContainer();

	}
}
