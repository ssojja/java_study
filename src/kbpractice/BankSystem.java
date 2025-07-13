package kbpractice;

public class BankSystem {
	String name; 	// 은행 이름
	AccountVo[] accountList;	// 담당 고객 리스트
	
	
	public BankSystem(String name) {
		this.name = name;
		accountList = createAccountList();
	}
	
	/**
	 * 은행 직원이 담당하는 고객 리스트 생성
	 * */
	public AccountVo[] createAccountList() {
		String[] names = {"홍길동", "이순신", "김유신"};
		String[] numbers = {"kb-1234", "kb-9876", "kb-3456"};
		String[] passwords = {"1234", "9876", "3456"};
		int[] balances = {500, 1000, 700};
		
		// 담당 고객 주소 정보 담기 위한 리스트 생성
		AccountVo[] list = new AccountVo[names.length];
		for(int i = 0; i < names.length; i++) {
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccountNumber(numbers[i]);
			account.setPassword(passwords[i]);
			account.setBalance(balances[i]);
			list[i] = account;
			
		}
		return list;
	}
	
	/**
	 * 은행직원이 관리하는 고객 리스트 출력
	 * */
	public void showAccountList() {
		System.out.println("=====================================");
		System.out.println("\t" + name +" 고객 리스트 (" + accountList.length + ")명");
		System.out.println("=====================================");
		for(int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i];
			System.out.print((i+1) + "\t");
			System.out.print(account.getName() + "\t");
			System.out.print(account.getAccountNumber() + "\t");
			System.out.print(account.getPassword() + "\t");
			System.out.print(account.getBalance() + "\n");
		}
		System.out.println("=====================================");
	}
	
	/**
	 * 출금 고객 정보 검색
	 * */
	public int searchAccount(AccountPaperVO accountPaper) {
		int resultIdx = -1;
		for(int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i]; // 고객정보
			if(account.getAccountNumber().equals(accountPaper.getAccountNumber())
					&& account.getPassword().equals(accountPaper.getPassword())) {
				resultIdx = i;
				break;
			}
		}
		return resultIdx;
	}
	
	/**
	 * 잔액 조회
	 * */
	public void confirmBalance(AccountPaperVO accountPaper) {
		int resultIdx = -1;
		for(int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i]; // 고객정보
			if(account.getAccountNumber().equals(accountPaper.getAccountNumber())
					&& account.getPassword().equals(accountPaper.getPassword())) {
				resultIdx = i;
				break;
			}
		}
		
		if(resultIdx != -1) {
			System.out.println("=====================================");
//			AccountVo account = accountList[resultIdx];
//			System.out.print(account.getName() + "\t");
//			System.out.print(account.getAccountNumber() + "\t");
//			System.out.print(account.getPassword() + "\t");
//			System.out.print(account.getBalance() + "\n");
			System.out.print(accountList[resultIdx].getName() + "\t");
			System.out.print(accountList[resultIdx].getAccountNumber() + "\t");
			System.out.print(accountList[resultIdx].getPassword() + "\t");
			System.out.print(accountList[resultIdx].getBalance() + "\n");
			System.out.println("=====================================");
			System.out.println("[BankSystem] 이용해주셔서 감사합니다.");
		} else {
			System.out.println("[BankSystem] 일치하는 고객정보가 없습니다.");
		}
		
	}
}
