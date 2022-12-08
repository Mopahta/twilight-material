package by.bsuir.Kaminsky.server.view;

import java.io.*;
import java.net.*;

public class Main {
	private static final int PORT = 9090;
	
	public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(PORT)) {
            System.out.println("<start> Server started");
            while (true) {
            	//is blocked until a new connection is established
                Socket socket = s.accept();
                try {
                	System.out.println("<connect> Connect with "+socket.getLocalPort()+socket.getInetAddress());
                    new ServerMultiThread(socket);
                }catch (IOException e) {
                    socket.close();
                }
            }
        }
        catch (BindException e) {
			System.out.println("<error> Only one server can be started on single host!");
		}
    }
}
