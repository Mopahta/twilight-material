package by.bsuir.Kaminsky.server.DataAccessLayer.UserDao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import by.bsuir.Kaminsky.models.User;


public class UserDao implements IUserDao {
	/** Path to users database */
	private String fileName;
		
	/** Constructor set the path to users database */
	public UserDao()
	{
		fileName = getDatabasePath();
	}
	
	/**
	 * Delete user from users database
	 * @param login - Users email
	 * @return return true if user was successfully deleted from users database, else return false
	 */
	public Boolean delete(String login){
		int counter = 0;
		Boolean flag = false;
		ArrayList<User> users = getUsers();
		
		for (User currentUser : users) {
			if ( (currentUser.getLogin()).equals(login) && !currentUser.getIsAdministrator() ){	
				flag = true;
				break;
			}
			counter++;
		}
		if (flag)
		{
			users.remove(counter);
			try {
				SerializeUsers(users, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * Save user to users database
	 * @param user - User entity
	 * @return return true if user was successfully added to users database, else return false
	 */
    public Boolean save(User user) {
    	Boolean flag = false;
		File f = new File(fileName);	
		User searchUser = null;
		ArrayList<User> users = getUsers();		
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		for (User currentUser : users) {
			if (currentUser.equals(user))
			{
				searchUser = currentUser;
				break;
			}
		}
		if (searchUser == null)
		{
			users.add(user);
			flag = true;
				
			try {
				SerializeUsers(users, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		return flag;
    }
    
    /**
     * Get user by login and password
     * @param login - User's login
     * @param password - User's password
     * @return return user entity if it was found in users database, else return null
     */
    public User getAuthorizeUser(String login, String password) {
    	ArrayList<User> users = getUsers();
		User result = null;
		
		for (User user : users) {
			if ( (user.getPassword().equals(password)) && (user.getLogin().equals(login)) )
			{
				result = user;
				break;
			}
		}
		return result;
    }
    
    /**
     * Get all users from users database
     * @return return list of user entities if they was successfully loaded from file, else return empty list
     */
    public ArrayList<User> getUsers(){
    	File f = new File(fileName);
		ArrayList<User> users = new ArrayList<User>();
					
		if(f.exists() && !f.isDirectory()) {			
			try {
				users = DeserializeUsers(fileName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
    	return users;
    }
    
    /**
     * Serialize list of user entities to users database
     * @param users - List of user entities
     * @param fileName - path to users database
     */
    private void SerializeUsers(ArrayList<User> users,String fileName) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(fileName);	    
	    XMLEncoder encoder = new XMLEncoder(fileStream);
	    
	    encoder.writeObject(users);
	    encoder.close();
	    fileStream.close();
	    //ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    //objectStream.writeObject(users);
	    //objectStream.close();
	}	
	
    /**
     * Deserialize list of user entities from users database
     * @param fileName - path to users database
     * @return return list of user entities if they was successfully loaded from file, else return empty list
     */
	@SuppressWarnings("unchecked")
	private ArrayList<User> DeserializeUsers(String fileName) throws IOException, ClassNotFoundException{
		ArrayList<User> result;
		FileInputStream fileStream = new FileInputStream(fileName);   
		XMLDecoder decoder = new XMLDecoder(fileStream);
		
		result = (ArrayList<User>)decoder.readObject();
		decoder.close();
	    fileStream.close();
	    return result;
	}
    
	/**
     * Calculate path to users database
     * @return return path to users database
     */
    private String getDatabasePath(){
    	return new File("").getAbsolutePath()+"\\src\\by\\bsuir\\Kaminsky\\server\\database\\UsersDatabase.xml";
	}    
}

