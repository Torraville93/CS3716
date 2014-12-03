package groups;

import java.util.ArrayList;
import java.util.List;

import users.Student;

/**
 * Group class containing a list of students, 
 * given a certain group size.
 */
public class Group {
	
	private List<Student> stuList;
	
	/**
	 * Constructors. Initialises list of Student's.
	 */
	public Group() { stuList = new ArrayList<Student>(); }
	public Group(List<Student> tmpGrp) {
		stuList = tmpGrp;
	}
	
	/**
	 * Add Student to Group.
	 * @param student - Student to add
	 */
	public void addStudent(Student student){
			stuList.add(student);
	}

	/**
	 * Remove Student from Group
	 * @param student - student to remove
	 * @return - boolean if it succeeded or not.
	 */
    public boolean removeStudent(Student student){
    	return stuList.remove(student);
    }
	
    /**
     * Get the list of Student's in the Group.
     * @return - list of Student's
     */
    public List<Student> getStudents() {
    	return stuList;
    }
}
