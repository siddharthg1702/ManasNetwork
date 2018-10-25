import java.io.*;
import java.net.*;
import java.util.*;

class dns_client
{
    public static void main(String[] args)throws IOException
    {
        DatagramSocket client=new DatagramSocket();
        InetAddress addr=InetAddress.getLocalHost();

        byte[] sendbyte=new byte[1024];
        byte[] receivebyte=new byte[1024];

        System.out.println("1-DNS  2-Reverse DNS  3-Exit");
        Scanner sc=new Scanner(System.in);
        int n;

        while(true)
        {
            n=sc.nextInt();
            if(n==1)
            {   
                sendbyte=Integer.toString(n).getBytes();
                DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,1234);
                client.send(sender);

                System.out.println("enter host name");
                // sc.nextLine();
                String str=sc.next();
                sendbyte=str.getBytes();
                sender=new DatagramPacket(sendbyte,sendbyte.length,addr,1234);
                client.send(sender);

                DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
                client.receive(receiver);

                String s=new String(receiver.getData());
                System.out.println(s.trim());
                
            }
            else if(n==2)
            {
                sendbyte=Integer.toString(n).getBytes();
                DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,1234);
                client.send(sender);

                System.out.println("enter IPaddress");
                // sc.nextLine();
                String str=sc.next();
                sendbyte=str.getBytes();
                sender=new DatagramPacket(sendbyte,sendbyte.length,addr,1234);
                client.send(sender);

                DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
                client.receive(receiver);

                String s=new String(receiver.getData());
                System.out.println(s.trim());
                
            }
            else
                break;
        }
    }
}