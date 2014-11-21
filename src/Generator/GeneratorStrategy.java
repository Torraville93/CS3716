package Generator;

import java.util.ArrayList;

import Groups.Group;
import Users.Student;

 public interface GeneratorStrategy {
	 ArrayList<Group> generateGroups(ArrayList<Student> studentList, int groupSize);
}
