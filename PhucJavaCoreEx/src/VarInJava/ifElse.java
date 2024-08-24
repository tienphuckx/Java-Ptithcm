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
public class ifElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.print("Nhap vao diem cua ban : ");
            int $num = scanner.nextInt();
            if($num >= 0 && $num <=10){
                if($num <= 4){
                    System.out.println("ROT MON !");
                }else if ($num >=5 && $num <= 7){
                    System.out.println("HOC LUC KHA !");
                }else{
                    System.out.println("HOC TOT !");
                }
                flag = false;
            }else{
                System.out.println("LUU Y : NHAP DIEM TU 0-10 !");
            }
        }while(flag);
        
        
        
    }
}
