import java.util.*;
import java.net.*;
import java.io.*;

class check_sum_client
{
    public static void main(String[] args)throws IOException
    {
        InetAddress addr=InetAddress.getByName("192.168.1.6");
        Socket socket=new Socket(addr,1234);

        DataInputStream dis=new DataInputStream(socket.getInputStream());
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());

        int n=dis.readInt();

        System.out.println("N="+n);

        int sum=0;

        System.out.println("Received");

        for(int i=0;i<n;i++)
        {
            int curr=dis.readInt();
            sum=sum+curr;
            System.out.println(curr);
        }
        int checksum=dis.readInt();
        sum+=checksum;
        System.out.println("checksum received"+checksum);
        System.out.println("Sum calculated is "+sum);

        int res=sum&(sum+1);

        if(res==0)
            System.out.println("VALID");
        else
            System.out.println("INVALID");
    }
}