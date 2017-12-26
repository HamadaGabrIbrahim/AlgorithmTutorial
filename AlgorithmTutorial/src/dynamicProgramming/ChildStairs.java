/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
 * 3 steps at a time. Implement a method to count how many possible ways the child
 * can run up the stairs
*/

package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hibrahim
 */
public class ChildStairs {
    public static void main(String[] args) {
       System.out.println("The number of ways for 3 steps recursion is : " + getNumberOfWaysRecursion(3));
       System.out.println("The number of ways for 3 steps dynamic programming is : " + getNumberOfWaysDP(3));
       
       System.out.println("The number of ways for 4 steps recursion is : " + getNumberOfWaysRecursion(4));
       System.out.println("The number of ways for 4 steps dynamic programming is : " + getNumberOfWaysDP(4));
       
       System.out.println("The number of ways for 5 steps recursion is : " + getNumberOfWaysRecursion(5));
       System.out.println("The number of ways for 5 steps dynamic programming is : " + getNumberOfWaysDP(5));
    }
    
    public static int getNumberOfWaysRecursion(int num) {
        if (num < 0)
            return 0;
        if (num == 0)
            return 1;
        return getNumberOfWaysRecursion(num - 1) + getNumberOfWaysRecursion(num - 2) + getNumberOfWaysRecursion(num - 3);
        
    } 
    
    public static int getNumberOfWaysDP(int num) {
        int[] previousResultsMap = new int[num + 1];
        return getNumberOfWaysDP(num, previousResultsMap);
    }
    
    public static int getNumberOfWaysDP(int num, int[] previousResultsMap) {
        if (num < 0)
            return 0;
        if (num == 0)
            return 1;
        if (previousResultsMap[num] > 0)
            return previousResultsMap[num];
        previousResultsMap[num] = getNumberOfWaysDP(num - 1, previousResultsMap) + getNumberOfWaysDP(num - 2, previousResultsMap) + getNumberOfWaysDP(num - 3, previousResultsMap);
        return previousResultsMap[num];
    }
}
