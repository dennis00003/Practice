package org.par.sorting;
 

/**
 *  Quicksort or partition-exchange sort, is a fast sorting algorithm, which is using divide and conquer algorithm. Quicksort first divides a large list into two smaller sub-lists: the low elements and the high elements. Quicksort can then recursively sort the sub-lists.
 *
 *	Steps to implement Quick sort:
 *
 *	1) Choose an element, called pivot, from the list. Generally pivot can be the middle index element.
 *	2) Reorder the list so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
 *	3) Recursively apply the above steps to the sub-list of elements with smaller values and separately the sub-list of elements with greater values.
 * 
 *  @author Harinder Singh Bedi
 *
 */
public class QuickSort {
     
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        for(int i:array){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking middle as pivot
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                System.out.println(pivot);
                for(int a:array){
                    System.out.print(a);
                    System.out.print(" ");
                }
                System.out.println();
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
         
        QuickSort sorter = new QuickSort();
        
        //int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        int[] input = { 1,5,3,8,2 };
        sorter.sort(input); 
        for(int i:input){
            System.out.print(i);
            System.out.print("   ");
        }
    }
}
