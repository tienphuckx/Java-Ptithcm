/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VarInJava;

/**
 *
 * @author NguyenPhuc
 */
public class arr {
    public static void main(String[] args) {
        int[] age; // Khai bao 1 mang
        age = new int[7]; // Khai bao so phan tu cho mang
        
        int[] money = new int[8]; // Ket hop khai bao + so phan tu
        
        int[] cash = {1, 2, 3, 4, 5, 6, 7 };
        for(int i = 0; i <= cash.length; i++)
        {
            System.out.println(cash[i]);
        }
        // System.out.println(money[2]);
        
        
    }
    
    
    
}
