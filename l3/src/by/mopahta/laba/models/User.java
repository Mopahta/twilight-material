package by.bsuir.Kaminsky.models;

import java.io.Serializable;


public class User implements Serializable {
	
	/** The unique version ID of the serialized class */
	private static final long serialVersionUID = 1L;
	
	/** User's login */
	private String login;
	
	/** User's password */
	private String password;
	
	/** User's type */
	private Boolean isAdministrator;
	
	/** Default constructor **/
	public User(){	
		
	}
	
	/** Constructor set users's login,password and type 
	 * @param login - User login
	 * @param password - User password
	 * @param isAdministrator - User type
	 * */
	public User(String login,String password,Boolean isAdministrator){
		this.login = login;
		this.password = password;
		this.isAdministrator = isAdministrator;
	}

	/**
	 * Get user's login
	 * @return return user's login
	 */
	public String getLogin(){
		return login;
	}
	
	/**
	 * Set user's login
	 * @param value - User's login
	 */
	public void setLogin(String value) {
		login = value;
	}
	
	/**
	 * Get user's password
	 * @return return user's password
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * Set user's password
	 * @param value - User's password
	 */
	public void setPassword(String value) {
		password = value;
	}
	
	/**
	 * Get user type
	 * @return return user's login
	 */
	public Boolean getIsAdministrator(){
		return isAdministrator;
	}
	
	/**
	 * Set user's type
	 * @param value - User's type
	 */
	public void setIsAdministrator(Boolean value) {
		isAdministrator = value;
	}
	
	/**
	 * Override equals method to compare users
	 * @param obj - User entity
	 */
	@Override
	public boolean equals(Object obj) {
		User user;
		
		if (obj == this) 
			return true;
		if (obj == null || obj.getClass() != this.getClass())
            return false;
		user = (User)obj;
        return ( login == user.login ||
            ( login != null && login.equals(user.getLogin()) ) );
	}
	
	/**
	 * Override toString method to print users
	 * @return string representation of object
	 */
	@Override
	public String toString() {
		String type = (isAdministrator)?"Administrator":"User";
		return  "Login: " + login +
                "\nType: "+ type;
	}
	
}

