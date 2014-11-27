package groupSystem;

import generator.GeneratorStrategy;
import groups.GroupManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import parameters.*;
import retrieval.*;
import users.*;


public class GroupSystem {
	
	public static List<Student> students;
	private String deadline;
	private Instructor instructor;
	private GroupManager groups;
	private List<GroupParameter> params;
	private String courseName;
	private String description;
	private RetrieveStudents retrievalMethod;
	
	public GroupSystem() {
		students = new ArrayList<Student>();
		setInstructor(new Instructor());
		setGroupManager(new GroupManager());
		params = instructor.getParameters();
		setRetrievalMethod(new StudentsFromFile());
	}
	
	public void setDeadline(String date){
		deadline = date;
	}
	
	public String getDeadline() {
		return deadline;
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
    
    public void setInstructor(Instructor instructor) {
    	this.instructor = instructor;
    }

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	}

	public RetrieveStudents getRetrievalMethod() {
		return retrievalMethod;
	}

	public void setRetrievalMethod(RetrieveStudents retrievalMethod) {
		this.retrievalMethod = retrievalMethod;
	}
	
	public List<GroupParameter> getParameterList() {
		return instructor.getParameters();
	}
}
