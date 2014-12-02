package generator;

import groupSystem.*;
import groups.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrieval.RetrieveStudents;
import retrieval.StudentsFromFile;
import users.Student;
/*
*  SimpleStrat generates groups from given size by taking each student 
*  from being of list to end. No addition information.
*/
public class SimpleStrat implements GeneratorStrategy {

	//@Override
	public ArrayList<Group> generateGroups() {
		ArrayList<Group> tmp = new ArrayList<Group>();
		Group group = new Group();
		int numStudents = GroupSystem.students.size();
		int grpSize = GroupManager.groupSize;
		
		for (int i = 0; i < numStudents; i += grpSize) {
			int end = Math.min(i + grpSize, numStudents);
			List<Student> tmpGrp = GroupSystem.students.subList(i, end);
			tmp.add(new Group(tmpGrp));
		}
		return tmp;
	}	
}
