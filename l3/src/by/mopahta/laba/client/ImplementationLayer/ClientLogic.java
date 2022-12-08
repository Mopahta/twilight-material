package by.bsuir.Kaminsky.client.ImplementationLayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import by.bsuir.Kaminsky.client.controller.Controller;
import by.bsuir.Kaminsky.models.User;

public class ClientLogic {
	
	private static User user = null;
	private static ObjectOutputStream out;
	private static ObjectInputStream in;
	
	/** Send message 
	 * @throws IOException */
	public static void sendMessage(Object message) throws IOException {
        out.reset();
        out.writeObject(message);
        out.flush();
	}
	
	/** Receive message */
	@SuppressWarnings("unchecked")
	private static ArrayList<Object> receiveMessage() {
		ArrayList<Object> result = null;
		try {
			result = (ArrayList<Object>)in.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void logIn(ObjectInputStream inpStream,ObjectOutputStream outStream) throws IOException{	
		Object[] answer = Controller.authorizeRequest();
		ArrayList<Object> message,result;
		
		in = inpStream;
		out = outStream;		
		if (answer != null){
			
			message = new ArrayList<Object>();
			message.add(0);
			message.add(answer);
			sendMessage((Object)message);
			result = receiveMessage();
			if ((Boolean)result.get(1) && !(Boolean)answer[0]) {
				user = (User)result.get(2);
				Controller.notifyUserRequest("User "+user.getLogin()+" was successfully register");
				chooseAction();
			}else if ((Boolean)result.get(1) && (Boolean)answer[0]) {
				user = (User)result.get(2);
				String name = (user.getIsAdministrator())?"Administrator ":"User ";
				Controller.notifyUserRequest(name+user.getLogin()+" log in");
				chooseAction();
			}
			else
				Controller.notifyUserRequest((String)result.get(2));
			
		}
	}
	
	/** Choose action */
	private static void chooseAction() throws IOException{
		Boolean flag = true;
		
		while (flag) {
			int action = Controller.chooseActionRequest(user.getIsAdministrator());
			switch (action) {
				case 0:		
					logOut(action+1);
					System.exit(0);
					break;
				case 1:	
					flag = false;
					logOut(action);
					break;
				case 2:	
					getBooks(action);
					break;
				case 3:		
					findBooksByStringParameter("title",action);
					break;
				case 4:	
					findBooksByStringParameter("author",action);
					break;
				case 5:	
					getBooks(action);
					break;
				case 6:
					getBooks(action);
					break;
				case 7:	
					modifyBook(action);
					break;
				case 8:		
					addOrRemove(action);
					break;
				case 9:		
					addOrRemove(action);
					break;
				case 10:		
					showUsers(action);
					break;
				case 11:		
					deleteUser(action);
					break;
			}
		}		
	}
	
	/** Log out */
	private static void logOut(int action) throws IOException{
		ArrayList<Object> message;
		String name = (user.getIsAdministrator())?"Administrator ":"User ";
		
		Controller.notifyUserRequest(name+user.getLogin()+" log out");
		message = new ArrayList<Object>();
		message.add(action);
		message.add(name+user.getLogin()+" log out");
		sendMessage((Object)message);
		receiveMessage();
		user = null;
	}
	
	/** Get books */
	@SuppressWarnings("unchecked")
	private static void getBooks(int action) throws IOException{			
		ArrayList<Object> result,message = new ArrayList<Object>();
		
		message.add(action);
		sendMessage((Object)message);
		result = receiveMessage();
		Controller.printListRequest((ArrayList<Object>)result.get(2));		
	}
	
	/** Get books by string parameter */
	@SuppressWarnings("unchecked")
	private static void findBooksByStringParameter(String parameterName,int action) throws IOException{
		ArrayList<Object> result,message = new ArrayList<Object>();
		String parameter = Controller.getParameterRequest(parameterName);
		 
		if (parameter != null) {	
			message.add(action);
			message.add(parameter);
			sendMessage((Object)message);
			result = receiveMessage();				
			Controller.printListRequest((ArrayList<Object>)result.get(2));	
		}else
			Controller.notifyUserRequest("ERROR");
	}
	
	/** Add or remove book */
	private static void addOrRemove(int action) throws IOException{
		ArrayList<Object> result,message = new ArrayList<Object>();
		Object[] data = Controller.getBookRequest();
		 
		if (data != null) {	
			message.add(action);
			message.add(data);
			sendMessage((Object)message);
			result = receiveMessage();				
			Controller.notifyUserRequest((String)result.get(2));	
		}else
			Controller.notifyUserRequest("ERROR");
	}
	
	/** Modify book */
	private static void modifyBook(int action) throws IOException{
		ArrayList<Object> result,message = new ArrayList<Object>();
		Object[] data = Controller.replaceBookRequest();
		 
		if (data != null) {	
			message.add(action);
			message.add(data);
			sendMessage((Object)message);
			result = receiveMessage();				
			Controller.notifyUserRequest((String)result.get(2));	
		}else
			Controller.notifyUserRequest("ERROR");
	}
	
	/** Show all users */
	@SuppressWarnings("unchecked")
	private static void showUsers(int action) throws IOException{
		ArrayList<Object> result,message = new ArrayList<Object>();
		
		message.add(action);
		sendMessage((Object)message);
		result = receiveMessage();
		Controller.printListRequest((ArrayList<Object>)result.get(2));	
	}
	
	/** Delete user */
	private static void deleteUser(int action) throws IOException{
		ArrayList<Object> result,message = new ArrayList<Object>();
		String login = Controller.getParameterRequest("Login of user, you want to delete");
		
		if (login != null) {
			message.add(action);
			message.add(login);
			sendMessage((Object)message);
			result = receiveMessage();
			Controller.notifyUserRequest((String)result.get(2));
		}else {
			Controller.notifyUserRequest("ERROR!");
		}
	}
}
