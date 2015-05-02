package org.par.stack;

public class MyStack {

	int maxSize;
	int[] myStackArray;
	int top;

	public MyStack(int size) {		
		maxSize=size;
		myStackArray=new int[maxSize];
		top=-1;
	}

	public void push(int val)
	{
		myStackArray[++top]=val;
	}

	public int pop(){
		return myStackArray[top--];
	}

	public int peek(){
		return myStackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {


		MyStack myStack=new MyStack(10);
		myStack.push(5);
		myStack.push(10);
		System.out.println(myStack.peek());
		System.out.println(myStack.pop());
		System.out.println(myStack.peek());
		myStack.push(15);
		myStack.push(20);
		myStack.push(25);
		System.out.println(myStack.peek());

	}

}
