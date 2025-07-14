package kbpractice;

import kbbank2.AccountVo;

public class BankSystem {
	String name;	// 은행이름
	AccountVo[] accountList;
	
	public BankSystem(String name) {
		this.name = name;
		accountList = createAccountList();
	}
	
	public AccountVo[] createAccountList() {
		String[] names = {"홍길동", "이순신", "김유신"};
		String[] numbers = {"kb-1234", "kb-4567", "kb-0000"};
		String[] password = {"1234", "4567", "0070"};
		int[] balances = {100, 1500, 700};
		
		AccountVo[] list = new AccountVo[names.length];
		for(int i = 0; i < names.length; i++) {
			AccountVo account =  new AccountVo();
			// AccountVo 클래스에 데이터 저장
			account.setName(names[i]);
			account.setAccountNumber(numbers[i]);
			account.setPassword(password[i]);
			account.setBalance(balances[i]);
			// BankSystem 클래스에서 고객정보 생성 후 list에 저장
			list[i] = account;
		}
		return list;
	}
	
	public void showAccountList() {
		System.out.println("====================================");
		System.out.println(this.name + "\t고객 리스트");
		System.out.println("====================================");
		for(int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i];
			System.out.print((i+1) + ". \t");
			System.out.print(account.getName() + "\t");
			System.out.print(account.getAccountNumber() + "\t");
			System.out.print(account.getPassword() + "\t");
			System.out.print(account.getBalance() + "\n");
		}
		System.out.println("====================================");
	}

}
