package kbpractice;


/*
 * 출력 결과 시나리오
	[시작]
	1. 고객 홍길동이 은행을 방문, 은행원 박보검이 은헹시스템 실행!
	2. 출금용지에 이름, 계좌번호, 비밀번호를 작성함
	3. 은행 직원 박보검이 용지를 확인함
	4. 금액이 누락되어 고객에게 금액을 물어봄
	5. 고객이 100만원이라 응답함
	6. 은행 직원이 계좌 정보를 검증함
	7. 출금 처리를 하고, 잔액 400만원으로 업데이트함
	8. 고객이 잔액을 확인하고 퇴장함 [종료]
	
 * */
public class KBBankTest {
	
	public static void main(String[] args) {
		
		// KB은행 방문!
		BankSystem kbsystem = new BankSystem("KB은행");
		kbsystem.showAccountList();
		
		// 은행원 박보검이 은행시스템 정보를 가짐
		BankMan staffPark = new BankMan("박보검", kbsystem); 
		
		// 은행직원 -> 고객정보 리스트 출력
//		staffPark.getKbsystem().showAccountList();
		
		// 고객 클랙스 생성
		AccountPaperVO accountPaper = AccountPaperVO.getInstance();
		Customer hong = new Customer("홍길동", null, "1234", 0);
		hong.setAccountPaper(accountPaper);
		
		// 홍길동이 작성한 내용 보이기
//		accountPaper.showInfo();
		
		// 은행 직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper());
		
		// 고객에게 전달받은 출금용지에 빈 값이 있는지 쳌
		staffPark.validateChcek();
		boolean validateFlag = true;
		
		while(validateFlag) {
			if(staffPark.validateChcek(hong.answer(staffPark.checkResult))) {
				validateFlag = false;
			}
		}
		// 출금용지 최종 값 확인
//		accountPaper.showInfo();
		
		// 값 체크 후 출금 진행
		staffPark.processWithdrawal();
		
		kbsystem.confirmBalance(hong.getAccountPaper());	// 은행시스템을 이용하여 잔액을 확인!
		
		
	}

}
