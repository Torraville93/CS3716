package retrieval;

import java.io.IOException;
import java.util.ArrayList;

import users.Student;

/**
 * RetrieveStudents interface to allow the use of varying ways to add 
 * students to the system. 
 * Follows the strategy design pattern.
 */
public interface RetrieveStudents {
	
	/**
	 * Get list of Student's based on concrete method.
	 * @return - list of Student's
	 * @throws IOException - when getting from file.
	 */
	public ArrayList<Student> getStudents() throws IOException ;

}
