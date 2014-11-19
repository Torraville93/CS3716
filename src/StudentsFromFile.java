import java.io.*;
import java.util.ArrayList;

import Users.Student;


public class StudentsFromFile implements RetrieveStudents {

	String file = "studentList.csv";
	ArrayList<Student> studentList;

	//If time, create getFileName method

	//Returns an array of Students	
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
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return studentList;
	}



}
