/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dynamicProgramming.MagicIndex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hibrahim
 */
public class MagicIndexTest {
    
    public MagicIndexTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testMagicIndex() {
         int[] arr = {-2,-1,1,2,3,4,5,7,8};
       
         assertEquals(7, MagicIndex.getMagicIndexLooping(arr));
         assertEquals(7, MagicIndex.getMagicIndexBinarysearch(arr));
         assertEquals(7, MagicIndex.getMagicIndexNotDestinct(arr));
         
     
     }
     
    }
