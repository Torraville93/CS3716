package users;

import java.util.List;

import parameters.GroupParameter;
import parameters.Param;
import parameters.ParameterSpec;

public class Student implements User {
		
	private String name;
	private Number numID;
	private List<GroupParameter> parameters;
	
	public Student() {}
	public Student(String name, Number numID) {
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

	public List<GroupParameter> getParameters() {
		return parameters;
	}
	
	public void setParameters(List<GroupParameter> paramList) {
		parameters = paramList;
	}

}
