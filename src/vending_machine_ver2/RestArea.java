package vending_machine_ver2;

public class RestArea {
	// Field
	String name; // 휴게소 이름
	User user = new User();
	VendingMachine machine;
	
	// Constructor
	public RestArea() {
		this("만남의 광장");
	}
	
	public RestArea(String name) {
		this.name = name;	// 멤버변수 초기화 작업(전체적인 확장)
		welcome();
		System.out.print("User 이름을 입력하세요 > ");
		user = new User(user.scan.next());
		machine = new VendingMachine(user);
	}
	
	// Method
	public void welcome() {
		System.out.println("-------------------------------------------");
		System.out.println("  " + name + " ☕🍵🥤 휴게소에 오신 것을 환영합니다리 ~ ! ");
		System.out.println("-------------------------------------------");
	}
}
