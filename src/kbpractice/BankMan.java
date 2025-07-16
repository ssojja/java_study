package kbpractice;

public class BankMan {
	String name; // 은행원 이름
	private BankSystem kbsystem;	// 직접 접근 가능하게 하면 안됨 ,,
	

	public BankMan(String name, BankSystem kbsystem) {
		this.name = "[은행직원 : " + name + "]"; // 은행원 이름
		this.kbsystem = kbsystem;
		System.out.println(this.name + " 은행업무 시작 !");
		
	}

	public BankSystem getKbsystem() {
		return kbsystem;
	}
	
	public void setKbsystem(BankSystem kbsystem) {
		this.kbsystem = kbsystem;
	}

}
