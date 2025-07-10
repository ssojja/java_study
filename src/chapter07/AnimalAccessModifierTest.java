package chapter07;

import java.util.Calendar;

import commons.Animal;

public class AnimalAccessModifierTest {

	public static void main(String[] args) {
		// Calendar 객체 생성
//		Calendar cd = new Calendar();	// 상속 관계가 없으므로 객체 생성 불가
		Calendar cd = Calendar.getInstance();	// 생성된 객체의 인스턴스 주소를 가져옴, Singleton(싱글톤) 패턴 ~
		System.out.println(cd.getTime());
		
		// static 변수, static 메소드 호출!
		AnimalAccessModifier.sName = "static"; 
		AnimalAccessModifier.sAge = 10; 
		AnimalAccessModifier.getInfo3();

		AnimalAccessModifier aam = new AnimalAccessModifier("호순이", 10);
		
		aam.sName = "static2";
		aam.sAge = 12;
		aam.getInfo3();
		
		// final 변수 테스트
//		aam.fname = "홍길순";		// final 키워드 변수는 외부에서 값을 변경할 수 없다.
//		aam.fage = 15;
		
		// 상수 호출
		int start = AnimalAccessModifier.START;
		int con = AnimalAccessModifier.CONTINUE;
		int end = AnimalAccessModifier.END;

		System.out.println("start = " + start + ", con = " + con + ", end = " + end);

		
		
		
		Animal comDog = new Animal();
		
		comDog.setName("호호순이");
		comDog.setAge(15);

//		comDog.name = "예삐";		// 패키지가 다르므로 접근 불가
//		comDog.age = 3;			// 패키지가 다르므로 접근 불가
		
//		aam.name = "심바";
//		aam.age = 5;
		
//		aam.pname = "호순이";	// 클래스가 다르므로 접근 불가 : private
//		aam.page = 10;		// 클래스가 다르므로 접근 불가 : private
		
//		System.out.println("name = " + aam.name);
//		System.out.println("age = " + aam.age);

		System.out.println("pName = " + aam.getPname());
		System.out.println("pAge = " + aam.getPage());
		
		
		System.out.println("name = " + comDog.getName());
		System.out.println("age = " + comDog.getAge());
		
		

	}

}
