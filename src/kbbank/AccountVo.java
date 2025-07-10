package kbbank;

/*
 * 고객계좌 클래스 : 실제 은행에 저장된 고객 정보 보관
 * */
/**
 * 은행의 고객 정보를 담는 클래스이며, 은행직원을 통해 생성된다.
 * */
public class AccountVo {	
	// Field
	private String name;		// final 키워드 적용 => 외부에서 값을 변경할 수 없음!
	private String accountNumber;
	private String password;
	private int balance;
	
	// Constructor
	public AccountVo () {}
	public AccountVo (String name, String accountNumber, String password, int balance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.password = password;
		this.balance = balance;
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

	public void setAccountNumber(String accoountNumber) {
		this.accountNumber = accoountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	

}
