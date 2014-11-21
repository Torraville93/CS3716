package groups;

import java.util.ArrayList;

import users.Student;

public class Group {
	
	private ArrayList<Student> stuList;
	
	public Group() { stuList = new ArrayList<Student>(); }
	public Group(ArrayList<Student> students) {
		stuList = students;
	}
	
	public void addStudent(Student student){
			stuList.add(student);
	}

    public boolean removeStudent(Student student){
    	return stuList.remove(student);
    }
	
    public ArrayList<Student> getStudents() {
    	return stuList;
    }
	
	
	
	/*
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
    }*/
}
