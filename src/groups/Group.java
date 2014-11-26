package groups;

import java.util.ArrayList;
import java.util.List;

import users.Student;

public class Group {
	
	private List<Student> stuList;
	
	public Group() { stuList = new ArrayList<Student>(); }
	public Group(List<Student> tmpGrp) {
		stuList = tmpGrp;
	}
	
	public void addStudent(Student student){
			stuList.add(student);
	}

    public boolean removeStudent(Student student){
    	return stuList.remove(student);
    }
	
    public List<Student> getStudents() {
    	return stuList;
    }
}
