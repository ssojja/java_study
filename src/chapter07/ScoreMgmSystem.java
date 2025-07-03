package chapter07;

import java.util.Scanner;

/*
 * - 학생 3명의 점수를 입력받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 받는다.
 * 
 * */
public class ScoreMgmSystem {
	// Field
	String admin;
	Student student; // Student student = new Student();
	Scanner scan = new Scanner(System.in);
//	Student[] sList = new Student[10];
	
	// Constructor
	public ScoreMgmSystem() {}
	
	// Method 등록(insert), 검색(search), 수정(update), 삭제(remove)
	public void insert() {	
		System.out.println("-- insert --");
		student = new Student();

		System.out.print("학생명 > ");
		student.name = scan.next();
		
		System.out.print("국어 점수 > ");
		student.kor = scan.nextInt();
		
		System.out.print("영어 점수 > ");
		student.eng = scan.nextInt();
		
		System.out.print("수학 점수 > ");
		student.math = scan.nextInt();
		
		System.out.println("=> 등록 완료!!");
	}
	
	public void show() {
		System.out.println("-------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------");
		System.out.print(student.name + "\t");
		System.out.print(student.kor + "\t");
		System.out.print(student.eng + "\t");
		System.out.print(student.math + "\t");
		System.out.print(student.getTot() + "\t");
		System.out.print(student.getAvg() + "\n");
		System.out.println("-------------------------------------------");
		
	}
	
	public void search() {
		System.out.println("search!!");	
	}

	public void update() {
		System.out.println("update!!");		
	}
	
	public void remove() {
		System.out.println("remove!!");	
	}
	
} // class
