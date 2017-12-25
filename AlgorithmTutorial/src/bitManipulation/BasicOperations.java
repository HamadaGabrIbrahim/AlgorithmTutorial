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
public class BasicOperations {
   
    public static void main(String[] args) {
   
        System.out.println("Does the number 7 have 1 in the 4th bit number ? note : 7 as a byte is (0 0 0 0 1 1 1) " + getBitAtdigitNumber(7, 3));
   
        System.out.println("Does the number 7 have 1 in the 3rd bit number ? note : 7 as a byte is (0 0 0 0 1 1 1) " + getBitAtdigitNumber(7, 2));
    
    
        System.out.println("Put 1 bit in the index 2 of the number 7 and return the result " + setBit(7, 2));
   
        System.out.println("Put 1 bit in the index 5 of the number 7 and return the result " + setBit(7, 5));
   
        System.out.println("Clear the bit index 2 from the number 14 (14 is 0 0 0 0 1 1 1 0) and after the clear it will be (0 0 0 0 1 0 1 0) the result should be 10, the result is : " + clearBit(14, 2));
        
        System.out.println("Clear all the bits from the end until index i inclusive, 15 is (0 0 0 0 1 1 1 1) so clearing until the index 2 will be (0 0 0 0 0 0 1 1) which is 3 , the result is " + clearAllBitsFromEndToIndexInclusive(15, 2));
        
        System.out.println("Clear all the bits from the start until index i inclusive, 15 is (0 0 0 0 1 1 1 1) so clearing until the index 2 will be (0 0 0 0 1 0 0 0) which is 8 , the result is " + clearAllBitsFromStartToIndexInclusive(15, 2));
    
    }
 
   public static boolean getBitAtdigitNumber(int num, int digitNumber) {
    
       return (num & (1 << digitNumber)) != 0;
   }
   
   public static int setBit(int num, int index) {
       return ((1 << index) | num);
   }
   
   public static int clearBit(int num, int index) {
       return (~(1 << index) & num);
   }
   
   public static int clearAllBitsFromEndToIndexInclusive(int num, int index) {
       return num & ((1 << index) - 1);
   }
   
   public static int clearAllBitsFromStartToIndexInclusive(int num, int index) {
       return (~0 << (index + 1)) & num;
   }
}
