/**
 * COMP 1231 Assignment 5 package
 * @author Andrew Asquith
 */
package com.andrewasquith.comp1231.assignment5;

/**
 * 
 * @author Andrew Asquith
 * ShellArrayDriver class exercising several
 * instances of the ShellArray Class
 *
 */
public class ShellArrayDriver {

	public static void main(String[] args) {
		//Array with size 1
		ShellArray array1 = new ShellArray(1);
		System.out.println("Array 1 - Size 1:");
		System.out.println("Initial State:");
		System.out.println(array1);
		array1.ShellSort();
		System.out.println("Sorted State:");
		System.out.println(array1);
		
		//Array with default size of 10
		System.out.println("------------------");
		System.out.println("Array 2 - Size 10:");
		ShellArray array2 = new ShellArray();
		System.out.println("Initial State:");
		System.out.println(array2);
		System.out.println("Debug Output:");
		array2.ShellSort(ShellArray.OUTPUT_DEBUG);
	
		//Array with size of 20
		System.out.println("------------------");
		System.out.println("Array 3 - Size 20:");

		ShellArray array3 = new ShellArray(20);
		System.out.println("Initial State:");
		System.out.println(array3);
		System.out.println("Verbose Output:");
		array3.ShellSort(ShellArray.OUTPUT_VERBOSE);
	
		//Array with invalid size - should become 10
		System.out.println("------------------");
		System.out.println("Array 4 - Size -7:");
		ShellArray array4 = new ShellArray(-7);
		System.out.println("Initial State:");
		System.out.println(array4);
		System.out.println("Debug Output:");
		array4.ShellSort(ShellArray.OUTPUT_DEBUG);
	}

}
