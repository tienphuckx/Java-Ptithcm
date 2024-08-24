/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhucMultiChat;

/**
 *
 * @author NguyenPhuc
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    private InetAddress host;
    private int port;
    
    public Client(InetAddress host, int port) {
            this.host = host;
            this.port = port;
    }
    private void execute() throws IOException {
        // Phần bổ sung
        Scanner sc = new Scanner(System.in);
        System.err.println("Nhập vào tên của bạn: ");
        String name = sc.nextLine();
        
        Socket client = new Socket(host, port);
        ReadClient read = new ReadClient(client);
        read.start();
        WriteClient write = new WriteClient(client, name);
        write.start();
        
        
        
    }
    public static void main(String[] args) throws IOException{
        Client client = new Client(InetAddress.getLocalHost(), 15797);
        client.execute();
    }
}
    
    class ReadClient extends Thread{
        private Socket client;
        
        public ReadClient(Socket client) {
            this.client = client;
            
            
        }

    public void run() {
       DataInputStream dis = null;
        try {
            dis = new DataInputStream(client.getInputStream());
            while (true) {      
               String sms = dis.readUTF();
               System.out.println(sms);
                
            }
            
        } catch (Exception e) {
            try {
                dis.close();
                client.close();
                
            } catch (IOException ex) {
                System.out.println("Ngat ket noi");
            } 
        }
    }     
}

class WriteClient extends Thread{
    private Socket client;
    private String name;
    
    public WriteClient(Socket client, String name){
        this.client=client;
        this.name = name;
    }

    @Override
    public void run() {
        DataOutputStream dos = null;
        Scanner sc = null;
        try {
            dos = new DataOutputStream(client.getOutputStream());
            sc = new Scanner(System.in);
            while(true){
                String sms = sc.nextLine();
                dos.writeUTF(name +" : " +sms);
            }
            
        } catch (Exception e) {
            try {
                dos.close();
                client.close();
            } catch (Exception ex) {
                System.out.println("Ngat ket noi Server");
            }
        }
    }
}
        
