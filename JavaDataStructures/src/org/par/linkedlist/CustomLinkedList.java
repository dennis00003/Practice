package org.par.linkedlist;

public class CustomLinkedList {

	Node head;
	int count;

	public CustomLinkedList() {
		head=new Node(null);
		count=0;
	}

	public void add(String dataVal){

		Node node=new Node(dataVal);

		Node tempNode=head;

		while(tempNode.getNext()!=null)
		{
			tempNode=tempNode.getNext();
		}

		tempNode.setNext(node);

		count++;
	}


	public int getSize(){
		return count;
	}

	public String get(int index){

		if(index<0)
			return null;

		Node node=head.getNext();
		for(int i=0;i<index;i++)
		{
			if (node.getNext() == null)
				return null;

			node=node.getNext();
		}

		return node.getData();
	}

	public static void main(String[] args) {

		CustomLinkedList customLinkedList=new CustomLinkedList();
		customLinkedList.add("1");
		customLinkedList.add("2");
		customLinkedList.add("3");
		customLinkedList.add("4");

		System.out.println(customLinkedList.getSize());
		
		System.out.println(customLinkedList.get(3));
	}


	private class Node{

		Node next;
		String data;


		public Node(String dataVal) {
			data=dataVal;
			next=null;
		}

		public String getData()
		{
			return data;
		}

		public Node getNext()
		{
			return next;
		}

		public void setNext(Node next)
		{
			this.next=next;
		}
	}

}
