package generator;

import groups.Group;

import java.util.ArrayList;

/**
 * Generator interface to allow the use of varying group-generating 
 * algorithms. Follows the strategy design pattern.
 */
public interface GeneratorStrategy {
	
	/**
	 * Generates groups of students of given size.
	 * @return - list of student Group's
	 */
	public ArrayList<Group> generateGroups();
	
}
