/*
 * A simple class to represent a student.
 */
package Users;

public class Student {
	private String name;
	private Number number;
	
	public Student() {}
	
	public Student(String s, Number n){
		name = s;
		number = n;
	}
	
    public void setName(String name){
    	this.name = name;
    }

    public String getName(){
    	return name;
    }

    public void setNumber(Number number){
    	this.number = number;
    }

    public Number getNumber(){
    	return number;
    }

}
