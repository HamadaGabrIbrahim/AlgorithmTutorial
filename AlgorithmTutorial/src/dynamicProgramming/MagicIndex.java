/*
 * and open the template in the editor.
 * A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] =
 * i. Given a sorted array of distinct integers, write a method to find a magic index, if
 * one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
package dynamicProgramming;

/**
 *
 * @author hibrahim
 */
public class MagicIndex {
    public static void main(String[] args) {
        
    }
    
    public static int getMagicIndexLooping(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i)
                return i;
        }
        return -1;
    }
    
    public static int getMagicIndexBinarysearch(int[] arr) {
        int length = arr.length;
       
        
        int start = 0; 
        int end = length;
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (mid == arr[mid])
                return mid;
            if (mid < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    public static int getMagicIndexNotDestinct(int[] arr) {
        return getMagicIndexNotDestinct(arr, 0, arr.length - 1);
    }
    
    public static int getMagicIndexNotDestinct(int[] arr, int start, int end) {
        if(start < 0 || end >= arr.length || arr.length == 0 || start > end)
            return -1;
        
        int midIndex = (start + end) / 2;
        int midValue = arr[midIndex];
        
        if(midIndex == midValue)
            return midIndex;
        
        int leftIndex = Math.min(midIndex - 1, midValue);
        
        int left = getMagicIndexNotDestinct(arr, start, leftIndex);
        
        if (left >= 0)
            return left;
        
        int rightIndex = Math.max(midIndex + 1, midValue);
        
        int right = getMagicIndexNotDestinct(arr, rightIndex, end);
        
        return right;
    }
}
