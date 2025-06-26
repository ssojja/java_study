package chapter04;

/**
 *	증감 연산자 : ++, -- 
 */

public class OpIncrementTest {

	public static void main(String[] args) {
		int number = 10;
		
		System.out.println(++number);	// 11
		System.out.println(number++);	// 11을 먼저 출력하고 메모리에 12로 저장
		System.out.println(number);		// 12
		System.out.println();
		System.out.println(--number); 	// 11
		System.out.println(number--); 	// 11을 먼저 출력하고 메모리에 10으로 저장
		System.out.println(number); 	// 10

	}

}
