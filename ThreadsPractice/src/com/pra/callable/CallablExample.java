package com.pra.callable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* java.util.concurrent.Callable has been introduced in JDK 5 . 
 * Callable is a thread that returns the result. 
 * There is a method call() in Callable interface that must be overridden for computation task. 
 * To run Callable, submit() method of ExecutorService is used. 
 * ExecutorService also provides invokeAll() and invokeAny () method to run Callable threads. 
 * To fetch the result of call() method of Callable interface, java provides Future class. 
 * ExecutorService.submit() method returns Future instance and then get() method of Future, 
 * returns the result of call() method of Callable.
 * call() in Callable Interface
 * call() method returns the result. The result can be object of the class which has been declared in class declaration. 
 * The basic purpose of call() method is computation of result. 
 * This is same as run() method of Runnable interface but returns the result.
*/ 
public class CallablExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service =  Executors.newSingleThreadExecutor();
		SumTask sumTask = new SumTask(20);
		Future<Integer> future = service.submit(sumTask);
		Integer result = future.get();
		System.out.println(result);
	}
}
class SumTask implements Callable<Integer> {
	private int num = 0;
	public SumTask(int num){
		this.num = num;
	}
	@Override
	public Integer call() throws Exception {
		int result = 0;
		for(int i=1;i<=num;i++){
			result+=i;
		}
		return result;
	}
} 