/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThanTrieu;

import java.util.Scanner;

/**
 *
 * @author NguyenPhuc
 * 
 * 
 */

// in ra hinh vuong hoac hinh chu nhat
public class Ex1 {
    public static void main(String[] args) {
        inHinh();
    }
    public static void inHinh(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap vao chieu dai : ");
        int chieuDai = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nhap vao chieu rong : ");
        int chieuRong = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < chieuRong; i++)
        {
            for (int j = 0; j < chieuDai; j++)
            {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }
}
