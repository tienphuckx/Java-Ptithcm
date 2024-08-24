/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThanTrieu;

/**
 *
 * @author NguyenPhuc
 */

// in ra bang cuu chuong tu 1 den 10 :
public class Ex3 {
    public static void main(String[] args) {
        inBangCuuChuong();
    }
    public static void inBangCuuChuong(){
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 1; j <= 10; j++)
            {
                System.out.printf("%2d * %2d = %4d\n",i,j,(i*j));
            }
            System.out.println("----------------------------------------------------");
        }
    }
}
