/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThanTrieu;

import static java.lang.Double.sum;
import java.util.Scanner;

/**
 *
 * @author NguyenPhuc
 */

// viết chương trình nhập vào n và tính tổng :
// n chẵn : S = 2 + 4 + 6 + ...+ n
// n lẻ : S = 1 + 3 + 5 + ... + n

public class Ex6 {
    public static void main(String[] args) {
        insertAndSum();
    }
    public static void insertAndSum(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("NHAP VAO SO INT N : ");
        int N = scanner.nextInt();
        int Sum = 0;
        if (N%2 ==0){
            for (int i = 0;i <= N;i += 2){
                Sum += i;
            }
        } else {
            for (int i = 1;i <= N; i += 2){
                Sum += i;
            }
        }
        System.out.println("Sum = " + Sum);
    }
}
