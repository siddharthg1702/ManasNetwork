import java.io.*;
import java.net.*;
import java.util.*;

class dns_server
{
    public static void main(String[] args)throws IOException
    {
        DatagramSocket server=new DatagramSocket(1234);

        
        while(true)
        {
            byte[] sendbyte=new byte[1024];
            byte[] receivebyte=new byte[1024];

            System.out.println("waiting...");
            DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
            server.receive(receiver);
            

            String z=new String(receiver.getData()).trim();
            System.out.println(z);

            int n=Integer.parseInt(z);
            System.out.println(n);

            receiver=new DatagramPacket(receivebyte,receivebyte.length);
            server.receive(receiver);
            
            String s=new String(receiver.getData()).trim();
            System.out.println("Serve side"+s);

            InetAddress addr=receiver.getAddress();
            int port=receiver.getPort();
            
            System.out.println("hi");
            if(n==1)
            {
                InetAddress address=InetAddress.getByName(s);
                sendbyte=address.getHostAddress().getBytes();
                DatagramPacket sender =new DatagramPacket(sendbyte,sendbyte.length,addr,port);
                server.send(sender);
                
            }
            
            if(n==2)
            {
                InetAddress address=InetAddress.getByName(s);
                sendbyte=address.getHostName().getBytes();
                DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,port);
                server.send(sender);    
            }
        }
    }
}