/*
 * A simple class to represent the course instructor.
 */
package Users;

import Parameters.*;

public class Instructor {
	
	private String name;
	private Number numID;
	private GroupParameter params;
	
	public Instructor() {}
	
    public void setName(String name){
    	this.name = name;
    }

    public String getName(){
    	return name;
    }

    public void setID(Number numID){
    	this.numID = numID;
    }

    public Number getNumber(){
    	return numID;
    }
    
    public void addParameter(String propertyName, String property) {
    	params.addParameter(propertyName, property);
    }
    
    public ParameterSpec getParameters() {
    	return params.getSpec();
    }

}
