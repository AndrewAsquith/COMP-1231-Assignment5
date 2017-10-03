/**
 * 
 */
package com.andrewasquith.comp1231.assignment5;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Andrew
 *
 */
public class ShellArray {

	private final static int  DEFAULT_SIZE = 10;
	Integer[] data;
	
	public ShellArray() {
		this(DEFAULT_SIZE);
	}

	public ShellArray(int size) {
		
		data = new Integer[size];
		
		//use the random number generator instead of Math.Random
		Random rng = new Random();
		
		// fill the array to whatever size was requested
		for (int i = 0; i < size; i++) {
			// use the whole 2^32 range for possible values
			//data[i] = new Integer(rng.nextInt());
			// size * 10 as the upper bound
			data[i] = new Integer(rng.nextInt(size*10) + 1);
		}
	}
	
	public void ShellSort() {
		

		
		int gap = data.length / 2;
		
		do {
			boolean swapFlag = true;
			
			do {
				
				swapFlag = false;
				for (int i = 0; i<data.length - gap; i++) {
					System.out.println("Gap: " + gap + " " + "index: " + i + System.lineSeparator() + toString());
					if (data[i].compareTo(data[i+gap]) >= 1) {
						
						swapElements(i, i+gap);
						swapFlag = true;
						
						
					}
				}
				
			} while (swapFlag == true);
			gap = gap / 2;
		//	System.out.println(toString());
		} while (gap > 0);
	}

	private void swapElements(int position1, int position2) {
		Integer temp;
		
		temp = data[position1];
		data[position1] = data[position2];
		data[position2] = temp;
		
	}
	
	public String toString() {
		return Arrays.toString(data);
	}

}
