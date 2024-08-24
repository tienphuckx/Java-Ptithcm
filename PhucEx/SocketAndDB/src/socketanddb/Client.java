/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketanddb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author NguyenPhuc
 */
public class Client {
    public static void main(String[] args) {
        
        String message = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien");
        String manhanvien = sc.nextLine();
        System.out.println("Nhap ho ten");
        String hoten = sc.nextLine();
        System.out.println("Nhap vao tuoi");
        String tuoi = sc.nextLine();
        message = manhanvien+"," + hoten+"," + tuoi;
        
        
        try {
            Socket socket = new Socket("localhost",3000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
