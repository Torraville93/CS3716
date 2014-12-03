package generator;

import groupSystem.*;
import groups.*;

import java.util.ArrayList;
import java.util.List;

import users.Student;

/**
 * Group generating strategy that assigns students to groups based 
 * on group size. Iterates through list of students creating somewhat 
 * unfair groups. Remaining students are added to an extra group if 
 * number of students isn't divisible by group size.
 */
public class SimpleStrat implements GeneratorStrategy {

	/**
	 * Generates groups of students of given size.
	 * @return - list of student Group's
	 */
	@Override
	public ArrayList<Group> generateGroups() {
		ArrayList<Group> tmp = new ArrayList<Group>();
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
