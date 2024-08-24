
package bai1;

/**
 *
 * @author NguyenPhuc - N16DCAT038
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Math.pow;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT=7777;
       
    public static int tong1(int n)
    {
        int S=0;
      for(int i=1;i<=n;i++)
      {
          
          if(i%2!=0)
          {
              S=S+i;
          }
             
      }
      return S;
    }
    public static int tong2 (int n)
    {
        int s=0;
        for(int i=1;i<=n;i++)
        {
            s=s+(i*(i+1));
        }
        return s;
    }
    public static int tong3(int n)
    {
        int s=0;
        for(int i=1;i<=n;i++)
        {
            if(i%2==0)
            {
               s-=i;
            }
            else
            {
                s+=i;
            }
        }
        return s;
    }
    public static int tichn(int n)
    {
        int s=1;
        for(int i=1;i<=n;i++)
        {
            s=s*i;
        }
        return s;
    }
     public static int tongn(int n)
    {
        int s=0;
        for(int i=1;i<=n;i++)
        {
            s=s+i;
        }
        return s;
    }
    public Server()
    {
        try {
            ServerSocket ss= new ServerSocket(SERVER_PORT);
            Socket socket= ss.accept();
            DataInputStream  dis= new  DataInputStream(socket.getInputStream());
            DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
            int option;
            option=dis.read();
            int n,s,a,b;
            switch(option)
            {
                case 1:
                    n=dis.read();
                    System.out.println("1,n la"+n);
                     s=tong1(n);
                    System.out.println(s);
                    dos.write(s);
                    break;
                    
                case 2:
                     n=dis.read();
                    System.out.println("2,n la"+n);
                    s=tong2(n);
                    System.out.println(s);
                    dos.write(s);
                    break;
                case 3:
                     n=dis.read();
                    System.out.println("3,n la"+n);
                    s=tong3(n);
                   
                    String sa=String.valueOf(s);
                    System.out.println(s);
                     dos.writeUTF(sa);
                    break;
                case 4:
                    a=dis.read();
                    b=dis.read();
                    System.out.println("4,a,b la"+a+" va "+b);
                    s=a+b;
                   
                    
                    System.out.println(s);
                     dos.write(s);
                    break;
                case 5:
                     a=dis.read();
                    b=dis.read();
                    System.out.println("5,a,b la"+a+" va "+b);
                   double sa1=pow((a+b),3);
                   
                    
                    System.out.println(sa1);
                     dos.writeDouble(sa1);
                    break;
                case 6:
                    a=dis.read();
                    b=dis.read();
                    System.out.println("5,a,b la"+a+" va "+b);
                   double sa2=pow((a+b),2);
                   
                    
                    System.out.println(sa2);
                     dos.writeDouble(sa2);
                    break;
                case 7:
                 n=dis.read();
                    System.out.println("3,n la"+n);
                    
                   double sa3= tongn(n)*tichn(n);
                    
                    System.out.println(sa3);
                     dos.writeDouble(sa3);
                    break;
                default:
                    System.out.println("ko co option");
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    public static void main(String args[])
    {
        Server sv= new Server();
    }
}
