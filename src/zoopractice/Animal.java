package zoopractice;

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
		System.out.println(age + "살 " + name + "이(가) 잠을 잔다..zZ");
	};
	
	@Override
	public void eat() {
		System.out.println(age + "살 " + name + "이(가) 밥을 먹는다.");
	};
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	

}
