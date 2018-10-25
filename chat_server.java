import java.io.*;
import java.net.*;
import java.util.*;

class chat_server
{
    public static void main(String[] args)throws IOException
    {
        ServerSocket s=new ServerSocket(1234);
        Socket socket=s.accept();

        DataInputStream dis=new DataInputStream(socket.getInputStream());
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());

        String word1,word2;
        System.out.println("Chatting...");
        Scanner sc=new Scanner(System.in);

        while(true)
        {
            word1=sc.nextLine();
            dos.writeUTF(word1);
            
            if(word1.equals("done"))
                break;    

            word2=dis.readUTF();
            System.out.println(word2);

            if(word2.equals("done"))
                break;    
            
        }

    }
}