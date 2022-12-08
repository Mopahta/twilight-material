package by.bsuir.Kaminsky.server.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import by.bsuir.Kaminsky.server.ImplemenationLayer.UserLogic;

public class ServerMultiThread extends Thread {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    ServerMultiThread(Socket s) throws IOException {
        socket = s;
        in = new ObjectInputStream (socket.getInputStream());
        out = new ObjectOutputStream (socket.getOutputStream());

        start(); // call run()
    }

    public void run(){        
    	UserLogic.chooseAction(in,out);
    	System.out.println("<disconnect> Close connection with "+socket.getLocalPort()+socket.getInetAddress());
    	try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}