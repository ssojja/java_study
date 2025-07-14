package chapter08;

public class InheritanceTest {

	public static void main(String[] args) {
//		Client c1 = new Client();	// abstract(추상) 클래스는 객체 생성이 불가능
		Person lee = new Person();
		Person kim = new Person("김유신", "종로구", "010-9876-9876", 12);
		Animal dog = new Animal("명수", 5, lee);
		Animal cat = new Animal("야옹이", 6, kim);

//		c1.printInfo();		// client 호출
		lee.printInfo();		// person 호출
		kim.printInfo();		// person 호출
		dog.printInfo();	// client 호출
		cat.printInfo();	// client 호출
		
		
		lee.register();
		dog.register();
		
		dog.sound();
		cat.sound();

	}

}
