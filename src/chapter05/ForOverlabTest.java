package chapter05;

import java.util.Scanner;

public class ForOverlabTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start = 0, end = 0;
		boolean flag = true;
		
		while(flag) {
			System.out.print("start > ");
			start = scan.nextInt();
			
			System.out.print("end > ");
			end = scan.nextInt();
			
			// 실행여부 체크
			if(start == 0 && end == 0) {
				// while 블록을 빠져 나간 후 종료
				flag = false;
			} else {
				for(int i = 1; i <= 9; i++) {
					for(int j = start; j <= end; j++) {
						System.out.print(j + " X " + i + " = " + (i*j) + "\t");
					}
					System.out.println();
				}	
				System.out.println("프로그램 종료 : start, end 모두 0 입력");
			}
			
		} // while
				System.out.println("프로그램이 종료됩니다.");
				System.exit(0);
		
		// 2단 ~ 5단까지 한번에 출력
//		for(int i = 1; i <= 9; i++) {
//			for(int j = 2; j <= 5; j++) {
//				System.out.print(j + " X " + i + " = " + (i*j) + "\t");
//			}
//			System.out.println();
//		}
		
		// 2단 ~ 5단까지 한번에 출력
//		for(int i = 2; i <= 5; i++) {
//			for(int j = 1; j <= 9; j++) {
//				System.out.print(i + " X " + j + " = " + (i*j) + "\t");
//			}
//			System.out.println();
//		}		
	}

}
