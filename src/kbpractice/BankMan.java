package kbpractice;

public class BankMan {
	String name; // 은행원 이름
	int checkResult;
	private BankSystem kbsystem;
	private AccountPaperVO accountPaper;
	private AccountVo[] accountList;	// 고객 정보 리스트
	
	public static final int ACCOUNT_NAME = 1;
	public static final int ACCOUNT_NUMBER = 2;
	public static final int ACCOUNT_PASSWORD = 3;
	public static final int ACCOUNT_MONEY = 4;
	
	public BankMan() {}
	public BankMan(String name, BankSystem kbsystem) {
		this.name = "[은행직원 : " + name + "]"; // 은행원 이름
		this.kbsystem = kbsystem;
		System.out.println(this.name + " 업무 시작!");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BankSystem getKbsystem() {
		return kbsystem;
	}
	public void setKbsystem(BankSystem kbsystem) {
		this.kbsystem = kbsystem;
	}
	
	public AccountPaperVO getAccountPaper() {
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVO accountPaper) {	
		this.accountPaper = accountPaper;
		System.out.println(this.name + " 고객으로부터 출금용지 수령 완.");
	}
	
	public void validateChcek() {
		System.out.println(this.name + " 고객 정보에 대한 유효성 검증을 진행한다.");
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		} else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else {
			// 모두 입력되어 있음!
			System.out.println("모두 입력 완.");
		}
	}
	
	public boolean validateChcek(AccountPaperVO updateAccountPaper) {
		System.out.println(this.name + " 고객 정보에 대한 유효성 검증을 재진행한다.");
		this.accountPaper = updateAccountPaper;
		boolean result = false;
		
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		} else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else{
			// 모두 입력되어 있음!
			System.out.println("모두 입력 완.");
			result = true;
		}
		return result;
	} 
	
	
	public void ask(int status) {
		switch (status) {
			case ACCOUNT_NAME: 
				System.out.println(this.name + " 이름을 입력해주세요.");
				checkResult = ACCOUNT_NAME;
				break;
			case ACCOUNT_NUMBER: 
				System.out.println(this.name + " 계좌를 입력해주세요.");
				checkResult = ACCOUNT_NUMBER;
				break;
			case ACCOUNT_PASSWORD: 
				System.out.println(this.name + " 패스워드를 입력해주세요.");
				checkResult = ACCOUNT_PASSWORD;
				break;
			case ACCOUNT_MONEY: 
				System.out.println(this.name + " 금액을 입력해주세요.");
				checkResult = ACCOUNT_MONEY;
				break;
			default:
				break;
		}
	}
	
	/**
	 * 출금 요청 처리
	 * */
	public void processWithdrawal() {
		System.out.println(this.name + " 출금 요청이 진행중입니다. 잠시만 기다려주십셔 ~ ");
		// 고객계정 검색 - BankSystem > 잔고-금액
		int accountIdx = kbsystem.searchAccount(accountPaper);
		if(accountIdx != -1) {
			AccountVo account = kbsystem.accountList[accountIdx];
			if(account.getBalance() >= accountPaper.getMoney()) {
				int money = account.getBalance() - accountPaper.getMoney();
				account.setBalance(money); 	 // AccountVo class 남은 금액 업데이트
				kbsystem.accountList[accountIdx] = account;// 남은 금액 업데이트
				
				processCompleted();
			} else {
				System.out.println(this.name + " 잔액이 부족합니다.");
			}
			
		} else {
			System.out.println(this.name + "계좌 정보가 없습니다. 확인 후 다시 진행해주세요.");
		}
		
	
	}
	
	public void processCompleted() {
		System.out.println(this.name + " 출금처리가 완료되었습니다.");
		System.out.println(this.name + " 출금액은 " + accountPaper.getMoney() +"원 입니다.");
	}
	
	
}
