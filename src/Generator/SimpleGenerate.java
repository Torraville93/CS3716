package Generator;

import java.util.ArrayList;

import Groups.Group;
import Users.Student;

public class SimpleGenerate implements GeneratorStrategy {
	

	public ArrayList<Group> generateGroups(ArrayList<Student> studentList, int groupSize) {

		ArrayList<Student> studentListCopy = studentList;
		ArrayList<Group> completeListOfGroups = new ArrayList<Group>();
		
		Group tempGroup = new Group();
		
		while(studentListCopy != null){
			for (int i = 0 ; i < groupSize ; i++) {
				tempGroup.addStudent(studentListCopy.get(i));
				studentListCopy.remove(i);
			}
			
			completeListOfGroups.add(tempGroup);
		}
		
		return completeListOfGroups;
	}

}
