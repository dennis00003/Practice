package org.par.other.programs;
public class ArrayReverse {

	/**
	* @param args
	*/
	public static void main(String[] args) {

		int[] a={1,2,4,5};
		
		for(int i=0;i<a.length/2;i++)
		{
			swap(a, i, a.length-1-i);;
		}
		
		System.out.println(a[0]);

	}

	
	static void swap(int[] arr,int f, int l)
	{
		int tmp=arr[f];
		
		arr[f]=arr[l];
		arr[l]=tmp;
	}
	
}

