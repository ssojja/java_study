package chapter07;

public class Animal2 {
	// Field : 전역변수
	String name;	// 캡슐화로 인해 Animal class가 heap에 저장되어 있으므로 전역 변수도 heap에 저장되어 있음!
	int age;
	
	// Constructor : 생성자는 오버로딩이 가능함!
	public Animal2() {	// 기본 생성자는 단독으로 있을때만 자동생성
		// 생성자 호출시 실행되는 내용 => new Animal(); 코드 실행 시 실행됨!
		System.out.println("객체를 생성한다.");
	}

	public Animal2(String name) {	// field의 name만 초기화
		this.name = name; // this의 경우 재귀의 의미를 가짐
	}
	
	public Animal2(String name, int age) {	// field의 name, age 초기화
		this.name = name; // this의 경우 재귀의 의미를 가짐
		this.age = age;
	}
	
	// method
	public void sleep() {
		System.out.println(name + " 잠을 잔다.");
	}

}
