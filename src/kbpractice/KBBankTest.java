package kbpractice;

public class KBBankTest {

	public static void main(String[] args) {
		// KB은행 방문!
		BankSystem kbsystem = new BankSystem("KB은행");
		// 생성된 고객리스트 확인
		kbsystem.showAccountList();
		// 은행원 박보검이 은행시스템 정보를 가짐
		BankMan staffPark = new BankMan("박보검", kbsystem);
		// 은행직원 -> 고객정보 리스트 출력		
//		staffPark.getKbsystem().showAccountList();
		// 고객 클랙스 생성
		Customer hong = new Customer("홍길동", null, "1234", 0);
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();
		hong.setAccountPaper(accountPaper);
		// 홍길동이 작성한 내용 보이기
//		accountPaper.showInfo();
		// 은행 직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper());
		// 고객에게 전달받은 출금용지에 빈 값이 있는지 쳌
		staffPark.validateChcek();		
		
		boolean validateFlag = true;
	
		// 출금용지 최종 값 확인		
		while(validateFlag) {
			if(staffPark.validateChcek(hong.answer(staffPark.checkResult))) {
				validateFlag = false;
			}
		}
		
		// 값 체크 후 출금 진행
		staffPark.processWithdrawal();
		
		// 은행시스템을 이용하여 잔액을 확인!
		kbsystem.confirmBalance(hong.getAccountPaper());	// 은행시스템을 이용하여 잔액을 확인!

	}

}
