import generator.*;
import groupSystem.GroupSystem;
import groups.Group;
import groups.GroupManager;

import java.io.IOException;
import java.util.ArrayList;

import retrieval.*;
import systemUI.*;
import users.*;


public class test {
	
	public static void main(String[] args) throws IOException {
		//SystemUI gui = new SystemUI();
		//gui.setVisible(true);
		
		RetrieveStudents rs = new StudentsFromFile();
		GroupSystem.students = rs.getStudents();
		GroupManager.groupSize = 3;

		GeneratorStrategy gs = new SimpleStrat();
		ArrayList<Group> aa = gs.generateGroups();
		for (Group grp: aa) {
			for (Student stu: grp.getStudents()) {
				System.out.println(stu.getName()+" ");
			}
			System.out.println();
		}
		
		/*
		GeneratorStrategy gs = new SimpleStrat();
		for (Group grp: gs.generateGroups()) {
			for (Student stu: grp.getStudents()) {
				System.out.println(stu.getName() +" "+ stu.getID());
			}
		}
		
		/*RetrieveStudents rs = new StudentsFromFile();
		for (Student stu: rs.getStudents()) {
			System.out.println(stu.getName() +" "+ stu.getID());
		}
		
		/*RetrieveStudents rs = new StudentsFromFile();
		try {
			GroupSystem.students = rs.getStudents();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}

}
