package Generator;

import java.util.ArrayList;

import Groups.Group;
import Users.Student;

 interface GeneratorStrategy {
	
	
	 ArrayList<Group> generateGroups(ArrayList<Student> studentList, int groupSize);
}
