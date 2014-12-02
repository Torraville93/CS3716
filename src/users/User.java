package users;

import parameters.*;
//Super class to Instructor and Student
public class User {
		
	private String name;
	private Number numID;
	private GroupParameter params;
		
	public User() {}
	public User(String name, Number numID) {
		this.name = name; 
		this.numID = numID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
    	return name;
    }
	    
	public void setID(Number numID){
    	this.numID = numID;
    }
	    
	public Number getID(){
    	return numID;
    }

	public void addParameter(Param propertyName, String property) {
		params.addParameter(propertyName, property);
	}
	    
	public ParameterSpec getParameters() {
		return params.getSpec();
	}

}
