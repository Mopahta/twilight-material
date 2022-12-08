package by.bsuir.Kaminsky.client.controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.bsuir.Kaminsky.client.view.ArchiveView;


public class Controller {
	
	/** 
	 * Make authorization request to user and validate answer
	 * @return list of parameters, input by user
	 */
	public static Object[] authorizeRequest(){
		Object[] result  = ArchiveView.getPersonalData();
		
		result[1] = ((String)result[1]).trim();
		result[2] = ((String)result[2]).trim();
		if ( isValidEmailAddress((String)result[1]) && isValidPassword((String)result[2]) )
			return result;
		else{		
			notifyUserRequest("Uncorrect login or password!");
			return null;		
		}
	}
	
	/** 
	 * Make request for book parameters to user and validate answer
	 * @return list of parameters, input by user
	 */
	public static Object[] getBookRequest() {
		Object[] result = ArchiveView.getBookData();
		
		result[0] = ((String)result[0]).trim();
		result[1] = ((String)result[1]).trim();
		if ( ( ((String)result[0]).length() >0 ) && ( ((String)result[1]).length()>0 ) )
			return result;
		else{		
			notifyUserRequest("Uncorrect data");
			return null;		
		}
	}	
	
	/** 
	 * Make book replace request to user and validate answer
	 * @return list of parameters, input by user
	 */
	public static Object[] replaceBookRequest() {
		Object[] resultOld,resultNew;
		
		ArchiveView.showMessage("Enter the book you want to change");
		resultOld = ArchiveView.getBookData();
		resultOld[0] = ((String)resultOld[0]).trim();
		resultOld[1] = ((String)resultOld[1]).trim();
		if ( ( ((String)resultOld[0]).length() >0 ) && ( ((String)resultOld[1]).length()>0 ) ) {
			ArchiveView.showMessage("Enter new book");
			resultNew = ArchiveView.getBookData();
			resultNew[0] = ((String)resultNew[0]).trim();
			resultNew[1] = ((String)resultNew[1]).trim();
			if ( ( ((String)resultNew[0]).length() >0 ) && ( ((String)resultNew[1]).length()>0 ) ) {
				return new Object[] {resultOld[0],resultOld[1],resultOld[2],resultNew[0],resultNew[1],resultNew[2]};
			}else {
				notifyUserRequest("Uncorrect data");
				return null;
			}
		}else{		
			notifyUserRequest("Uncorrect data");
			return null;		
		}		
	}
	
	/** 
	 * Make request for specified parameter input to user and validate answer
	 * @param parameterName - Name of input parameter
	 * @return value of parameter, input by user
	 */
	public static String getParameterRequest(String parameterName) {
		String result = ArchiveView.getParameter(parameterName);
		
		if (result.length()>0)
			return result;
		else
			notifyUserRequest("Uncorrect "+parameterName);			
		return null;
	}
	
	/** 
	 * Make request for choose action to user and validate answer
	 * @param isAdmin - Define type of user
	 * @return user selection
	 */
	public static int chooseActionRequest(Boolean isAdmin){
		int result  = -1;
		String action = ArchiveView.getAction().toLowerCase().trim();
		
		//string switch available from java8
		switch (action) {
			case "/exit":	
				result=0;
				break;
			case "/logout":	
				result=1;
				break;
			case "/show":	
				result=2;
				break;
			case "/findt":	
				result=3;
				break;
			case "/finda":	
				result=4;
				break;
			case "/finde":	
				result=5;
				break;
			case "/findp":	
				result=6;
				break;
			case "/mod":	
				result=7;
				break;
			case "/add":	
				result=8;
				break;
			case "/delete":	
				result=9;
				break;
			case "/allusers":	
				result=10;
				break;
			case "/udelete":	
				result=11;
				break;
			case "/help":
				ArchiveView.printAvailableActions();
				break;
			default:
				notifyUserRequest("Unknown command!");
				break;
		}
		if (!isAdmin && result>6) {
			notifyUserRequest("You dont have enough root!");
			result = -1;
		}
		return result;
	}
	
	/** 
	 * Notify users by sending message
	 * @param message - Message
	 */
	public static void notifyUserRequest(String message) {
		ArchiveView.showMessage("<"+message+">");
	}
	
	/** 
	 * Make request for print list to user
	 * @param list - List
	 */
	public static void printListRequest(ArrayList<Object> list) {
		int counter = 1;
		
		for (Object object : list) {
			ArchiveView.showMessage(counter+":\n"+object.toString());
			counter++;
		}
		if (counter == 1)
			notifyUserRequest("Books not found");
	}
	
	/** 
	 * Validate email address
	 * @param  email - Email address
	 * @return true if address is correct, else return false
	 */
	private static Boolean isValidEmailAddress(String email) {
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.find();		
    }
	
	/** 
	 * Validate password
	 * @param  password - Password
	 * @return true if password is correct, else return false
	 */
	private static Boolean isValidPassword(String password) {
		if (password.length() < 5)
			return false;
		else {
			return true;			
		}
	}
}
