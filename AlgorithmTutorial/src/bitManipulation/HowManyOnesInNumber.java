/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitManipulation;

/**
 *
 * @author hibrahim
 */
public class HowManyOnesInNumber {
    public static void main(String[] args) {
        System.out.println("The number of ones in 14 should be 3 is it ? "+getOnesCount(14));
    }
    
    public static int getOnesCount(long num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) > 0){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
