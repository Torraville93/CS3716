package retrieval;
/*
 * An interface to allow the system to retrieve students
 */
import java.io.IOException;
import java.util.ArrayList;

import users.Student;


public interface RetrieveStudents {
	
	public ArrayList<Student> getStudents() throws IOException ;

}
