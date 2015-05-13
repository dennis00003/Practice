package com.pra.consumer.producer.watercooler;

import java.util.List;

public class Producer implements Runnable {

	private List<Integer> mySharedList;
	int size;
	private Object mutex;

	public Producer(List<Integer> sharedList,int size, Object mutex) {

		this.mySharedList=sharedList;
		this.size=size;
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
				System.out.println("Size is "+mySharedList.size());

				if(mySharedList.isEmpty()) // Water cooler is empty fill it up 
				{
					for(int i=1;i<=size;i++){
						System.out.println("Adding water "+i);
						mySharedList.add(i);
					}
					mySharedList.notifyAll();
				}

			}

				try {
					System.out.println("Producer waiting");
					synchronized (mutex) {
						mutex.wait();
					}
					
					System.out.println("Producer waiting exit");
				} catch (InterruptedException e) {
					e.printStackTrace();
					
					// Properly deal with InterruptedException by restoring the interrupted state so the interruption is not lost.
					 Thread.currentThread().interrupt();
				}



			}

		
	}

}
