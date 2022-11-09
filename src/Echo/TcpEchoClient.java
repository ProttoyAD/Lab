package Echo;

import java.io.*;
import java.net.*;

public class TcpEchoClient
{
    private final static String HOSTNAME = "localhost";
    private final static int PORT = 8090;

    public static void main(String[] args) throws IOException
    {

        InputStreamReader osr = new InputStreamReader(System.in);
        BufferedReader bufferedReader =new BufferedReader(osr);
        String string=bufferedReader.readLine();

        try (Socket clientSocket = new Socket(HOSTNAME, PORT);
             InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
             BufferedReader in = new BufferedReader(isr);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            System.out.println("Connected to " + HOSTNAME + " on port " + PORT);

            String data =string;

            System.out.println("Sending to server:\n" + data);
            out.println(data);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client received: " + line);
            }
        }
    }
}