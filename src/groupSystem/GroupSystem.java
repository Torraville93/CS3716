package groupSystem;

import groups.GroupManager;

import java.util.ArrayList;
import java.util.List;

import parameters.*;
import retrieval.*;
import users.*;

/**
 * Main group generating system. Acts as a central hub for all system 
 * operations. Allows an instructor to add project information such as 
 * description, deadline, group size, course name. 
 * Also handles the choice of student retrieval methods, for adding students 
 * to the system, as well as group generating strategy to create groups.
 */
public class GroupSystem {
	
	public static List<Student> students;
	private String deadline;
	private Instructor instructor;
	private GroupManager groups;
	private List<GroupParameter> params;
	private String courseName;
	private String description;
	private RetrieveStudents retrievalMethod;
	
	/**
	 * Constructor. Initialises some instance variables.
	 * Default student retrieval method is from a CSV file.
	 */
	public GroupSystem() {
		students = new ArrayList<Student>();
		setInstructor(new Instructor());
		setGroupManager(new GroupManager());
		params = instructor.getParameters();
		setRetrievalMethod(new StudentsFromFile());
	}
	
	/**
	 * Set project deadline.
	 * @param date - deadline for project
	 */
	public void setDeadline(String date){
		deadline = date;
	}
	
	/**
	 * Get deadline for project.
	 * @return - project deadline
	 */
	public String getDeadline() {
		return deadline;
	}
	
	/**
	 * Add a Student to list of Student's.
	 * @param student - a student to add
	 */
	public void addStudent(Student student){
		students.add(student);
	}

	/**
	 * Remove a Student from list of Student's
	 * @param student - the Student to remove
	 * @return - boolean, if it succeed or not.
	 */
    public boolean removeStudent(Student student){
    	return students.remove(student);
    }
    
    /**
     * Get Student from list of Student's by student ID.
     * @param numID - student ID number
     * @return - the respective student, or null.
     */
    public Student getStudent(Number numID) {
    	for (Student stu : students) {
    		if (stu.getID() == numID) return stu;
    	}
    	return null;
    }
    
    /**
     * Overwrites current instructor in case an error was made, or if 
     * something needs to be edited.
     * @param instructor - new instructor.
     */
    public void setInstructor(Instructor instructor) {
    	this.instructor = instructor;
    }

    /**
     * Get name of the instructor's course.
     * @return - course name
     */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Set name of the instructor's course.
	 * @param courseName - name of a course.
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Get GroupManager that manages the Group's of Student's
	 * @return - the group manager.
	 */
	public GroupManager getGroupManager() {
		return groups;
	}

	/**
	 * Set a GroupManager to manage Group's.
	 * @param groups - a group manager.
	 */
	public void setGroupManager(GroupManager groups) {
		this.groups = groups;
	}

	/**
	 * Get project description.
	 * @return - the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set project description.
	 * @param description - a description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get method of Student Retrieval.
	 * @return - the retrieval method.
	 */
	public RetrieveStudents getRetrievalMethod() {
		return retrievalMethod;
	}

	/**
	 * Set a method to retrieve Student's to add Student's to system.
	 * @param retrievalMethod - a retrieval method.
	 */
	public void setRetrievalMethod(RetrieveStudents retrievalMethod) {
		this.retrievalMethod = retrievalMethod;
	}
	
	/**
	 * Get list of GroupParameter's added by the instructor.
	 * These questions help to generate fairer Group's.
	 * Delegated to instructor.
	 * @return - list of GroupParameter's
	 */
	public List<GroupParameter> getParameterList() {
		return instructor.getParameters();
	}
	
	/**
	 * Create a copy of instructor's parameter list for each Student,
	 * So they can add their responses.
	 */
	public void initStuParamLists() {
		if (!students.isEmpty()) {
			List<GroupParameter> tmpList;
			for(Student stu: students){
				tmpList = new ArrayList<GroupParameter>();
				for (int i=0; i<params.size(); i++) {
					tmpList.add(new GroupParameter(
							new ParameterSpec(
									params.get(i).getSpec().getProperties()
					)));
				}
				stu.setParameters(tmpList);
			}
		}
	}
}
