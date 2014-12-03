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
import users.*;

/**
 * Testing class used for GeneratorStrategy ParameterStrat.
 * Strategy still only generates students by GPA, putting them into groups 
 * where each group has equal number of strong and weak students. In the case 
 * of odd group size, more weak students are added.
 */
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
		
		//Simulate instructor added questions
		EnumMap<Param, String> tmp = new EnumMap<Param,String>(Param.class);
		tmp.put(Param.NAME, "GPA"); tmp.put(Param.RESPONSE, null);
		tmp.put(Param.QUERY, "What is your current GPA?");
		system.getParameterList().add(new GroupParameter(new ParameterSpec(tmp)));
		tmp = new EnumMap<Param,String>(Param.class);
		tmp.put(Param.NAME, "Experience"); tmp.put(Param.RESPONSE, null);
		tmp.put(Param.QUERY, "Do you have any prior experience on this topic?");
		system.getParameterList().add(new GroupParameter(new ParameterSpec(tmp)));
		
		List<GroupParameter> tmpList;
		// For each student in the system, copy instructor parameter list
		for(Student student: testGroup){
			tmpList = new ArrayList<GroupParameter>();
			for (int i=0; i<system.getParameterList().size(); i++) {
				tmpList.add(new GroupParameter(new ParameterSpec(system.getParameterList().get(i).getSpec().getProperties())));
			}
			student.setParameters(tmpList);
		}

		//Randomly generate student responses to questions
		GroupParameter param;
		for (Student stu: testGroup) { //Generate GPA's
		    param = stu.getParameters().get(0);
			String myGPA = String.valueOf(Math.random()*3+1);
			String test = myGPA.substring(0, 4);
			param.getSpec().addProperty(Param.RESPONSE, test);
		}
		for (Student stu: testGroup) { //Generate Experience
		    param = stu.getParameters().get(1);
		    int num = (Math.random()<0.15)?0:1; //Generate yes at ~15%
		    String test;
			if (num == 0) test = "Yes";
			else test = "No";
			param.getSpec().addProperty(Param.RESPONSE, test);
		}
		

		GeneratorStrategy gs = new ParameterStrat();
		ArrayList<Group> aa = gs.generateGroups();

		//Pretty print to std out.
		System.out.println();
		int grpNum=1;
		for (Group grp: aa) {
			System.out.println("\n--Group "+grpNum); grpNum++; 
			for (Student stu: grp.getStudents()) {
				System.out.println("\t"+stu.getName());
				for (int i=0; i<stu.getParameters().size(); i++) {
					System.out.println("\t  "+stu.getParameters().get(i).toString() + "\n");
				}
			}
		}
	}
}



