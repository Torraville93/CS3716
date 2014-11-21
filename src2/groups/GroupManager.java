package groups;

import generator.*;

import java.io.IOException;
import java.util.ArrayList;


import users.Student;

public class GroupManager {
	
	private GeneratorStrategy strategy;
	public static int groupSize;
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
	
	/*
	import Retrevial.StudentsFromFile;
    import SystemUI.GroupPreferenceManager_UI;
 
	 
	private Generator.GeneratorStrategy strategy;
	GroupPreferenceManager_UI groupUI = new GroupPreferenceManager_UI();	
	private ArrayList<Student> studentList;
	private int groupSize;
	
	public GroupManager(Generator.GeneratorStrategy strategy) {
		this.strategy = strategy;
	}

	public void setGroupSize(int i){
		groupSize = i;
	}
	
	public int getGroupSize(){
		return groupSize;
	}
	
	public ArrayList<Group> createGroups() throws IOException{
	//	StudentsFromFile sff = new StudentsFromFile();
	//	studentList = sff.getStudents();	
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		Student s1 = new Student("Marc", 1);
		Student s2 = new Student("John", 2);
		Student s3 = new Student("Jean", 3);
		Student s4 = new Student("Solid Snake", 4);
		Student s5 = new Student("Woody Harrelson", 5);
		Student s6 = new Student("Mr. T", 6);
		Student s7 = new Student("Mrs. T", 7);
		Student s8 = new Student("Chair", 8);
		Student s9 = new Student("Desk",9);
		Student s10 = new Student("Liquid Snake", 10);
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		studentList.add(s7);
	    studentList.add(s8);
		studentList.add(s9);
		studentList.add(s10);
		
		return this.strategy.generateGroups(studentList, 3);
	}*/

}
