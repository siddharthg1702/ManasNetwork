import java.io.*;
import java.net.*;
import java.util.*;

public class http
{
    public static void main(String[] args)throws IOException
    {
        ServerSocket s = new ServerSocket(1234);
        
        while(true)
        {
            try 
            {
                Socket socket = s.accept();

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                System.out.println("ENTER");
                String request,filename;

                request=br.readLine();
                StringTokenizer token=new StringTokenizer(request);
                System.out.println(request);


                if(token.nextToken().equals("GET"))
                {
                    filename=token.nextToken();
                    if(filename.startsWith("/") == true)
                        filename=filename.substring(1);
                    
                    File file=new File(filename);
                    int length=(int)file.length();
                    
                    FileInputStream infile=new FileInputStream(filename);

                    byte[] arr=new byte[length];
                    infile.read(arr);

                    dos.writeBytes("HTTP/1.0 200 yaaay!\r\n");

                    if(filename.endsWith(".html"))
                        dos.writeBytes("Content-type : html\r\n");

                    if(filename.endsWith(".jpg"))
                        dos.writeBytes("Content-type : image/jpeg\r\n");
                
                    dos.writeBytes("Content-length: "+length + "\r\n");
                    dos.writeBytes("calf-kanni : cheeni"+"\r\n");
                    dos.writeBytes("\r\n");
                    dos.write(arr,0,length);
                    socket.close();
                }
                else 
                    dos.writeBytes("HTTP/1.0 400 Bad Request Message");   
                }
                catch (Exception e) {
                //TODO: handle exception
            }
            
        }
    }
}