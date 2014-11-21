package groupSystem;

import groups.GroupManager;

import java.util.ArrayList;
import java.util.Map;

import parameters.*;
import users.*;


public class GroupSystem {
	
	public static ArrayList<Student> students;
	private String deadline;
	private Instructor instructor;
	private GroupManager groups;
	private static ArrayList<GroupParameter> params;
	private String courseName;
	private String description;
	
	public GroupSystem() {
		students = new ArrayList<Student>();
		instructor = new Instructor();
		setGroupManager(new GroupManager());
		params = ParameterCollection.getInstance();
	}
	
	public void setDeadline(String date){
		deadline = date;
		//System.out.println(deadline);
	}
	
	public void addStudent(Student student){
		students.add(student);
	}

    public boolean removeStudent(Student student){
    	return students.remove(student);
    }
    
    public Student getStudent(Number number) {
    	for (Student stu : students) {
    		if (stu.getID() == number) return stu;
    	}
    	return null;
    }
    
    public void addInstructor(Instructor instructor) {
    	this.instructor = instructor;
    }
    
    public ParameterSpec getParameters() {
    	return instructor.getParameters();
    }

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
		//System.out.println(this.courseName);
	}

	public GroupManager getGroupManager() {
		return groups;
	}

	public void setGroupManager(GroupManager groups) {
		this.groups = groups;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		//System.out.println(this.description);
	}
	
    
    
    
    /*package SystemFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import Groups.Group;
import Groups.GroupManager;
import Parameters.*;
import Users.*;


public class GroupSystem {
	
	ArrayList<Student> students;
	private String deadline;
	private Instructor instructor;
	private GroupManager groupManager;
	private ArrayList<GroupParameter> params;
	
	public GroupSystem() {
		students = new ArrayList<Student>();
		instructor = new Instructor();
		groupManager = new GroupManager(new Generator.SimpleGenerate());
	}
	
	public void setDeadline(String date){
		deadline = date;
	}
	
	
    public Student getStudent(Number number) {
    	for (Student stu : students) {
    		if (stu.getNumber() == number) return stu;
    	}
    	return null;
    }
    
    public void addInstructor(Instructor instructor) {
    	this.instructor = instructor;
    }
    
    public ParameterSpec getParameters() {
    	return instructor.getParameters();
    }
    
	public void setGroupSize(int groupSize){
		groupManager.setGroupSize(groupSize);
	}
	
	public int getGroupSize(){
		return groupManager.getGroupSize();
	}
	
	public static void main(String[] args) throws IOException {
		GroupManager gm;
		gm = new GroupManager(new Generator.SimpleGenerate());
		ArrayList<Group> groupList = gm.createGroups();
		
		for (int i = 0 ; i < groupList.size(); i++) {
			groupList.get(i).getStudentNames();
			System.out.println("");
		}
	}
	
	
}*/
}
