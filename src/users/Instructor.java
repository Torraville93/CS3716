package users;

import java.util.ArrayList;
import java.util.List;

import parameters.*;

public class Instructor implements User {
	
	private String name;
	private Number numID=0;//Default Instructor ID (using for now)
	private GroupParameter param;
	private List<GroupParameter> parameters;
		
	public Instructor() { parameters = ParameterCollection.getInstance(); }
	public Instructor(String name, Number numID) {
		this.name = name; 
		this.numID = numID;
		parameters = ParameterCollection.getInstance();
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

	public void addParameter(GroupParameter grpParam) {
		parameters.add(grpParam);
	}
	
	public boolean removeParameter(GroupParameter grpParam) {
		return parameters.remove(grpParam);
	}

	public List<GroupParameter> getParameters() {
		return parameters;
	}
}
