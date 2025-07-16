package kbpractice;

public class AccountPaperVo {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	// 서로서로 참조를 위해 싱글톤으로 생성
	private static AccountPaperVo accountPaper = new AccountPaperVo();
	
	private AccountPaperVo() {}
	
	public static AccountPaperVo getInstance() {
		return accountPaper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	

}
