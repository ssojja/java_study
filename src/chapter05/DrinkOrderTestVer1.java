package chapter05;

/*
 * 음료 주문 프로그램
 * */
import java.util.Scanner;

public class DrinkOrderTestVer1 {

	public static void main(String[] args) {
		// 지역 변수 선언
		Scanner scan = new Scanner(System.in);
		String menuName = "";
		String menuPriceStr = "";
		String changeStr = "";
		int menuNo = -1;
		int menuPrice = 0;
		int charge = 0;		// 결제 금액
		int change = 0;		// 잔돈
		boolean menuFlag = true;
		boolean paymentFlag = true;

		// step 1 : 메뉴판 출력
		System.out.println("[시작]");
		System.out.println("---------------------------------------");
		System.out.println("\t☕🍵🥤 Mega Coffee Menu");
		System.out.println("---------------------------------------");
		System.out.println("\t1. ☕ 아메리카노 	- 2,800원");
		System.out.println("\t2. 🍵 바닐라 라떼	- 3,500원");
		System.out.println("\t3. 🥤 딸기 쉐이크	- 4,000원");
		System.out.println("---------------------------------------");
		
		
		// step 2 : 음료 주문 기능
		while(menuFlag) {
			System.out.print("주문할 메뉴 번호 입력 > ");
			if(scan.hasNextInt()) {
				menuFlag = false;
				menuNo = scan.nextInt();
				
				// 선택 메뉴번호를 체크하여 메뉴명, 메뉴가격을 별도의 변수에 저장
				switch (menuNo) {
					case 1:	menuName = "☕ 아메리카노";  menuPrice = 2800; break;
					case 2:	menuName = "🍵 바닐라 라떼"; menuPrice = 3500; break;
					case 3:	menuName = "🥤 딸기 쉐이크"; menuPrice = 4000; break;
					default:
						System.out.println("=> 준비중 입니다.\n");
						menuFlag = true;
						break;
				}
				// 출력용 메뉴가격 저장
				menuPriceStr = String.format("%,d", new Object[] {Integer.valueOf(menuPrice)});
				
			} else {
				System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.\n");
				scan.next();
			}		
		} // while(메뉴주문)
		
		System.out.println("=> 주문 메뉴 : " + menuName + ", 결제 예정 금액 : " + menuPriceStr + "원");
		System.out.println();
		
		// step 3 : 결제 기능
		while(paymentFlag) {
			System.out.print("결제할 금액 입력 > ");
			
			if(scan.hasNextInt()) {
				charge += scan.nextInt();
				System.out.println("총 입금금액 : " + charge);
				
				if(charge >= menuPrice) {
					change = charge - menuPrice;
					paymentFlag = false;
				} else {
					System.out.println("=> 금액이 부족합니다. 다시 입력해주세요.\n");
				}
				
			} else {
				System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.\n");
				scan.next();
			}
			
		} // while(결제)
		changeStr = String.format("%,d", new Object[] {Integer.valueOf(change)});
		System.out.println("=> 결제 완료! 잔돈 : " + changeStr +"원 \n");
		
		System.out.println("[종료]");
		System.out.println("이용해주셔서 감사합니다.‍"); 

	}

}
