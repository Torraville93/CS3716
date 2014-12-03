package groups;

import generator.*;

import java.util.ArrayList;

/**
 * Manages all Group's. Contains a list of Group's of Student's, and 
 * handles some operations to do with these Group's.
 */
public class GroupManager {
	
	private GeneratorStrategy strategy;
	public static int groupSize = 3; //Default group size
	private ArrayList<Group> groups;
	
	/**
	 * Constructors. Initialises GeneratorStrategy.
	 * Default group generating strategy is SimpleStrat
	 */
	public GroupManager() { strategy = new SimpleStrat(); }
	public GroupManager(GeneratorStrategy strategy) {
		this.setStrategy(strategy);
	}
	
	/**
	 * Set the number of Student's a Group may contain.
	 * @param aSize - a group size.
	 */
	public void setGroupSize(int aSize){
		groupSize = aSize;
	}
	
	/**
	 * Get the number of Student's allowed in a Group.
	 * @return - size of group
	 */
	public int getGroupSize(){
		return groupSize;
	}

	/**
	 * Get the group-generating strategy.
	 * @return - the group-generating strategy.
	 */
	public GeneratorStrategy getStrategy() {
		return strategy;
	}

	/**
	 * Set the strategy used to generate Group's of Student's
	 * @param strategy - a concrete GeneratorStrategy
	 */
	public void setStrategy(GeneratorStrategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * Generate Group's of Student's using given strategy.
	 * Delegated to the concrete GeneratorStrategy.
	 * @param strategy - the strategy to use.
	 * @return - list of Group's of Student's
	 */
	public ArrayList<Group> generateGroups(GeneratorStrategy strategy) {
		return strategy.generateGroups();
	}
	
	/**
	 * Get a list of Group's of Student's
	 * @return - a list of Group's of Student's
	 */
	public ArrayList<Group> getGroups() {
		return groups;
	}
	
	/**
	 * Set a list of Group's of Student's
	 * @param groups - list of Group's
	 */
	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}
	
	/**
	 * Add a Group of Student's to the list of Group's
	 * @param aGroup - a Group of Student's
	 */
	public void addGroup(Group aGroup) {
		groups.add(aGroup);
	}
}
