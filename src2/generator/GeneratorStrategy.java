package generator;

import groups.Group;

import java.util.ArrayList;

import users.Student;

public interface GeneratorStrategy {
	
	public ArrayList<Group> generateGroups();
	
	
	
	//ArrayList<Group> generateGroups(ArrayList<Student> studentList, int groupSize);
}
