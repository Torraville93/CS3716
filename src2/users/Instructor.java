package users;

import parameters.*;

public class Instructor extends User {
	
	public Instructor() {}
	public Instructor(String name, Number numID) {
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
	
	
	/*
	public Instructor() {}
	
    public void setName(String name){
    	this.name = name;
    }

    public String getName(){
    	return name;
    }

    public void setID(Number numID){
    	this.number = numID;
    }

    public Number getNumber(){
    	return number;
    }
    
    public void addParameter(Param propertyName, String property) {
    	params.addParameter(propertyName, property);
    }
    
    public ParameterSpec getParameters() {
    	return params.getSpec();
    }
*/
}
