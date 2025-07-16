package chapter11;

import java.util.Scanner;

public class ExceptionTest1 {

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
			System.out.println(numbers[5]);
		} catch (ArithmeticException ae) {
			System.out.println("분모는 0 값을 가질 수 없습니다.");
		} catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("배열 크기 확인바랍니다.");
			System.out.println(aie);
		}

	}

}
