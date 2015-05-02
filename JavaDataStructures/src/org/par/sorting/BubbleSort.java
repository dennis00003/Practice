package org.par.sorting;


/**
 * Average and worst runtime f(n)=O(n^2)
 * 
 * Its considered good for already sorted and small data. Otherwise go for Quicksort
 * 
 * @author Harinder Singh Bedi
 * 
 * 
 *
 */
public class BubbleSort {

	private static int[] myTestArray=new int[]{50,33,47,84,32,5,87,38};

	public static void main(String[] args) {

		int swap,n;		
		n=myTestArray.length;
		
		for(int a=1;a<n;a++)
		{
			for(int b=0;b<n-a;b++)
			{
				if(myTestArray[b]>myTestArray[b+1])
				{
					swap=myTestArray[b];
					myTestArray[b]=myTestArray[b+1];					
					myTestArray[b+1]=swap;
				}
			}			
		}
		
		 for (int i = 0; i < n; i++) {
		      System.out.println(myTestArray[i]);
		  }

	}

}
