/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VarInJava;

import java.util.Scanner;

/**
 *
 * @author NguyenPhuc
 */
public class intOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap vao mot so nguyen :  ");
        int $numberInt = scanner.nextInt();
        
        System.out.print("Hay nhap vao 1 so float : ");
        float $numberFloat = scanner.nextFloat();
        
        System.out.print("Hay nhap vao 1 so double : ");
        double $numberDouble = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Hay nhap vao 1 chuoi : ");
        String $string = scanner.nextLine();
        
        System.out.println("So nguyen ban vua nhap la : " + $numberInt);
        System.out.println("So fload ban vua nhap la : " + $numberFloat);
        System.out.println("So double ban vua nhap la : " + $numberDouble);
        System.out.println("String ban vua nhap la : " + $string);
    }
}
