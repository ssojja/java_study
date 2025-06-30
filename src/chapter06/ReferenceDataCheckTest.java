package chapter06;

import java.util.Scanner;

/*
 * 기본형 데이터와 참조형 데이터의 저장구조를 정리
 * */
public class ReferenceDataCheckTest {

	public static void main(String[] args) {
		// 1. 기본형
		int a = 10;
		int b = 10;
		String str1 = "홍길동";
		String str2 = "홍길동";	// constant pool의 경우 text의 내용이 같으면 hashcode를 동일하게 부여
		
//		System.out.println(System.identityHashCode(str1));
		
		// call by value 형태로 값을 비교
		System.out.println("a == b : " + (a == b));
		System.out.println("str1 == str2 : " + (str1 == str2));
		
		// 2. 참조형
		String strObj1 = new String("홍길동");
		String strObj2 = new String("홍길동");
		
		System.out.println("strObj1 hashcode 정보 : " + System.identityHashCode(strObj1));
		System.out.println("strObj2 hashcode 정보 : " + System.identityHashCode(strObj2));
		System.out.println("strObj1 == strObj2 : " + (strObj1 == strObj2));				// stack 주소비교
		System.out.println("strObj1.equals(strObj2) : " + (strObj1.equals(strObj2)));	// 값 비교
		
		// String의 경우만!
		strObj1 = str1;
		System.out.println(strObj1);
		System.out.println(System.identityHashCode(strObj1));
		
		// Scanner 객체를 이용하여 문자열 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 입력 > ");
		String sdata = scan.next();
		
		System.out.println(sdata);
		System.out.println("sdata == str1 : " + (sdata == str1));	// stack 주소비교
		System.out.println("sdata.equals(str1) : " + (sdata.equals(str1)));
		
	}

}
