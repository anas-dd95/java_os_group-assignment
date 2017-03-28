package com;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task4 implements Runnable {
	
	private String filename;
	private Scanner scan;
	private long startTime, endTime;
	
	public Task4(long startTime) throws IOException {
		// open file for reading
		filename = "file.txt";
		scan = new Scanner(new File(filename)); // open file 
		System.out.println("Creating Task 4");
		this.startTime = startTime; // set start time
	}

	@Override
	public void run() {
		System.out.println("Running Task 4");
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; // set min as largest value, max as lowest value
		while (scan.hasNextInt()) { // if not end of line
			int tmp = scan.nextInt(); // read line from file
			if (min > tmp) {
				min = tmp;
			}
			if (max < tmp) {
				max = tmp;
			}
		}
		System.out.printf("Task 4: Min = %d, Max = %d\n", min, max);
		
		endTime = System.currentTimeMillis(); // get end time
		System.out.println("Stopping Task 4");
		
		System.out.println("----- Total Time Task 4: " +(endTime-startTime)+ "ms"); // calculating total time
	}

}
