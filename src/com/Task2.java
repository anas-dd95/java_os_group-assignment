package com;

public class Task2 implements Runnable {
	
	private int size = 100;
	private int[] arr;
	private long startTime, endTime;
	
	public Task2(long startTime) {
		// Generate 100 items and insert into 1d array
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = (int)(1 + (Math.random() * 100));
		}
		System.out.println("Creating Task 2");
		this.startTime = startTime; // set start time
	}

	@Override
	public void run() {
		System.out.println("Running Task 2");
		
		for (int i = 0; i < size; i++) {
			System.out.println("Task 2: " +arr[i]); // read and print element
		}
		
		endTime = System.currentTimeMillis(); // get end time
		System.out.println("Stopping Task 2");
		
		System.out.println("----- Total Time Task 2: " +(endTime-startTime)+ "ms"); // calculating total time
	}

}
