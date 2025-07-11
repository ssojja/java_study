package kbbank2;

public class KBBankTest {
	
	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB은행");
		kbsystem.showAccountList();
		// 입출금 용지 한장 비치됨
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();	// 싱글톤
//		System.out.println("1 ---> " + accountPaper.getName());
		
		BankMan staffPark = new BankMan("박보검", kbsystem);	// 은행직원 생성시 고객리스트 정보 가짐
		
		// 은행직원 -> 고객정보 리스트 출력
//		staffPark.getKbsystem().showAccountList();
		
		// 고객 클랙스 생성
		Customer hong = new Customer("홍길동", "kb-1234", null , 0);
		boolean validateFlag = true;
		hong.setAccountPaper(accountPaper);
//		AccountPaperVo.showInfo();
		
		// 은행 직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper());
		staffPark.validateChcek(); 	// 고객에게 전달받은 출금용지에 빈 값이 있는지 쳌
//		hong.answer(staffPark.checkResult);
//		AccountPaperVo.showInfo();
		while(validateFlag) {
			if(staffPark.validateChcek(hong.answer(staffPark.checkResult))) {
				validateFlag = false;
			}
		}
		
		staffPark.processWithdrawal();

		kbsystem.confirmBalance(hong.getAccountPaper());	// 은행시스템을 이용하여 잔액을 확인!
		
	}

}
