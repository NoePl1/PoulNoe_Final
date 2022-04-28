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
		/*
		You can either prepare your input as an array, or add it directly to your
		Skeleton.SimulationInput object (see below).

			ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
			input.add(
				// The time to run in seconds
				new ArrayList<String>(Arrays.asList("Time", "600"))
			);
			input.add(
				// The number of actions units must perform per second
				new ArrayList<String>(Arrays.asList("ActionsPerSecond", "60"))
			);
		*/ 

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

		/*
			Add many more tests below using different input. Try to probe for edge cases and organize
			your tests properly.
		*/

		// You can change the input, and then reset the statistics singleton with:
		// input = new Skeleton.SimulationInput();
		// // ... Add input
		// si.resetInstance(input);
	}
}
