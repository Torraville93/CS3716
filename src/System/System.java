package System;

import java.util.ArrayList;
import java.util.Map;

import Groups.GroupManager;
import Parameters.*;
import Users.*;


public class System {
	
	ArrayList<Student> students;
	private String deadline;
	private Instructor instructor;
	private GroupManager groups;
	private ArrayList<GroupParameter> params;
	
	public System() {
		students = new ArrayList<Student>();
		instructor = new Instructor();
		groups = new GroupManager();
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
    
	public void setGroupSize(SystemUI.GroupPreferenceManager_UI gpm){
		int i = gpm.getSizeOfGroup();
		groups.setGroupSize(i);
	}
	
	public int getGroupSize(){
		return groups.getGroupSize();
	}
	
	
	
	
}
