package com;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();
		
		Thread thread1 = new Thread(new Task1(startTime));
		thread1.start();
		
		Thread thread2 = new Thread(new Task2(startTime));
		thread2.start();
		
		Thread thread3 = new Thread(new Task3(startTime));
		thread3.start();
		
		Thread thread4 = new Thread(new Task4(startTime));
		thread4.start();
	}
}


