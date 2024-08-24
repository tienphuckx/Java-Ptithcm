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
 */

// S = 1 + 1/2 + 1/3 + ...+ 1/n

public class Ex7 {
    public static void main(String[] args) {
        countPS();
    }
    public static void countPS(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("NHAP VAO N : ");
        int N = scanner.nextInt();
        int Sum = 0;
        for (int i = 1;i <= N; i++ )
        {
            Sum += (double)1/i;
        }
        System.out.println("Ket qua la : " + Sum);
    }
}
