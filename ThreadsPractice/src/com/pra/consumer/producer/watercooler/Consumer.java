package com.pra.consumer.producer.watercooler;

import java.util.List;

public class Consumer implements Runnable{

	private List<Integer> mySharedList;
	private Object mutex;



	public Consumer(List<Integer> sharedList,Object mutex) {

		this.mySharedList=sharedList;
		this.mutex=mutex;

	}
	@Override
	public void run() {

		while(!Thread.currentThread().isInterrupted())
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
				
				// Properly deal with InterruptedException by restoring the interrupted state so the interruption is not lost.
				 Thread.currentThread().interrupt();
			}
			synchronized (mySharedList) {
				while(mySharedList.isEmpty())
				{
					System.out.println("IS EMPTY");

					try {
						synchronized (mutex) {
							mutex.notify();
						}
						System.out.println("Consumer waiting");
						
						mySharedList.wait();
						System.out.println("Consumer waiting exit");
					} catch (InterruptedException e) {
						e.printStackTrace();
						
						// Properly deal with InterruptedException by restoring the interrupted state so the interruption is not lost.
						 Thread.currentThread().interrupt();
					}
				}

				System.out.println("Drinking "+mySharedList.remove(0));
			}
		}
	}

}
