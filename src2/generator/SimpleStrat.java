package generator;

import groupSystem.*;
import groups.*;

import java.util.ArrayList;

import users.Student;

public class SimpleStrat implements GeneratorStrategy {

	@Override
	public ArrayList<Group> generateGroups() {
		ArrayList<Group> tmp = new ArrayList<Group>();
		Group group = new Group();
		int numStudents = GroupSystem.students.size();
		int grpSize = GroupManager.groupSize;
		
		if (numStudents % grpSize == 0) { //Divides evenly
			group.addStudent(GroupSystem.students.get(0));
			for (int i=1; i<numStudents; i++) {
				
				if (group.getStudents().size() < grpSize) {
					group.addStudent(GroupSystem.students.get(i));
				} else {
					tmp.add(group);
					group = new Group();
					group.addStudent(GroupSystem.students.get(i));
				}
					
					//group.addStudent(GroupSystem.students.get(i));
					//System.out.println(i+" "+ group.getStudents().size());
					//System.out.println(tt.get(i).getName());
				//System.out.println("end"+tmp.get(i).getStudents().size());
			}
			
		}
		else {
			group.addStudent(GroupSystem.students.get(0));
			for (int i=1; i<numStudents-(numStudents%grpSize); i++) {
				if (group.getStudents().size() < grpSize) {
					group.addStudent(GroupSystem.students.get(i));
				} else {
					tmp.add(group);
					group = new Group();
					group.addStudent(GroupSystem.students.get(i));
				}
			}
		}		
		
		return tmp;
		
		
		
		/*
		//for (Student stu: GroupSystem.students) {
		for (int i=0; i<numStudents; i++) {
			if (numStudents % grpSize == 0) {
				for (int j=0; j<grpSize; j++)
					group.addStudent(GroupSystem.students.get(j));
			} else {
				int remainder = numStudents % grpSize;
				for (int j=0; j<grpSize-remainder; j++)
					group.addStudent(GroupSystem.students.get(j));
				for (int j=0; j<remainder; j++)
					group.addStudent(GroupSystem.students.get(j));
			}
			tmp.add(group);
			group = new Group();
		}
		return tmp;*/
	}

	
	
	
	
	
	
	
	/*public ArrayList<Group> generateGroups(ArrayList<Student> studentList, int groupSize) {

		ArrayList<Student> studentListCopy = studentList;
		ArrayList<Group> completeListOfGroups = new ArrayList<Group>();
		
		Group tempGroup = new Group();
		
		while(studentListCopy.size() != 1){
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
			
			
		tempGroup.addStudent(studentListCopy.get(i));
			studentListCopy.remove(i);

			System.out.println(i);
			i++;
			if (i == 2) {
				completeListOfGroups.add(tempGroup);
			    tempGroup = new Group();
				i = 0;
			}
		}
		
		return completeListOfGroups;
	}*/

}
