/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hibrahim
 */
public class SubSetsOfSet {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        
        
        List<List<Integer>> subSets = getAllSubSets(list);
        
        System.out.println("The size is : " + subSets.size());
        subSets.forEach(set -> {
           
            printList(set);
        });
        
    }
    
    public static void printList(List<Integer> list) {
        list.forEach(item -> {
            System.out.print(item + " ");
        });
        System.out.println();
    }
    
    public static List<List<Integer>> getAllSubSets(List<Integer> set) {
       return getAllSubSets(set, 0);
    }
    
    public static List<List<Integer>> getAllSubSets(List<Integer> set, int index) {
        List<List<Integer>> allSubSets;
                
        if(set.size() == index){
            allSubSets = new ArrayList<List<Integer>>();
            allSubSets.add(new ArrayList<Integer>());
        }else {
            allSubSets = getAllSubSets(set, index + 1);
            
            int item = set.get(index);
            
            List<List<Integer>> moreSubSets = new ArrayList<List<Integer>>();
            
           allSubSets.forEach(subSet -> {
               List<Integer> newSet = new ArrayList<>();
               newSet.addAll(subSet);
               newSet.add(item);
               moreSubSets.add(newSet);
           });
           allSubSets.addAll(moreSubSets);
        }
        return allSubSets;
    }
}
