/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author NguyenPhuc
 */
public class RandomEx {
    public static void main(String[] args) {
        
        //INPUT NUMBER
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.print("NHAP VAO SO NGUYEN : ");
        input = scanner.nextInt();
        
        //GET RANDOM NUMBER
        Random random = new Random(100);
        
        // COUNTER
        int counter = 1;
        
        //WHILE CHECK
        while(true){
            int randomNumber = random.nextInt();
            
            System.out.println("Random lan " + counter + "=" + randomNumber);
            
            counter++;
            if(randomNumber == input){
                break;
            }
        }
        System.out.println("=====================");
        System.out.println("SO LAN RANDOM : " + counter);
    }
}
