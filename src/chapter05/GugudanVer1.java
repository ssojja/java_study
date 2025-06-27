package chapter05;

import java.util.Scanner;

public class GugudanVer1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dan = 0;
		
		while(true) {
			System.out.print("출력할 단 숫자 입력(종료:0) > ");
			dan = scan.nextInt(); 
			
			if(dan != 0) {
				// dan 변수값이 0이 아닌 경우 : 구구단 출력
				System.out.println("\n--- "+ dan + "단 ---");
				for(int i = 1; i <= 9; i++) {
					System.out.println(dan + " X " + i + " = " + (i*dan));
				}
			} else {
				// dan 변수값이 0인 경우 : 프로그램 종료
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}	
		} // while
		
	} // main

} // class
