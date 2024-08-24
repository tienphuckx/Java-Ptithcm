/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author NguyenPhuc - N16DCAT038
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vanti
 */
public class Server {
	public static final int SERVER_PORT = 7777;	
	public Server() throws IOException {
            try {
                ServerSocket ss= new ServerSocket(SERVER_PORT);
                Socket socket =ss.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos= new DataOutputStream(socket.getOutputStream());

                String url = dis.readUTF();
                String line="";
            // Đọc dữ liệu từ File với BufferedReader
                File file = new File(url);
                if(file.exists()== false)
                {
                    String notfile ="0";
                    dos.writeUTF(notfile);
                }
                BufferedReader reader = new BufferedReader(new FileReader(file));
                line = reader.readLine();

                System.out.println("du lieu la :"+line);
                dos.writeUTF(line);
                int lc = dis.readInt();
                String aryData[] = line.split(",");

                switch(lc)
                {
                    case 1:
                        dos.writeUTF(aryData[3]);
                    case 2:
                        dos.writeUTF(aryData[4]);
                    case 3:
                        dos.writeUTF(aryData[5]);
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
    }

	public static void main(String args[]) throws IOException {
		Server server = new Server();
	}
}

