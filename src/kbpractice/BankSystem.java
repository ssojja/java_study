package kbpractice;

import kbbank2.AccountVo;

public class BankSystem {
	String name;	// 은행 이름
	AccountVo[] accountList;
	
	public BankSystem(String name) {
		this.name = name;
		// 은행 고객 리스트 생성 accountList 생성
		accountList = createAccountList();
	}
	
	public void showAccountList(){
		System.out.println("=====================================");
		System.out.println("\t" + name +" 고객 리스트 (" + accountList.length + ")명");
		System.out.println("=====================================");
		for(int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i]; // 리스트
			System.out.print((i+1) + ".\t");
			System.out.print(account.getName() + "\t");
			System.out.print(account.getAccountNumber() + "\t");
			System.out.print(account.getPassword() + "\t");
			System.out.print(account.getBalance() + "\n");
		}
		System.out.println("=====================================");
	}
	
	public AccountVo[] createAccountList() {
		String[] names = {"홍길동", "이순신", "김유신"};
		String[] numbers = {"kb-1234", "kb-9876", "kb-3456"};
		String[] passwords = {"1234", "9876", "3456"};
		int[] balances = {500, 1000, 700};
		
		AccountVo[] list = new AccountVo[names.length];
		for(int i = 0; i < names.length; i++) {
			AccountVo account = new AccountVo();
			account.setAccountNumber(numbers[i]);
			account.setBalance(balances[i]);
			account.setName(names[i]);
			account.setPassword(passwords[i]);
			list[i] = account;
		}
		return list;
	}
}
