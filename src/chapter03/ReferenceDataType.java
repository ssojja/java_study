package chapter03;

import java.lang.String;
import java.util.Scanner;

public class ReferenceDataType {

	public static void main(String[] args) {
		// 참조 데이터 타입 정의 : 배열, 클래스, 인터페이스 ..
		String name = new String("홍길동"); // new + 생성자
		
		Scanner scan = new Scanner(System.in);
		
		// ** 중요 **
		// String 클래스는 기본형으로도 사용이 가능함!
		String name2 = "홍길동";
		
		System.out.println(name);
		System.out.println(name2);
		System.out.println(name == name2);	// stack 부분에 올라가 있는 값이 다르기 때문에 false
		System.out.println(scan);

	}

}
