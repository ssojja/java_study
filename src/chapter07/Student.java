package chapter07;

public class Student {
	// Field
	String name;
	int kor, eng, math;
	
	// Constructor
	public Student() {}
	
	// Method
	public int getTot() {
		return kor + eng + math;
	}
	
	public int getAvg() {
		return (kor + eng + math)/3;
	}
}
