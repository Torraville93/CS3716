package Groups;

import java.io.IOException;
import java.util.ArrayList;

import Retrevial.StudentsFromFile;
import SystemUI.GroupPreferenceManager_UI;
import Users.Student;

public class GroupManager {
	
	private Generator.GeneratorStrategy strategy;
	GroupPreferenceManager_UI groupUI = new GroupPreferenceManager_UI();	
	private ArrayList<Student> studentList;
	private int groupSize;
	
	public GroupManager(Generator.GeneratorStrategy strategy) {
		this.strategy = strategy;
	}

	public void setGroupSize(int i){
		groupSize = i;
	}
	
	public int getGroupSize(){
		return groupSize;
	}
	
	public ArrayList<Group> createGroups() throws IOException{
	//	StudentsFromFile sff = new StudentsFromFile();
	//	studentList = sff.getStudents();	
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		Student s1 = new Student("Marc", 1);
		Student s2 = new Student("John", 2);
		Student s3 = new Student("Jean", 3);
		Student s4 = new Student("Solid Snake", 4);
		Student s5 = new Student("Woody Harrelson", 5);
		Student s6 = new Student("Mr. T", 6);
		Student s7 = new Student("Mrs. T", 7);
		Student s8 = new Student("Chair", 8);
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		studentList.add(s7);
		studentList.add(s8);
		
		return this.strategy.generateGroups(studentList, groupSize);
	}

}
