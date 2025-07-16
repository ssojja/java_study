package chapter11;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("num1 > ");
		int num1 = scan.nextInt();
		System.out.print("num2 > ");
		int num2 = scan.nextInt();
		
		try {
			int result = num1/num2;		// 오류 & 예외 아니고 예외!!!!!!!
			System.out.println("result : " + result);
			
			int[] numbers = {1, 2, 3};
//			System.out.println(numbers[5]);
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			scan.close();	// 생략가능
			System.out.println("-- 프로그램 종료 --"); // 예외가 발생해도 발생하지 않아도 실행되는 부분
		}

	}

}
