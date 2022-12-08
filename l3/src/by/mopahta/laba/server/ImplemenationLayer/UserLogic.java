package by.bsuir.Kaminsky.server.ImplemenationLayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import by.bsuir.Kaminsky.server.DataAccessLayer.DaoFactory;
import by.bsuir.Kaminsky.models.User;


public class UserLogic {

	private static ObjectOutputStream out;
	private static ObjectInputStream in;
	
	/** Send message */
	private static void sendMessage(Object message) {
        try {
        	out.reset();
            out.writeObject(message);
            out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			//reset connection
		} 
		return result;
	}
	
	/** Log in */
	private static ArrayList<Object> logIn(Object[] answer,int action){	
		ArrayList<Object> message = new ArrayList<Object>();
		User newUser;
		String name;
				
		message.add(action);
		if ( !(Boolean)answer[0] ){			
			newUser = new User((String)answer[1], MD5.getHash((String)answer[2]), false);
			if ( ! DaoFactory.getUserDao().save(newUser) ){	
				message.add(false);
				message.add("User with this login already exist!");
				System.out.println("<warning> User with this login already exist!");
				return message;
			}	
			else{
				System.out.println("<action> User "+(String)answer[1]+" was successfully register");
			}
		}
		
		newUser = DaoFactory.getUserDao().getAuthorizeUser((String)answer[1], MD5.getHash((String)answer[2]));		
		if (newUser == null){
			message.add(false);
			message.add("Wrong login or password!");
			System.out.println("<warning> Wrong login or password!");
        } else{   
        	message.add(true);
        	message.add(newUser);
        	name = (newUser.getIsAdministrator())?"Administrator ":"User ";
        	System.out.println("<action> "+name+newUser.getLogin()+" log in");
        }	
		return message;
	}
	
	/** Choose action */
	public static void chooseAction(ObjectInputStream inpStream,ObjectOutputStream outStream) {
		
		ArrayList<Object> message,result=null;
		int action;
		
		in = inpStream;
		out = outStream;
		while (true) {
			message = receiveMessage();
			if (message == null)
				break;
			action = (int)message.get(0);
			
			switch (action) {
				case 0:	
					result = logIn((Object[])message.get(1),action);
					break;
				case 1:	
					result = logOut((String)message.get(1),action);
					break;
				case 2:	
					result = BookLogic.getBooks(action);
					break;
				case 3:		
					result = BookLogic.findBooksByTitle((String)message.get(1),action);
					break;
				case 4:	
					result = BookLogic.findBooksByAuthor((String)message.get(1),action);
					break;
				case 5:	
					result = BookLogic.findElectonicBooks(action);
					break;
				case 6:
					result = BookLogic.findPaperBooks(action);
					break;
				case 7:	
					result = BookLogic.modifyBook((Object[])message.get(1),action);
					break;
				case 8:		
					result = BookLogic.addBook((Object[])message.get(1),action);
					break;
				case 9:		
					result = BookLogic.deleteBook((Object[])message.get(1),action);
					break;
				case 10:		
					result = getUsers(action);
					break;
				case 11:		
					result = deleteUser((String)message.get(1),action);
					break;				
			}
			sendMessage((Object)result);			
		}		
	}
	
	/** Log out */
	private static ArrayList<Object> logOut(String message,int action){
		ArrayList<Object> result;
		
		System.out.println("<action> "+message);
		result = new ArrayList<Object>();
		result.add(action);
		result.add("true");
		return result;
	}
	
	/** Show all users */
	private static ArrayList<Object> getUsers(int action) {
		ArrayList<Object> message = new ArrayList<Object>();
		ArrayList<Object> users = new ArrayList<Object>(DaoFactory.getUserDao().getUsers());
		
		System.out.println("<action> Get all users");
		message.add(action);
		message.add(true);
		message.add(users);
		return message;
	}
	
	/** Delete user */
	private static ArrayList<Object> deleteUser(String login,int action) {		
		ArrayList<Object> message = new ArrayList<Object>();
		
		message.add(action);
		if (!DaoFactory.getUserDao().delete(login)) {
			message.add(false);
			message.add("User not found or administrator");
			System.out.println("<warning> User not found or administrator!");
		}else {
			message.add(true);
			message.add("User "+login+" was deleted");
			System.out.println("<action> User "+login+" was deleted");
		}	
		return message;
	}
}

