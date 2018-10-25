import java.util.*;
import java.net.*;
import java.io.*;

class server
{
    public server()
    {
        try
        {
            ServerSocket s=new ServerSocket(1234);
            Socket socket=s.accept();

            DataInputStream dis=new DataInputStream(socket.getInputStream());
            

            String div,divi;
            divi=dis.readUTF();
            div=dis.readUTF();
            
            System.out.println(div+" "+divi);

            String ans=moddiv(divi,div);
            System.out.println(ans);
            int fl=0;
            for(int i=0;i<ans.length();i++)
            {
                if(ans.substring(i,i+1).equals("1"))
                {
                    fl=1;
                    break;
                }
            }

            if(fl==1)
                System.out.println("NO");
            else
                System.out.println("YES");    
            
        }    
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
  	
    }

    public String XOR(String a, String b)
    {
        String ans="";
        
        for(int i=0;i<a.length();i++)
        {
            int diff=a.charAt(i) - b.charAt(i) ;
            if(diff==0)
                ans+="0";
            else  
                ans+="1";    
        }
        return ans;
    }

    public String moddiv(String a,String b)
    {
        int len=b.length();
        int len1=len;
        String temp2="";

        for(int i=0;i<len1;i++)
            temp2+="0";

        String temp=a.substring(0,len);

        while(len<a.length())
        {
            if(temp.substring(0,1).equals("1"))
                temp=XOR(temp,b) + a.substring(len,len+1);
            else
                temp+= a.substring(len,len+1);

            len+=1;
            temp=temp.substring(1,temp.length());    
        }


        if(temp.substring(0,1).equals("1"))
            temp=XOR(temp,b) ;
        

        temp=temp.substring(1,temp.length());
        return temp;
    }

}
    

class crc_server
{
    public static void main(String[] args)throws IOException
    {
        server c=new server();
    }
}
       