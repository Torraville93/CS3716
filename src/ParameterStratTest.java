import generator.*;
import groupSystem.GroupSystem;
import groups.Group;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;

import parameters.GroupParameter;
import parameters.Param;
import parameters.ParameterSpec;
import retrieval.*;
import systemUI.*;
import users.*;
public class ParameterStratTest {




	public static void main(String[] args) throws IOException {

		GroupSystem system = new GroupSystem();
		Scanner in = new Scanner(System.in);
		System.out.println("Please input group size(int): ");
		int size = in.nextInt();
		system.getGroupManager().setGroupSize(size);
		RetrieveStudents rs = new StudentsFromFile();
		GroupSystem.students = rs.getStudents();		
		List<Student> testGroup = GroupSystem.students;
		
		/**
		 * For each student in the group of students, 
		 * Add a param to the paramList
		 */
		for(Student student:testGroup){
			EnumMap<Param, String> tmpMap = new EnumMap<Param,String>(Param.class);
			
			tmpMap.put(Param.NAME, "GPA");
			tmpMap.put(Param.QUERY, "What is your current GPA?");
			system.getParameterList().add(new GroupParameter(new ParameterSpec(tmpMap)));
			student.setParameters(system.getParameterList());
		}

		/**
		 * For each param in the ParamList
		 * Add a RESPONSE - The GPA for testing purposes
		 */
		for(GroupParameter param:system.getParameterList()){
			String myGPA = String.valueOf(Math.random()*3+1);
			String test = myGPA.substring(0, 4);
			param.getSpec().addProperty(Param.RESPONSE, test);
		}
		
		


		GeneratorStrategy gs = new ParameterStrat();
		ArrayList<Group> aa = gs.generateGroups();
		int grpNum = 1;
	/*
	 *For each param in paramList
	 *Print the param. 
	 */
//		for(GroupParameter param:system.getParameterList()){
//			System.out.println(param.toString());
//		}
		
		for(Student stu:testGroup){
			System.out.println(stu.getName());
			System.out.println(stu.getParameters().get(1).toString() + "\n");
		}
		
		
//		System.out.println("\nGenerating groups using simple strategy: ");
//		for (Group grp: aa) {
//			System.out.println("--Group "+grpNum); grpNum++; 
//			for (Student stu: grp.getStudents()) {
//				System.out.println("\t"+stu.getName());
//			}
//		}
	}
}



