package org.par.searching;

/**
 * The array needs to be sorted.
 * Average and worst search runtime f(n)=O(log n)
 * 
 * @author Harinder Singh Bedi
 *
 */
public class BinarySearch {

	private static int[] myArray=new int[]{5,8,12,14,55,65,88};

	public static void main(String[] args) {
		int start,end,size,mid,loc,find;

		find=88;

		size=myArray.length;		

		start=0;
		end=size-1;
		mid=(start+end)/2;		

		loc=0;

		while(start<=end)
		{
			if(myArray[mid]==find)
			{	loc=mid+1;
			break;
			}
			else if(find>myArray[mid])
				start=mid+1;
			else
				end=mid-1;

			mid=(start+end)/2;

		}

		if(loc==0)
			System.out.println("Element not found in array");
		else
			System.out.println("Element found at location "+loc);


	}
}

