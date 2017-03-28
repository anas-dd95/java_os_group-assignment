package com;

public class Task3 implements Runnable {

	private int size = 30;
	private int[][] arr = new int[size][size];
	private long startTime, endTime;
	
	public Task3(long startTime) {
		// generate 30*30 items and insert into array
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = (int)(1 + (Math.random()*100));
			}
		}
		System.out.println("Creating Task 3");
		this.startTime = startTime; // set start time
	}
	
	@Override
	public void run() {
		System.out.println("Running Task 3");
		
		int max = arr[0][0]; // set maximum as first element of array
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size; j++) {
				if (max < arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
		System.out.println("Task 3: Max = " +max);
		
		endTime = System.currentTimeMillis(); // get end time
		System.out.println("Stopping Task 3");
		
		System.out.println("----- Total Time Task 3: " +(endTime-startTime)+ "ms"); // calculating total time
	}
}
