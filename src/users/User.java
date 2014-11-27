package users;

import java.util.List;

import parameters.*;

public interface User {
	
	public void setName(String name);
	
	public String getName();
	    
	public void setID(Number numID);
	    
	public Number getID();
	    
	public List<GroupParameter> getParameters();

}
