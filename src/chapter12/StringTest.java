package chapter12;

public class StringTest {
	
	public static void main(String[] args) {
		System.out.println("-- String 비교 결과 값 --");
		String name1 = "홍길동";	// 기본형으로 stack에 생성됨
		String name2 = new String("홍길동"); // heap영역에 생성됨
		
		if(name1 == name2) System.out.println("true"); 
		else System.out.println("false");
		
		if(name1.equals(name2)) System.out.println("true"); 
		else System.out.println("false");
		System.out.println("---------------------");
		
		String num = String.valueOf(123);
		name2 = " welcome To Java!";
		
		System.out.println(name2);
		System.out.println(name2.trim());	// 문자열 제일 앞/뒤 공백 제거하는 함수임
		
		String phone = "010-1234-5678";
		String subject = "java,css,html,mysql";
		String[] phones = phone.split("-");
		String[] subjects = subject.split(",");
		
//		for(int i = 0; i < subjects.length; i++) {
//			System.out.println(subjects[i]);
//		}
		
		for(String str : subjects) {
			System.out.println(str);
		}
		
		// phones 배열에 존재하는 값들을 | 기준으로 합치는 함수
		String jphone = String.join("|", phones);
		System.out.println("jphone : " + jphone);
		
		System.out.println("contains : " + subject.contains("html"));
		
		System.out.println(phones[0]);
		System.out.println(phones[1]);
		System.out.println(phones[2]);
		System.out.println(name2.toUpperCase());
		System.out.println(name2.toLowerCase());
		System.out.println(name2.length());
		System.out.println(name2.substring(7));
		System.out.println(name2.substring(7, 10));
		System.out.println("num + 10 : " + num + 10);
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
	}
}
