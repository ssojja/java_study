package kbpractice;


public class BankSystem {
	String name; // 은행 이름
	AccountVo[] accountList;
	
	public BankSystem(String name) {
		this.name = name;
		// 은행시스템 생성되면서 고객명단 생성하기
		accountList = createAccountList();
	}
	
	public AccountVo[] createAccountList() {
		String[] names = {"홍길동", "이순신", "김유신"};
		String[] numbers = {"kb-1234", "kb-9999", "kb-5678"};
		String[] passwords = {"1234", "0000", "5566"};
		int[] moneys = {100, 5000, 150};
		
		AccountVo[] list = new AccountVo[names.length];
		for(int i = 0; i < names.length;i++) {
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccountNumber(numbers[i]);
			account.setPassword(passwords[i]);
			account.setBalance(moneys[i]);
			
			list[i] = account;
		}
		return list;
	}
	
	public void showAccountList() {
		System.out.println("=============================");
		System.out.println("\t" + name + " 고객 리스트 ");
		System.out.println("=============================");
		for(int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i];
			System.out.print((i+1) + ". ");
			System.out.print(account.getName() + "\t");
			System.out.print(account.getAccountNumber() + "\t");
			System.out.print(account.getPassword() + "\t");
			System.out.print(account.getBalance() + "\n");
		}
		System.out.println("=============================");
	}
	
	public int searchAccount(AccountPaperVo accountPaper) {
		int resultIdx = -1;
		for(int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i];
			if(account.getAccountNumber().equals(accountPaper.getAccountNumber())
				&& account.getPassword().equals(accountPaper.getPassword())) {
					resultIdx = i;
				break;	// for문 빠져나오기 ~
			}

		}
		return resultIdx;		
	}
	
	/**
	 * 잔액 조회
	 * */
	public void confirmBalance(AccountPaperVo accountPaper) {
		int resultIdx = -1;
		
		for(int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i];
			
			if(account.getAccountNumber().equals(accountPaper.getAccountNumber())
			&& account.getPassword().equals(accountPaper.getPassword())) {
				resultIdx = i;
				break;	// for문 빠져나오기 ~
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
