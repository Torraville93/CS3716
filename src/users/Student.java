package users;

import java.util.List;

import parameters.GroupParameter;

/**
 * Concrete User student, handles student information like 
 * name and ID, and list of GroupParameters with responses.
 */
public class Student implements User {
		
	private String name;
	private Number numID;
	private List<GroupParameter> parameters;
	
	/**
	 * Constructors. Initialises list of info.
	 */
	public Student() {}
	public Student(String name, Number numID) {
		this.name = name; 
		this.numID = numID;
	}

	/**
	 * Set student name.
	 * @param name - instructor name.
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Get student name.
	 * @return - a name.
	 */
	public String getName(){
    	return name;
    }
	    
	/**
	 * Set student ID.
	 * @param numID - an ID
	 */
	public void setID(Number numID){
    	this.numID = numID;
    }
	    
	/**
	 * Get student ID.
	 * @return - an ID
	 */
	public Number getID(){
    	return numID;
    }

	/**
	 * Get list of GroupParameter's
	 * @return - list of GroupParameter's.
	 */
	public List<GroupParameter> getParameters() {
		return parameters;
	}
	
	/**
	 * Set list of GroupParameter's
	 * @param - list of GroupParameter's.
	 */
	public void setParameters(List<GroupParameter> paramList) {
		parameters = paramList;
	}

}
