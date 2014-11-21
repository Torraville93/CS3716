package Groups;

import java.io.IOException;
import java.util.ArrayList;

import Retrevial.StudentsFromFile;
import SystemUI.GroupPreferenceManager_UI;
import Users.Student;

public class GroupManager {
	
	GroupPreferenceManager_UI groupUI = new GroupPreferenceManager_UI();

	private ArrayList<Student> studentList;
	private int groupSize;

	
	
	public void setGroupSize(int i){
		groupSize = i;
	}
	
	public int getGroupSize(){
		return groupSize;
	}
	
	public void createGroups() throws IOException{
		
	StudentsFromFile sff = new StudentsFromFile();
	studentList = sff.getStudents();
	
	
	
	}
	
	
	


}
