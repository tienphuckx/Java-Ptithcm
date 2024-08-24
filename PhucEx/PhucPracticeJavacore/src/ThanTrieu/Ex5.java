/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThanTrieu;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NguyenPhuc
 */
// Viết chương trình nhập vào 1 số nguyên [0-100].
// Lấy ngẫu nhiên 1 số trong khoảng [0-100] cho đến khi bằng với số đã nhập vào.
// in kết quả ra từng bước.
public class Ex5 {
    public static int number;
    
    public static void main(String[] args) {
        randomTest();
    }
    public static void randomTest(){
        // nhap vao so :
        Scanner scanner = new Scanner(System.in);        
        while (true){
            System.out.print("NHAP VAO 1 SO TRONG KHOANG [0--100] : ");           
            number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 0 && number <= 100){
                break;        
            }
        }
        
        // tao so random :
        Random random = new Random();                   
         
        int count = 0;
        while (true){
            int randomNumber = random.nextInt(100);       
            count ++;           
            if (number == randomNumber){                
                System.out.println("=============================== RANDOM LAN  " + count + "   :");
                System.out.println("THANH CONG");
                System.out.print("INPUT NUMBER IS " + number );
                System.out.print("   and   ");
                System.out.println("RANDOM NUMBER IS " + randomNumber );
                System.out.println("HAI SO BANG NHAU !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                break;
            } else {
                System.out.println("==========>> RANDOM LAN : " + count + "   ");    
                System.out.println("RANDOM NUMBER IS " + randomNumber );
            }
        }
        
    }
    
}
