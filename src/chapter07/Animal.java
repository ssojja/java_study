package chapter07;

public class Animal {
	// Field : 전역변수
	String name;	// 캡슐화로 인해 Animal class가 heap에 저장되어 있으므로 전역 변수도 heap에 저장되어 있음!
	int age;
	
	// Constructor
	public Animal() {	// 기본 생성자
		// 생성자 호출시 실행되는 내용 => new Animal(); 코드 실행 시 실행됨!
		System.out.println("객체를 생성한다.");
	}
	
	// method
	public void sleep() {
		String date = "20250703"; 
		System.out.println(date + " 잠을 잔다.");
	}

}
