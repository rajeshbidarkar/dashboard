package com.threadcontrol.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadController implements IController{
	Semaphore semaphore = null;
	
	
	public ThreadController(int i) {
		semaphore = new Semaphore(i);
	}

	@Override
	public void release() throws InterruptedException {
		semaphore.release();
	}

	@Override
	public void acquire() throws InterruptedException {
		semaphore.acquire();
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws InterruptedException { 
		ThreadController tc = new ThreadController(3);
		List<Thread> tlist = new ArrayList();
		Task myThreads[] = new Task[5];
		for (int j = 0; j < 5; j++) {
			myThreads[j] = new Task();
			tlist.add(new Thread(myThreads[j]));
		
		}
		for (Thread t : tlist) {
			t.start();
		//	t.join();
		}
		System.out.println("counter:"+Task.counter);
		
		
	}


}

class Task implements  Runnable {
	static int counter=0;
	ThreadController tc = new ThreadController(5);
	public void run() {
		try {
			myfunc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void myfunc() throws InterruptedException {
		try {
			tc.acquire();
			Random r = new Random();
			int time = r.nextInt(10000);
			Thread.currentThread().sleep(time);
			System.out.println("time waited:"+time+" Running:"+counter+++ " Current Locks:"+tc.semaphore.availablePermits()+" name:"+Thread.currentThread().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			tc.release();
		}
		
	}

}
