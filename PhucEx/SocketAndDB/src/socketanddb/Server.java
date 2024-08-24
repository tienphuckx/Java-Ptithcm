/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketanddb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author NguyenPhuc
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Server is starting");
        while(true){
            Socket socket = ss.accept();
            System.out.println("Client connected");
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            
            String message = in.readUTF();
            
            String[] temp = message.split(",");
            int manhanvien = Integer.parseInt(temp[0]);
            String hoten = temp[1];
            int tuoi = Integer.parseInt(temp[2]);
            DB db =new DB();
            db.addNhanVien(manhanvien, hoten, tuoi);
        
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
