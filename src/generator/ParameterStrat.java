package generator;

import groupSystem.GroupSystem;
import groups.Group;
import groups.GroupManager;

import java.util.ArrayList;
import java.util.List;

import parameters.GroupParameter;
import users.Student;

public class ParameterStrat implements GeneratorStrategy {

	int numStudents;
	int grpSize;
	ArrayList<Group> tmp;
	
	@Override
	public ArrayList<Group> generateGroups() {
		ArrayList<Group> tmp = new ArrayList<Group>();
		int numStudents = GroupSystem.students.size();
		int grpSize = GroupManager.groupSize;
		sortByGPA(GroupSystem.students);
		
		for (int i = 0; i < numStudents; i += grpSize) {
			int end = Math.min(i + grpSize, numStudents);
			List<Student> tmpGrp = GroupSystem.students.subList(i, end);
			tmp.add(new Group(tmpGrp));
		}
		return tmp;
	}	

	//Unused. Here JIC
	public ArrayList<Group> groupByGPA(List<Student> grps) {
		for (int i = 0; i < grps.size(); i += grpSize) {
			int end = Math.min(i + grpSize, grps.size());
			List<Student> tmpGrp = GroupSystem.students.subList(i, end);
			tmp.add(new Group(tmpGrp));
		}
		return tmp;
	}
	
	//Unused. Here JIC
	public List<Group> byExperience(List<Group> grps) {
		return null;
	}
	
	//Unused. Here JIC
	public double getMaxGPA(List<Student> stus) {
		double max=0; int count=0;
		for (int i = 0; i < stus.size()-1; i ++) {
			if (Double.parseDouble(stus.get(i).getParameters().get(count).toString().split(",")[2]) >
			Double.parseDouble(stus.get(i+1).getParameters().get(count).toString().split(",")[2])) {
				max = Double.parseDouble(stus.get(i).getParameters().get(count).toString().split(",")[2]);
			} else
				max = Double.parseDouble(stus.get(i+1).getParameters().get(count).toString().split(",")[2]);
		}
		return max;
	}
	
	//Unused. Here JIC
	public double getMinGPA(List<Student> stus) {
		double min=0; int count=0;
		for (int i = 0; i < stus.size()-1; i ++) {
			if (Double.parseDouble(stus.get(i).getParameters().get(count).toString().split(",")[2]) <
			Double.parseDouble(stus.get(i+1).getParameters().get(count).toString().split(",")[2])) {
				min = Double.parseDouble(stus.get(i).getParameters().get(count).toString().split(",")[2]);
			} else
				min = Double.parseDouble(stus.get(i+1).getParameters().get(count).toString().split(",")[2]);
		}
		return min;
	}
	
	public List<Student> sortByGPA(List<Student> list) {
        for (int i = 1; i < list.size(); i++) {
            Student next = list.get(i);
            // find the insertion location while moving all larger element up
            int j = i;
            while (j > 0 && Double.parseDouble(list.get(j-1).getParameters().get(0).toString().split(",")[2]) > Double.parseDouble(next.getParameters().get(0).toString().split(",")[2])) {
            	list.set(j, list.get(j-1));
            	j--;
            }
            // insert the element
            list.set(j, next);
        }
        return list;
    }
}
