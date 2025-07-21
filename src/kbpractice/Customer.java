package kbpractice;

import java.util.Scanner;


public class Customer {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private Scanner scan;
	private AccountPaperVo accountPaper;
	
	public Customer() {}
	public Customer(String name, String accountNumber, String password, int money) {
		this.name = "[고객 : " + name + "]";
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
		this.scan = new Scanner(System.in);
		System.out.println(this.name + " 입장!");
	}
	
	public AccountPaperVo getAccountPaper() {
		System.out.println(this.name +  " 은행직원에게 출금용지 전달 완.");
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		this.accountPaper.setName(this.name);
		this.accountPaper.setAccountNumber(this.accountNumber);
		this.accountPaper.setPassword(this.password);
		this.accountPaper.setMoney(this.money);
		System.out.println(this.name + " 출금정보 작성 완.");
	}
	
	public AccountPaperVo answer(int checkResult) {
		switch (checkResult) {
			case BankMan.ACCOUNT_NAME:
				System.out.print(this.name + " 고객명 > ");
				accountPaper.setName(scan.next());
				break;
			case BankMan.ACCOUNT_NUMBER: 
				System.out.print(this.name + " 계좌번호 > ");
				accountPaper.setAccountNumber(scan.next());
				break;
			case BankMan.ACCOUNT_PASSWORD: 
				System.out.print(this.name + " 패스워드 > ");
				accountPaper.setPassword(scan.next());
				break;
			case BankMan.ACCOUNT_MONEY : 
				System.out.print(this.name + " 금액 > ");
				accountPaper.setMoney(scan.nextInt());
				break;
		}
		return accountPaper;
	}

}
