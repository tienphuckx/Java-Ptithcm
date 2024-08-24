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
public class switchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean $flag = true;
        while($flag){
            System.out.print("Nhap vao mot trong cac ngay trong tuan : ");
            int $day = scanner.nextInt();
            if($day < 9 && $day > 1){
                switch ($day)
                {
                    case 2:System.out.println("HOM NAY LA TU HAI");
                        break;
                    case 3:System.out.println("HOM NAY LA TU BA");
                        break;
                    case 4:System.out.println("HOM NAY LA TU TU");
                        break;
                    case 5:System.out.println("HOM NAY LA TU NAM");
                        break;
                    case 6:System.out.println("HOM NAY LA TU SAU");
                        break;
                    case 7:System.out.println("HOM NAY LA TU BAY");
                        break;
                        
                    default: System.out.println("CHU NHAT");
                }
                $flag = false;
            }else{
                System.out.println("Nhap sai ! Hay nhap lai !");
            }
        }
    }
}
