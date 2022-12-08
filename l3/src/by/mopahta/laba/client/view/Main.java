package by.bsuir.Kaminsky.client.view;

import by.bsuir.Kaminsky.client.ImplementationLayer.ClientLogic;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Main {
	
	private static final int PORT = 9090;
	
	public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getByName("localhost");
        ObjectOutputStream out;
        ObjectInputStream in;

        System.out.println("IP: "+addr);
        try (Socket socket = new Socket(addr, PORT)) {
            System.out.println("<create> Socket : " + socket);
            out = new ObjectOutputStream (socket.getOutputStream());
            in = new ObjectInputStream (socket.getInputStream());

            while (true){
            	ClientLogic.logIn(in,out);
            }
        }catch (Exception e){
            System.out.println("<error> Cannot connect to server!");
        }finally {
            System.out.println("<end> Close socket");
        }
    }
}
