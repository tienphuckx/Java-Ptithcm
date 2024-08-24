/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VarInJava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenPhuc
 */
public class arrList {
    public static void main(String[] args) {
        // Creating list using the ArrayList class
    List<Integer> numbers = new ArrayList<>();
    // use add();
    numbers.add(7);
    numbers.add(8);
    numbers.add(9);
    System.out.println("LIST : " + numbers);
    
    // get phan tu so 2 :
    int num = numbers.get(2);
    System.out.println("num[2] : " + num);
        
    // remove element from list :
    numbers.remove(2);
    
        
    // xem lai list :
        System.out.println("List now : " + numbers);
    }
}
