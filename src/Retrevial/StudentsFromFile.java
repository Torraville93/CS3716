package Retrevial;
/*
 * Reads a list of student names and numbers and creates an array of Students.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Users.Student;


public class StudentsFromFile implements RetrieveStudents {
	
	//file permanently set for testing purposes.
	String file = "studentList.csv";
	
	ArrayList<Student> studentList;


	/**
	 * Simple method to ask user for the file name
	 */
	public void setFileName(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the file name");
		file = scan.next();
		scan.close();
	}
	

	/**
	 * A method that searches through a .csv file of students, and adds each student to an array
	 * The array of Students is returned
	 */
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



}
