package com.andrewasquith.comp1231.assignment5;

public class ShellArrayDriver {

	public static void main(String[] args) {
		ShellArray array1 = new ShellArray(1);
		System.out.println("Array 1 - Size 1:");
		array1.ShellSort();
		System.out.println("------------------");
		System.out.println("Array 2 - Size 10:");
		ShellArray array2 = new ShellArray();
		array2.ShellSort();
		System.out.println("------------------");
		System.out.println("Array 3 - Size 20:");
		ShellArray array3 = new ShellArray(20);
		array3.ShellSort();
	}

}
