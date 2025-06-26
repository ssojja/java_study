package chapter05;

import java.util.Scanner;

public class IfOverlabTest2 {
	
	public static void main(String[] args) {
		boolean math_pass, eng_pass = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("수학 점수 > ");
		math_pass = scan.nextInt() >= 60 ? true : false; 
		
		System.out.print("영어 점수 > ");
		eng_pass = scan.nextInt() >= 60 ? true : false;
		
		// 1. 중첩 if문
		if(math_pass) {if(eng_pass) System.out.println("합격");}
		else System.out.println("불합격");
		
		// 2. 논리연산자 &&를 이용하여 if ~ else
		if((math_pass) && (eng_pass)) System.out.println("합격"); 
		else System.out.println("불합격1");
		
	}

}
