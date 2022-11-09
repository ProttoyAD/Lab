package Chat;

import java.net.*;
import java.io.*;
public class Client
{
    public static void main(String args[]) throws Exception
    {
        Socket sk=new Socket("127.0.0.1",2000);
        BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream sout=new PrintStream(sk.getOutputStream());
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ( true )
        {
            System.out.print("Client : ");
            sout.println(stdin.readLine());
            s=sin.readLine();
            System.out.print("Server : "+s+"\n");
            if ( s.equalsIgnoreCase("BYE") )
                break;
        }
        sk.close();
        sin.close();
        sout.close();
        stdin.close();
    }
}