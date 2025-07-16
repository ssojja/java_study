package chapter12;

public class StringTest {
	
	public static void main(String[] args) {
		String name1 = "홍길동";	// 기본형
		String name2 = new String("홍길동");
		String num = String.valueOf(123);
		name2 = "welcome To Java!";
		
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
		
		if(name1 == name2) System.out.println("true"); 
		else System.out.println("false");

		if(name1.equals(name2)) System.out.println("true"); 
		else System.out.println("false");
		
	}

}
