
package bai1;

/**
 *
 * @author NguyenPhuc - N16DCAT038
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

public class Client {
    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 7777;
  
    public Client()
    {
        try {
            Socket socket= new Socket(SERVER_IP, SERVER_PORT);
            DataInputStream dis= new DataInputStream(socket.getInputStream());
            DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
            Scanner sc= new Scanner(System.in);
            int option;
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("1 - S = 1+3+5+7 +…+ (2n+1)");
            System.out.println("2 - S = 1*2 + 2*3 +…+ n*(n+1)");
            System.out.println("3 - S = 1-2 + 3-4 + (2n+1)");
            System.out.println("4 - Tính tổng 2 số a và b với a, b nhập từ client.");
            System.out.println("5 - Tính lập phương với 2 số a và b với a,b nhập từ client.");
            System.out.println("6 - Tính bình phương với 2 số a và b với a,b nhập từ client.");
            System.out.println("7 - Tính tích S1 = 1*2*3*…*n và S2= 1+2+…+n với nhập từ client.");
            System.out.println("-------------------------------------------------------------------------");
            System.out.print("NHAP VAO LUA CHON CUA BAN [1-7] :   ");
            
            option = sc.nextInt();
            int n,s,a,b;
            switch(option)
            {
                case 1:
                    dos.write(option);
                    System.out.print("Nhap n : ");                                     
                    n=sc.nextInt();
                    dos.write(n);   
                    s=dis.read();
                    System.out.print("Tong n  la :" + s);
                    break;
                case 2:
                    dos.write(option);
                    System.out.print("Nhap n : ");                                   
                    n=sc.nextInt();
                    dos.write(n);   
                     s=dis.read();
                    System.out.print("Tong n  la : " + s);
                    break;                
                case 3:
                    dos.write(option);
                    System.out.print("Nhap n : ");                                     
                    n=sc.nextInt();
                    dos.write(n);   
                    String sa=dis.readUTF();
                    System.out.print("Tong n  la : " + sa);
                    break;
                case 4:
                    dos.write(option);
                    System.out.print("Nhap a : ");                                     
                    a=sc.nextInt();
                    dos.write(a);  
                    System.out.print("nhap b : ");
                    b=sc.nextInt();
                    dos.write(b);  
                    s=dis.read();
                    System.out.print("Tong a + b =  " + s);
                    break;
                case 5:
                    dos.write(option);
                    System.out.print("Nhap a : ");                                      
                    a=sc.nextInt();
                    dos.write(a);  
                    System.out.print("nhap b");
                    b=sc.nextInt();
                    dos.write(b);  
                    double sa1=dis.readDouble();
                    System.out.print("Lap phuong ab =  " + sa1);
                    break;
                case 6:
                    dos.write(option);
                    System.out.print("Nhap a : ");                                     
                    a=sc.nextInt();
                    dos.write(a);  
                    System.out.print("nhap b : ");
                    b=sc.nextInt();
                    dos.write(b);  
                    double sa2=dis.readDouble();
                    System.out.print("binh phuong ab =  " + sa2);
                    break;
                case 7:
                    dos.write(option);
                    System.out.print("Nhap n : ");                                    
                    n=sc.nextInt();
                    dos.write(n);   
                     double sa3=dis.readDouble();
                    System.out.print("Tong n  la : " + sa3);
                    break;
                default:
                    System.out.print("BAN CHI DUOC NHAP TU : 1--> 7   !");
            }
        } catch (Exception e) {
        }
    }
    public static void main(String args[])
    {
        Client client= new Client();
    }
}


