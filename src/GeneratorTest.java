import generator.*;
import groupSystem.GroupSystem;
import groups.Group;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import retrieval.*;
import systemUI.*;
import users.*;


public class GeneratorTest {
	
	public static void main(String[] args) throws IOException {
		
		GroupSystem system = new GroupSystem();
		Scanner in = new Scanner(System.in);
		System.out.println("Please input group size(int): ");
		int size = in.nextInt();
		system.getGroupManager().setGroupSize(size);
		
		RetrieveStudents rs = new StudentsFromFile();
		GroupSystem.students = rs.getStudents();

//		GeneratorStrategy gs = new SimpleStrat();
//		ArrayList<Group> aa = gs.generateGroups();
//		int grpNum = 1;
//		System.out.println("\nGenerating groups using simple strategy: ");
//		for (Group grp: aa) {
//			System.out.println("--Group "+grpNum); grpNum++; 
//			for (Student stu: grp.getStudents()) {
//				System.out.println("\t"+stu.getName());
//			}
//		}
	}
}
