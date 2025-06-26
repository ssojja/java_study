package chapter05;

import java.util.Scanner;

public class IfOverlabTest {
	
	public static void main(String[] args) {
		int math, eng = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("수학 점수 > ");
		math = scan.nextInt();
		
		System.out.print("영어 점수 > ");
		eng = scan.nextInt();
		
		// 1. 중첩 if문
		if(math >= 60) {
			if(eng >= 60) {	
				System.out.println("합격");
			}
		} else{
			System.out.println("불합격");
		}
		
		// 2. 논리연산자 &&를 이용하여 if ~ else
		if((math >= 60) && (eng >= 60)) {
			System.out.println("합격");
		} else{
			System.out.println("불합격");
		}
		
	}

}
