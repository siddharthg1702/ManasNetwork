import java.util.*;
import java.net.*;
import java.io.*;

class Client
{
    public Client()
    {
        try
        {
            InetAddress addr=InetAddress.getLocalHost();
            Socket socket=new Socket(addr,1234);

            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            Scanner sc= new Scanner(System.in);

            String div,divi;
            System.out.println("enter dividend");
            divi=sc.next();

            System.out.println("enter divisor");
            div=sc.next();

            String send=encoded(divi,div);
            System.out.println(send);
            dos.writeUTF(send);
            dos.writeUTF(div);  
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


    public String encoded(String divi,String div)
    {
        String data=divi;
        for(int i=0;i<div.length()-1;i++)
        {
            divi=divi+"0";
        }

        String rem=moddiv(divi,div);
        return data+rem;
    }
}
    

class crc_client
{
    public static void main(String[] args)throws IOException
    {
        Client c=new Client();
    }
}
       