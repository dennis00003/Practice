package org.par.searching;

/**
 * The array needs to be sorted.
 * Average and worst search runtime f(n)=O(log n)
 * 
 * @author Harinder Singh Bedi
 *
 */
public class RecursiveBinarySearch {
 
    public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
         
        if (start <= end) {
            int mid = (start + end) / 2; 
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid-1, key);
                 
            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);
                 
            } else {
                return mid;  
            }
        }
        return -1; 
    }
 
    public static void main(String[] args) {
         
        int[] arr1 = {2,45,234,876,900,976,999};
        int index = recursiveBinarySearch(arr1,0,arr1.length-1,450);
        System.out.println("Found 45 at "+index+" index");
        index = recursiveBinarySearch(arr1,0,arr1.length-1,999);
        System.out.println("Found 999 at "+index+" index");
        index = recursiveBinarySearch(arr1,0,arr1.length-1,876);
        System.out.println("Found 876 at "+index+" index");
    }
}
