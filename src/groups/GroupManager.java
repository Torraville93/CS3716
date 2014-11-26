package groups;

import generator.*;

import java.io.IOException;
import java.util.ArrayList;


import users.Student;

public class GroupManager {
	
	private GeneratorStrategy strategy;
	public static int groupSize = 3; //Default group size
	private ArrayList<Group> groups;
	
	public GroupManager() {}
	public GroupManager(GeneratorStrategy strategy) {
		this.setStrategy(strategy);
	}
	
	public void setGroupSize(int i){
		groupSize = i;
		//System.out.println(groupSize);
	}
	
	public int getGroupSize(){
		return groupSize;
	}

	public GeneratorStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(GeneratorStrategy strategy) {
		this.strategy = strategy;
	}
	
	public ArrayList<Group> generateGroups(GeneratorStrategy strategy) {
		return strategy.generateGroups();
	}
	public ArrayList<Group> getGroups() {
		return groups;
	}
	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}
	
	public void addGroup(Group aGroup) {
		groups.add(aGroup);
	}
}
