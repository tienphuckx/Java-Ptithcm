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

// in ra hing VUONG or CHUNHAT rong o ben trong -----------------------------------------------------------------
public class Ex2 {
    public static void main(String[] args) {
        printBOX();
    }
    
    public static void printBOX(){
        int chieuDai;
        int chieuRong;
        Scanner scanner = new Scanner(System.in);
        System.out.print("NHAP VAO CHIEU DAI : ");
        chieuDai = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("NHAP VAO CHIEU RONG : ");
        chieuRong = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < chieuRong; i ++)
        {
            for (int j = 0; j < chieuDai; j++)
            {
                if (i ==0 || j ==0 || i == chieuRong - 1 || j == chieuDai - 1){
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }
    }
}
