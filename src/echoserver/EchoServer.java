package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(portNumber);


            while (true) {

                Socket client = sock.accept();

                OutputStream output = client.getOutputStream();
                InputStream input = client.getInputStream();

                int stuff;
                while((stuff = input.read()) != -1) {
                    output.write(stuff);
                }

                client.close();
            }



        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}
