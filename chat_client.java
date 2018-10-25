import java.io.*;
import java.net.*;
import java.util.*;

class chat_client
{
    public static void main(String[] args)throws IOException
    {
        InetAddress addr=InetAddress.getLocalHost();
        Socket socket=new Socket(addr,1234);

        DataInputStream dis=new DataInputStream(socket.getInputStream());
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());

        String word1,word2;
        System.out.println("Chatting...");

        Scanner sc=new Scanner(System.in);

        while(true)
        {
            word1=dis.readUTF();
            System.out.println(word1);

            if(word1.equals("done"))
                break;

            word2=sc.nextLine();
            dos.writeUTF(word2);
            
            if(word2.equals("done"))
                break;

        }
    }
}