package users;

import java.util.List;

import parameters.*;

/**
 * Concrete User instructor, handles instructor information like 
 * name and ID, and list of instructor-added GroupParameter's.
 */
public class Instructor implements User {
	
	private String name;
	private Number numID=0;//Default Instructor ID (using for now)
	private List<GroupParameter> parameters;
		
	/**
	 * Constructors. Initialises info and list of parameters.
	 */
	public Instructor() { parameters = ParameterCollection.getInstance(); }
	public Instructor(String name, Number numID) {
		this.name = name; 
		this.numID = numID;
		parameters = ParameterCollection.getInstance();
	}
	
	/**
	 * Set instructor name.
	 * @param name - instructor name.
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Get instructor name.
	 * @return - a name.
	 */
	public String getName(){
    	return name;
    }
	    
	/**
	 * Set instructor ID.
	 * @param numID - an ID
	 */
	public void setID(Number numID){
    	this.numID = numID;
    }
	    
	/**
	 * Get instructor ID.
	 * @return - an ID
	 */
	public Number getID(){
    	return numID;
    }

	/**
	 * Add a GroupParameter to list of parameters.
	 * @param grpParam - a GroupParameter.
	 */
	public void addParameter(GroupParameter grpParam) {
		parameters.add(grpParam);
	}
	
	/**
	 * Remove a GroupParameter from list of parameters.
	 * @param grpParam - a GroupParameter.
	 * @return - boolean, whether it succeeds or not.
	 */
	public boolean removeParameter(GroupParameter grpParam) {
		return parameters.remove(grpParam);
	}

	/**
	 * Get list of GroupParameter's
	 * @return - list of GroupParameter's.
	 */
	public List<GroupParameter> getParameters() {
		return parameters;
	}
}
