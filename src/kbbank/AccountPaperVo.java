package kbbank;

/*
 * 출금용지 클래스 : 고객이 작성하는 출금 정보 데이터 저장 객체
 * */

/**
 * 은행에 비치되어 있는 입출금 용지!
 * */
public class AccountPaperVo {	
	
	// Field
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private static AccountPaperVo accountPaper = new AccountPaperVo();
	
	// Constructor
	private AccountPaperVo () {}
	
	public static AccountPaperVo getInstance() {
		return accountPaper;
	}
	
	// Method
	// getter/setter
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
