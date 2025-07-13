package kbpractice;

import java.util.Scanner;

public class Customer {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVO accountPaper;
	private Scanner scan;
	
	public Customer() {}
	public Customer(String name, String accountNumber, String password, int money) {
		this.name = "[고객 : " + name + "]";
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
		this.scan = new Scanner(System.in);
		System.out.println(this.name + " 입장!");
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
	
	public AccountPaperVO getAccountPaper() {
		System.out.println(this.name + " 은행직원에게 출금용지 전달 완.");
		return accountPaper;
	}
	
	public void setAccountPaper(AccountPaperVO accountPaper) {
		this.accountPaper = accountPaper;
		this.accountPaper.setName(this.name);
		this.accountPaper.setAccountNumber(this.accountNumber);
		this.accountPaper.setPassword(this.password);
		this.accountPaper.setMoney(this.money);
		
		System.out.println(this.name + " 출금정보 작성 완.");
	}
	
	/**
	 * 은행직원이 유효성 검증 후 빠진 고객 정보를 물어보면, 답변(입력)한다.
	 * 
	 */
	public AccountPaperVO answer(int checkResult) {
		switch (checkResult) {
			case BankMan.ACCOUNT_NAME: 
				System.out.print(this.name + " 고객명 입력 > ");
				accountPaper.setName(scan.next());
				break;
			case BankMan.ACCOUNT_NUMBER: 
				System.out.print(this.name + " 계좌번호 입력 > ");
				accountPaper.setAccountNumber(scan.next());
				break;
			case BankMan.ACCOUNT_PASSWORD: 
				System.out.print(this.name + " 패스워드 입력 > ");
				accountPaper.setPassword(scan.next());
				break;
			case BankMan.ACCOUNT_MONEY: 
				System.out.print(this.name + " 금액 입력 > ");
				accountPaper.setMoney(scan.nextInt());
				break;
			default:
				break;
		}
		
		return accountPaper;
	}
	
	
	
}
