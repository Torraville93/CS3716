package generator;

import groupSystem.GroupSystem;
import groups.Group;
import groups.GroupManager;

import java.util.ArrayList;
import java.util.List;

import parameters.GroupParameter;
import users.Student;

//Currently identical to SimpleStrat just so the UI doesn't freak out when we select this strategy.
//Also renamed it to ParameterStrat instead of DecentStrat
public class ParameterStrat implements GeneratorStrategy {
	

	//@Override
	public ArrayList<Group> generateGroups() {
		ArrayList<Group> tmp = new ArrayList<Group>();
		int numStudents = GroupSystem.students.size();
		int grpSize = GroupManager.groupSize;
		
		List<Student> testGroup = GroupSystem.students;
	
		
		for (int i = 0; i < numStudents; i += grpSize) {
			int end = Math.min(i + grpSize, numStudents);
			List<Student> tmpGrp = GroupSystem.students.subList(i, end);
			tmp.add(new Group(tmpGrp));
		}
		return tmp;
	}

}
