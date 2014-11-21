package Groups;

import java.util.ArrayList;

import Users.Student;

public class Group {
	ArrayList<Student> studentGroup;
	
	public void addStudent(Student student){
		studentGroup.add(student);
	}

    public boolean removeStudent(Student student){
    	return studentGroup.remove(student);
    }

}
