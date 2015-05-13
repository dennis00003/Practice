package org.par.other.programs;
 
/**
 * Java program to find missing elements in a Integer array containing 
 *
 * @author Harinder Singh Bedi
 */
public class MissingNumberInArray {
 
    public static void main(String args[]) {

        // one missing number
    	System.out.println(getMissingNumber(new int[]{1, 2, 3, 4, 6}, 6));

    }

   

   /**
    * Java method to find missing number in array of size n containing

    * numbers from 1 to n only.
    * can be used to find missing elements on integer array of 
    * Formula used (n*(n+1))/2

    * numbers from 1 to 100 or 1 - 1000
    */
    private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = (totalCount * (totalCount + 1)) / 2;
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
 
        return expectedSum - actualSum;
    }
 
}


