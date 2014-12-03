package generator;

import groupSystem.GroupSystem;
import groups.Group;
import groups.GroupManager;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import parameters.Param;
import users.Student;

/**
 * Group generating strategy that takes student responses into account.
 * Each new parameter added by the instructor would ideally need a new way 
 * of grouping the students based on their responses. However, as of now, just 
 * student GPA's are taken into consideration when generating groups.
 */
public class ParameterStrat implements GeneratorStrategy {
	
	/**
	 * Generates groups of students of given size.
	 * @return - list of student Group's
	 */
	@Override
	public ArrayList<Group> generateGroups() {
		int numStudents = GroupSystem.students.size();
		int grpSize = GroupManager.groupSize;
		sortByGPA(GroupSystem.students);
		return createGroups(numStudents, grpSize);
	}	
	
	/**
	 * Sorts the collection of Students in ascending order by GPA.
	 * @param list - List of Student objects 
	 * @return - sorted list of Student's
	 */
    private List<Student> sortByGPA(List<Student> list) {
        for (int i = 1; i < list.size(); i++) {
            Student next = list.get(i);
            // find the insertion location while moving all larger element up
            int j = i;
            //Only one parameter added.
            if (list.get(j-1).getParameters().get(0).getSpec().getProperty(Param.NAME).equalsIgnoreCase("GPA")) {
            	while (j > 0 && Double.parseDouble(list.get(j-1).getParameters().get(0).toString().split(",")[2]) > Double.parseDouble(next.getParameters().get(0).toString().split(",")[2])) {
            		list.set(j, list.get(j-1));
            		j--;
            	}
            	// insert the element
            	list.set(j, next);
            //Else, two parameters, and first one wasn't GPA	
            } else if (list.get(j-1).getParameters().size() > 1){
            	while (j > 0 && Double.parseDouble(list.get(j-1).getParameters().get(1).toString().split(",")[2]) > Double.parseDouble(next.getParameters().get(1).toString().split(",")[2])) {
            		list.set(j, list.get(j-1));
            		j--;
            	}
            	// insert the element
            	list.set(j, next);
            }
        }
        return list;
    }
    
    //Not implemented as of yet.
    private List<Student> sortByEXP(List<Student> list) { return null; }
    
    /**
     * Method to create groups of Students based somewhat fairly on GPA. 
     * Algorithm is a bit crude, but couldn't get anything more 
     * sophisticated to work correctly in the time-frame.
     * @param numStu - number of Student's
     * @param grpSize - student group size
     * @return - List of Group's of Student's based on GPA
     */
	private ArrayList<Group> createGroups(int numStu, int grpSize) {
		ArrayList<Group> tmpGrps = new ArrayList<Group>();
		ArrayDeque<Student> tmpDQ = new ArrayDeque<Student>();
		for (Student stu: GroupSystem.students) { tmpDQ.add(stu); }
		if (numStu % grpSize == 0) { //Students divisible by Group Size
			if (grpSize % 2 == 0) { //Even Group Size
				for (int i=0; i < numStu/grpSize; i++) {
					tmpGrps.add(makeEvenGroup(tmpDQ, grpSize));
				}
			} else { //Odd Group Size
				for (int i=0; i < numStu/grpSize; i++) {
					tmpGrps.add(makeOddGroup(tmpDQ, grpSize));
				}
			}
		} else { //Students not divisible by Group Size
			int rem = numStu%grpSize; //Remaining number of Students
			if (grpSize % 2 == 0) { //Even Group Size
				for (int i=0; i < (numStu-rem)/grpSize; i++) {
					tmpGrps.add(makeEvenGroup(tmpDQ, grpSize));
				}
			} else { //Odd Group Size
				for (int i=0; i < (numStu-rem)/grpSize; i++) {
					tmpGrps.add(makeOddGroup(tmpDQ, grpSize));
				}
			}
			//Remaining students put in extra group
			List<Student> tmpGrp = new ArrayList<Student>();
			while (!tmpDQ.isEmpty()) { tmpGrp.add(tmpDQ.remove()); }
			tmpGrps.add(new Group(tmpGrp));
		}
		return tmpGrps;
	}
	
	/**
	 * Method to handle creating groups of even size from sorted list.
	 * Groups have equal strong and weak students.
	 * @param dq - ArrayDeque of Student's (for easy removal)
	 * @param grpSize - student group size
	 * @return - a Group object with odd size
	 */
	private Group makeEvenGroup(ArrayDeque<Student> dq , int grpSize) {
		List<Student> grp = new ArrayList<Student>();
		for (int j=0; j<grpSize/2; j++) { //Split group size in two
			grp.add(dq.removeLast()); //Add current Student with highest GPA
			grp.add(dq.removeFirst()); //Add current Student with lowest GPA
		}
		return new Group(grp);
	}
	
	/**
	 * Method to handle creating groups of odd size from sorted list.
	 * Tries to group few strong students with many weak students.
	 * @param dq - ArrayDeque of Student's (for easy removal)
	 * @param grpSize - student group size
	 * @return - a Group object with odd size
	 */
	private Group makeOddGroup(ArrayDeque<Student> dq , int grpSize) {
		List<Student> grp = new ArrayList<Student>();
		for (int k=0; k<grpSize/2; k++) { //Split group size (rounded down)
			grp.add(dq.removeLast()); //Add current Student with highest GPA
		}
		for (int j=0; j<grpSize/2+1; j++) { //Remaining group size
			grp.add(dq.removeFirst()); //Add current Student with lowest GPA
		}
		return new Group(grp);
	}
}
