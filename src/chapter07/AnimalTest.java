package chapter07;

public class AnimalTest {

	public static void main(String[] args) {	// main 함수 독립적으로 사용하기~
		System.out.println("AnimalTest 클래스 실행!\n");
		
		// 사자, 호랑이 객체 생성
		Animal lion = new Animal();
		Animal tiger = new Animal();
		Animal giraffe = new Animal();
		Animal elephant = new Animal();
		
		lion.name = "심바";
		lion.age = 5;

		tiger.name = "호돌이";
		tiger.age = 3;
		
		System.out.println("lion.name = " + lion.name);
		System.out.println("lion.age = " + lion.age);
		
		System.out.println("tiger.name = " + tiger.name);
		System.out.println("tiger.age = " + tiger.age);
		
		lion.sleep();
		tiger.sleep();
		
		giraffe.name = "기린이";
		giraffe.age = 6;

		elephant.name = "코순이";
		elephant.age = 5;

		System.out.println("giraffe.name = " + giraffe.name);
		System.out.println("elephant.name = " + elephant.name);

	}

}
