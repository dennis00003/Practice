package org.par.other.programs;

public class FibWithArray {

	public static void main(String[] args) {
	
		int size=9;
		
		int [] fibArr=new int[size];
		fibArr[0]=1;
		fibArr[1]=1;	
		
		
		for(int i=2;i<size;i++)
		{
			fibArr[i]=fibArr[i-2]+fibArr[i-1];		
			
		}
		
		for(int i=0;i<size;i++)
			System.out.println(fibArr[i]);
		
	}

}
