
package bai2;

/**
 *
 * @author NguyenPhuc - N16DCAT038
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 7777;

	public  Client() {
		try {
			Socket socket = new Socket(SERVER_IP,SERVER_PORT);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        System.out.println("Nhap vao duong dan:");
			Scanner sc = new Scanner(System.in);
			String url;
			url= sc.nextLine();
			dos.writeUTF(url);
			String menu = dis.readUTF();
                        if(menu.equals("0"))
                        {
                            
                            System.out.println("Khong tim thay file");
                        }
                        else
                        {  
                        String arymenu []= menu.split(",");
                        System.out.println("Menu");
                        System.out.println(arymenu[0]);
                        System.out.println(arymenu[1]);
                        System.out.println(arymenu[2]);
                        System.out.println("moi nhap lua chon");
                        int lc = sc.nextInt();
                        dos.writeInt(lc);
                         String kq = dis.readUTF();
                        System.out.println("Ket qua la :" + kq);
                        }
			

		} catch (Exception e) {
                    e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Client client = new Client();
	}
}

