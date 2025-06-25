package chapter03;

//import java.lang.String;

public class Variable {

	public static void main(String[] args) {
		// 기본 자료형 변수 정의
		int age = 10;
		double aged = 10.0;
		boolean flag = true; // true(1), false(0)
		char name = '홍';

		// 참조 자료형 변수 정의
		String sname = new String("홍길동"); 

		// ** String 클래스는 기본형(stack)과 참조형(heap) 모두 사용 가능
		String sname2 = "홍길동 입니다"; 
		
		// 출력
		System.out.println(" age 확인 : " + age); // stack에 올라가 있는 값이 출력됨
		System.out.println("aged 확인 : " + aged); 
		System.out.println("flag 확인 : " + flag); 
		System.out.println("name 확인 : " + name); 
		System.out.println("char name 확인 : " + name);
		System.out.println();
		
		// 출력2
		System.out.println("sname 확인 : " + sname);
		System.out.println("sname2 확인 : " + sname2);

	}

}
