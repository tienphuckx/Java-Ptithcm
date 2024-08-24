/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author NguyenPhuc
 */
public class arrList {
    public static void main(String[] args) {
        ArrayList<Integer> listTest = new ArrayList<>();
        
        listTest.add(5);
        listTest.add(6);
        listTest.add(7);
        listTest.add(8);
        listTest.add(9);
        listTest.add(10);
        
        int i =0;
        for(int itemm :listTest){
            System.out.println("phan tu "+ i +": " + itemm);
            i++;
        }
        
        // sap xep
        Collections.sort(listTest, new Comparator<Integer>() 
        {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1:1; 
            }
        });

        // find max
        Integer max = listTest.get(0);
        for(int item:listTest){
            if(max < item) max = item;
        }
        System.out.print("Thg lol lon nhat :");
        System.out.println(max);
        
    }
    
}
