package users;

import parameters.Param;
import parameters.ParameterSpec;

public class Student extends User {
		
	public Student() {}
	public Student(String name, Number numID) {
		super(name,numID);
	}
		
	public void setName(String name){
	   	super.setName(name);
	}

	public String getName(){
	   	return super.getName();
	}

	public void setID(Number numID){
	   	super.setID(numID);
	}

	public Number getID(){
	   	return super.getID();
	}
	    
	public void addParameter(Param propertyName, String property) {
	   	super.addParameter(propertyName, property);
	}
	    
	public ParameterSpec getParameters() {
	   	return super.getParameters();
	}
}
