package users;

import java.util.List;

import parameters.*;

/**
 * User interface to allow the use of different concrete users. 
 * Follows the strategy design pattern.
 */
public interface User {
	
	/**
	 * Set user name.
	 * @param name - a name.
	 */
	public void setName(String name);
	
	/**
	 * Get user name.
	 * @return - the name.
	 */
	public String getName();
	    
	/**
	 * Set user ID number.
	 * @param numID - an ID number.
	 */
	public void setID(Number numID);
	    
	/**
	 * Get user ID number.
	 * @return - the ID number.
	 */
	public Number getID();
	    
	/**
	 * Get list of user's GroupParameter's.
	 * @return - list of GroupParameter's.
	 */
	public List<GroupParameter> getParameters();

}
