package Groups;

import java.util.ArrayList;

import Users.Student;

public class Group {
	ArrayList<Student> studentGroup = new ArrayList<Student>();
	
	public void addStudent(Student student){
		studentGroup.add(student);
	}

    public boolean removeStudent(Student student){
    	return studentGroup.remove(student);
    }

    public void getStudentNames() {
    	for (int i = 0 ; i < studentGroup.size() ; i++) {
    		System.out.println(studentGroup.get(i).getName());
    	}
    }
    
}
