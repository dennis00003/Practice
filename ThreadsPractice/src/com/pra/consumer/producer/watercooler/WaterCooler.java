package com.pra.consumer.producer.watercooler;

import java.util.ArrayList;
import java.util.List;

public class WaterCooler {

	final List<Integer> list=new ArrayList<Integer>();
	Object mutex=new Object();

	public static void main(String[] args) {
		new WaterCooler().run();
	}

	void run()
	{
		Producer producer=new Producer(list, 4,mutex);
		new Thread(producer).start();
		new Thread(new Consumer(list,mutex)).start();
		new Thread(new Consumer(list,mutex)).start();
		new Thread(new Consumer(list,mutex)).start();
		new Thread(new Consumer(list,mutex)).start();
	}


}
