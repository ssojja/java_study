package chapter06;

import java.util.Scanner;

/*
 * 음식 주문/결제 프로그램(콘솔)
 * - 음식을 주문(1), 결제(2), 프로그램 종료(9)하는 메뉴로 구성된다.
 * - 프로그램 종료를 제외하고 나머지 메뉴는 반복 선택 가능하다.
 * - 메뉴 선택 시 체크하는 기능은 switch ~ case를 이용하여 구현한다.
 * 
 * (1) 예외사항 처리 
 * 		: 메뉴 선택, 결제금액 입력 시 정수형 타입이 아닌 경우 메세지 출력 후 재입력을 유도함
 * (2) 입력값이 정확할 때까지 재입력을 유도하여 진행, flag 변수를 이용하여 반복
 * (3) 결제 금액이 부족한 경우 재입력을 통해 금액을 누적으로 계산하여 저장 후 결제
 * */

public class Exercise01 {
	
	public static void main(String[] args) {
		System.out.println("*******************************************");
		System.out.println("\tWelcome to Food Market!!!");
		System.out.println("*******************************************");
		System.out.println("\t 1. 음식 주문");
		System.out.println("\t 2. 주문 내역");
		System.out.println("\t 3. 음식 결제");
		System.out.println("\t 4. 결제 내역");
		System.out.println("\t 9. 프로그램 종료");
		System.out.println("*******************************************");
		System.out.println("\tFood Mart에 오신것을 환영합니다!");
		System.out.println("*******************************************");
		Scanner scan = new Scanner(System.in);
		
		// 주문 음식 리스트
		String[] menuList = {"햄버거(🍔)","피자(🍕)","라멘(🍜)","샐러드(🥗)"};
		int[] priceList = {100, 200, 300, 400};
		
		System.out.print("주문 리스트 크기 > ");
		final int MAX_SIZE = scan.nextInt();
		String[] orderMenuList = new String[MAX_SIZE];
		int[] orderPriceList = new int[MAX_SIZE];
		
		boolean menuFlag = true;
		int count = 0;
		
		while(menuFlag) {
			System.out.print("메뉴 선택(숫자) > ");
			int menu = scan.nextInt();
		
			switch (menu) {
				case 1:	
					boolean orderFlag = true;
					
					if(count == MAX_SIZE) {
						System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능합니다.");
						orderFlag = false;
					}
					
					while(orderFlag) {
						System.out.println("*******************************************");
						System.out.println("\t1. 햄버거(🍔):100\t2. 피자(🍕):200");
						System.out.println("\t3. 라멘(🍜):300\t4. 샐러드(🥗):400");
						System.out.println("*******************************************");
						System.out.print("주문메뉴 선택(숫자로) > ");
						
						if(scan.hasNextInt()) {
							int menuNo = scan.nextInt();
							if(menuNo >=1 && menuNo <= 4 ) {
								orderMenuList[count] = menuList[menuNo-1];
								orderPriceList[count] = priceList[menuNo-1];
								count++;
								System.out.println("=> 주문이 완료되었습니다. 메뉴는 " + menuList[menuNo-1] + "입니다." );
							} else {
								System.out.println("=> 메뉴 준비중입니다.");
							}
							
							if(count == MAX_SIZE) {
								orderFlag = false;
								System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능합니다.");
							} else {
								System.out.print("계속 주문 하시겠습니까? (계속:아무키나 누르세요, 종료:n) > ");
								if(scan.next().equals("n")){
									orderFlag = false;								
								}								
							}
							
						} else {
							System.out.println("=> 올바른 입력이 아닙니다.");
							scan.next();
						}
						
					} // while - orderFlag
					
					break;
				case 2:					
					break;
				case 3:					
					break;
				case 4:					
					break;
				case 9:
					System.out.println("-- 프로그램 종료 --");
					break;
				default:
					break;
			}
			
		} // while-menuFlag
		
		
		
	}

}
