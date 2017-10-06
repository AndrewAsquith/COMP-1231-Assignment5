
/**
 * COMP-1231 Assignment 5 package
 * @author Andrew Asquith
 */
package com.andrewasquith.comp1231.assignment5;

/**
 * Import the Arrays class for the toString
 */
import java.util.Arrays;

/**
 * Import the Random class for the random number generator
 */
import java.util.Random;

/**
 * ShellArray class containing an internal array of
 * Integer objects and implementing the Shell Sort Algorithm 
 */
public class ShellArray {


	/**
	 * default size if not provided by constructor
	 */
	private final static int DEFAULT_SIZE = 10;

	// bitfield for output options from the shell sort
	/**
	 * no output during sort
	 */
	public final static int OUTPUT_NONE = 0;
	
	/**
	 * output state of array after each gap round
	 */
	public final static int OUTPUT_DEBUG = 1;

	/**
	 * output state of array with gap and index after each operation
	 */
	public final static int OUTPUT_VERBOSE = 2;

	/**
	 * the internal array containing the Integer objects
	 */
	Integer[] data;

	/**
	 * default constructing using default size
	 */
	public ShellArray() {
		this(DEFAULT_SIZE);
	}

	/**
	 * constructor accepting a size for the array
	 * @param size for the array
	 */
	public ShellArray(int size) {

		// if the size provided is invalid, use the default
		if (size <= 0) {
			size = DEFAULT_SIZE;
		}

		//initialize the array to the appropriate size
		data = new Integer[size];

		// use the random number generator instead of Math.Random
		Random rng = new Random();

		// fill the array to whatever size was requested
		for (int i = 0; i < size; i++) {
			// use the whole 2^32 range for possible values
			// data[i] = new Integer(rng.nextInt());
			// size * 10 as the upper bound
			data[i] = new Integer(rng.nextInt(size * 10) + 1);
		}
	}

	/**
	 *  default implementation of ShellSort that does not print out
	 *  the array after each action
	 */
	public void ShellSort() {
		this.ShellSort(OUTPUT_NONE);
	}

	/**
	 * implementation of the shell sort algorithm accepting integer
	 * as a parameter to specify the verbosity of the output
	 * @param outputFlags determines verbosity of output while sorting
	 */
	public void ShellSort(int outputFlags) {

		// gap is initially half the size
		int gap = data.length / 2;

		// run through the loop until gap is greater than 0
		do {
			// initialize the swap flag
			boolean swapFlag = true;

			// repeat until no swaps are made
			do {

				// haven't swapped anything this iteration
				swapFlag = false;

				// for the portion of the array for this round (start to size - gap)
				for (int i = 0; i < data.length - gap; i++) {
					
					//if verbose output was requested print the gap, index and state of array
					if ((outputFlags & OUTPUT_VERBOSE) == OUTPUT_VERBOSE) {
						System.out.println("Gap: " + gap + " " + "index: " + i 
								+ System.lineSeparator() + toString());
					}
					
					// if the element at the index is larger than index + gap
					if (data[i].compareTo(data[i + gap]) >= 1) {

						// swap the elements
						swapElements(i, i + gap);

						// mark the swap flag as true so the loop will repeat
						swapFlag = true;
					}
				}

				// do while swaps occur
			} while (swapFlag == true);

			//if debug outout requested, print the gap size and array state 
			if ((outputFlags & OUTPUT_DEBUG) == OUTPUT_DEBUG) {
				System.out.println("After Gap: " + gap + System.lineSeparator() + toString());
			}
			
			// every iteration decrease the gap by half
			gap = gap / 2;
			
			// do while the gap is larger than 0
		} while (gap > 0);
	}

	/**
	 * private method to swap the two elements at the provided indexes
	 * @param position1 the position of the first element to swap
	 * @param position2 the position of the second element to swap with
	 */
	private void swapElements(int position1, int position2) {

		// temp variable to store one of the elements
		Integer temp;

		// save position 1 to temp
		temp = data[position1];

		// put position2 in position1
		data[position1] = data[position2];

		// put position1 in position2
		data[position2] = temp;
	}

	/**
	 * toString implementation that uses the Arrays.toString implementation to
	 * pretty print the contents of the array
	 */
	public String toString() {
		return Arrays.toString(data);
	}
}
