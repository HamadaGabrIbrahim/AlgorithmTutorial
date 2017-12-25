/*
 * Cracking the codeing interview questions Bit Manipulation
 * 
 * 5.1 You are given two 32-bit numbers, N andM, and two bit positions, i and j. Write a
 * method to insert M into Nsuch that M starts at bit j and ends at bit i. You can assume
 * that the bits j through i have enough space to fit all ofM. That is, ifM= 10011,
 * you can assume that there are at least 5 bits between j and i. You would not, for
 * example, have j-3 and i=2, because M could not fully fit between bit 3 and bit 2.

 */
package bitManipulation;

/**
 *
 * @author hamada ibrahim
 */
public class InsertNInToM {
    
    public static void main(String[] args) {
        System.out.println("Putting the number m = 19 which is 10011 into n = 1024 which is 10000000000 in the indexes i = 2 and j = 6 should result in 1100 which is 10001001100, the result is : "+insertNinToM(1024, 19, 2, 6));
    }
    
    public static int insertNinToM(int n, int m, int i, int j) {
        
         
        int rightZeros = ~0 << (j + 1);
        
        int leftZeros = ~(~0 << i);
        
        int nCleared = (rightZeros | leftZeros) & n;
        
        int mCleared = m << i;
        
        return nCleared | mCleared;
        
    }
}
