package com.executor.callable.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

	public static void main(String[] args) {
		  ExecutorService executor = Executors.newFixedThreadPool(5);
		  for (int i = 0; i < 10; i++) {
			  new WorkerThread();
		       Runnable worker = new WorkerThread(" " + i);
		      // executor.execute(worker);
		  }
		  executor.shutdown();
		  while (!executor.isTerminated()) {
		  }
		  System.out.println("Finished all threads");
		  int [][] twoDArray = {     
			        {1,  2,  3,  4,  40},
			        {5,  6,  7,  8,  50},
			        {9,  10, 11, 12, 60},
			        {13, 14, 15, 16, 70},
			        {17, 18, 19, 20, 80},
			        {21, 22, 23, 24, 90},
			        {25, 26, 27, 28, 100},
			        {29, 30, 31, 32, 110},
			        {33, 34, 35, 36, 120}};

			List list = new ArrayList();
			for (int[] array : twoDArray) {
			    //This will add int[] object into the list, and not the int values.
			    list.add(Arrays.asList(array));
			}
		  System.out.println(list);
		  
	}

}
