package zoo;

/**
 * 동물의 공통적인 속성 정의
 * name, age
 * */

public class Animal implements AnimalInterface{
	String name;
	int age;
	
	public Animal() {}
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void sleep() {
		System.out.println(name + " 이(가) 잠을 잔다..zZ");
	};
	
	@Override
	public void eat() {
		System.out.println(name + " 이(가) 밥을 먹는다 냠냠");
	};
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
