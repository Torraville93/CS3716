package retrieval;

import java.io.*;
import java.util.ArrayList;

import users.Student;

/**
 * Reads a list of student names and numbers from CSV file 
 * and creates an array of Students.
 */
public class StudentsFromFile implements RetrieveStudents {
	
	private File file;

	public StudentsFromFile() { file = new File("studentList.csv"); }
	public StudentsFromFile(File aFile){
		file = aFile;
	}

	/**
	 * Searches through CSV file of students, and adds each student to an 
	 * array of Student objects.
	 * @return studentList - ArrayList of Students
	 */
	public ArrayList<Student> getStudents() throws IOException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] student = line.split(",");
				String s = student[0];
				Number n = Integer.parseInt(student[1]);
				Student stu = new Student(s, n);
				studentList.add(stu);
				
			}
			br.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return studentList;
	}
	
	
	
	
	
	
	/*
	//file permanently set for testing purposes.
	String file = "studentList.csv";
	
	ArrayList<Student> studentList;


	 // Simple method to ask user for the file name
	public void setFileName(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the file name");
		file = scan.next();
		scan.close();
	}
	

	 // A method that searches through a .csv file of students, and adds each student to an array
	 // The array of Students is returned
	public ArrayList<Student> getStudents() throws IOException {
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] student = line.split(",");
				String s = student[0];
				Number n = Integer.parseInt(student[1]);
				Student stu = new Student(s, n);
				studentList.add(stu);
				
			}
			br.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return studentList;
	}

*/

}
