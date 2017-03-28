package com;

import java.util.LinkedList;
import java.util.Queue;

public class Task1 implements Runnable {
	
	private int size = 50;
	private Queue<Integer> q;
	private long startTime, endTime;
	
	public Task1(long startTime) {
		// generate 50 items and insert into queue
		q = new LinkedList<Integer>();
		for (int i = 0; i < size; i++) {
			int tmp = (int)(1 + (Math.random() * 100));
			q.add(tmp);
		}
		System.out.println("Creating Task 1");
		this.startTime = startTime; // set start time
	}
	
	public Queue<Integer> quicksort(Queue<Integer> seq) {
		// if queue size 0-1, return queue
		if (seq.size() <= 1) return seq;
		
		Queue<Integer> pivot  = new LinkedList<Integer>(), // queue for pivot
					   less   = new LinkedList<Integer>(), // queue for < pivot
					   more   = new LinkedList<Integer>(), // queue for > pivot
					   result = new LinkedList<Integer>(); // queue for final sorting
		
		pivot.add(seq.remove()); // retrieve pivot (first element of queue)
		
		while (!seq.isEmpty()) {
			int elm = seq.remove(); // retrieve and delete element from queue
			if (elm < pivot.peek()) less.add(elm); // if element < pivot, add to less
			else if (elm > pivot.peek()) more.add(elm); // if element > pivot, add to more
			else pivot.add(elm); // else element == pivot, add to pivot
		}
		
		less = quicksort(less); // quicksort less queue
		more = quicksort(more); // quicksort more queue
		
		while (!less.isEmpty()) result.add(less.remove()); // get all elements from less 
		while (!pivot.isEmpty()) result.add(pivot.remove()); // get all elements from pivot
		while (!more.isEmpty()) result.add(more.remove()); // get all elements from more
		return result; // return sorted queue
	}

	@Override
	public void run() {
		System.out.println("Running Task 1");
		
		q = quicksort(q);
		System.out.print("Task 1 / ");
		for (int i : q) { // print sorted queue
			System.out.printf("%d ", i);
		}
		System.out.println("/");
		
		endTime = System.currentTimeMillis(); // get end time
		System.out.println("Stopping Task 1");
		
		System.out.println("----- Total Time Task 1: " +(endTime-startTime)+ "ms"); // calculating total time
	}

}
