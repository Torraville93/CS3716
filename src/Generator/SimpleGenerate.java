package Generator;

import java.util.ArrayList;

import Groups.Group;
import Users.Student;

public class SimpleGenerate implements GeneratorStrategy {
	

	public ArrayList<Group> generateGroups(ArrayList<Student> studentList, int groupSize) {

		ArrayList<Student> studentListCopy = studentList;
		ArrayList<Group> completeListOfGroups = new ArrayList<Group>();
		
		Group tempGroup = new Group();
		
//		while(studentListCopy.size() != 1){
			for (int i = 0 ; i < studentList.size() ; i++) {
				if (studentListCopy.size() > 3) {
					for (int j = 0 ; j < 3 ; j++) {
						tempGroup.addStudent(studentListCopy.get(0));
						studentListCopy.remove(0);
					}
					completeListOfGroups.add(tempGroup);
					tempGroup = new Group();
				}
				else {
					tempGroup.addStudent(studentListCopy.get(0));
					studentListCopy.remove(0);
				}
				completeListOfGroups.add(tempGroup);
				tempGroup = new Group();
			}
			
			
	//		tempGroup.addStudent(studentListCopy.get(i));
		//	studentListCopy.remove(i);

	//		System.out.println(i);
		//	i++;
	//		if (i == 2) {
	//			completeListOfGroups.add(tempGroup);
		//	    tempGroup = new Group();
				//i = 0;
			//}
	//	}
		
		return completeListOfGroups;
	}

}
