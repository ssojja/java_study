package chapter07;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	// Field
	Scanner scan = new Scanner(System.in); 
	String[] lunchMenuNames = {"햄버거(🍔)", "피자(🍕)", "라멘(🍜)", "샐러드(🥗)"};
	int[] lunchMenuPrice = {100, 200, 300, 400};
	LunchMenu[] lunchMenuList = new LunchMenu[4];	// 주문할 메뉴 : LunchMenu
	LunchOrderItem[] orderItemList = new LunchOrderItem[4];
	LunchPaymentItem paymentItem;
	int orderCount = 0;
	int amount = 0; // 결제 금액 - 사용자 입력
	int change = 0; // 잔돈
	
	// 시스템 메뉴 : MainMenu
	
	// Constructor
	// Method
	/*
	 *	런치메뉴 생성 
	 * */
	public void createLunchMenu() {
		for(int i = 0; i < lunchMenuNames.length; i++) {
			// for문 밖에 존재할 경우 객체가 한번만 생성되어 모두 동일한 주소 정보와 마지막 값이 리스트에 저장됨
			LunchMenu menu = new LunchMenu();
			
			menu.no = i+1;
			menu.name = lunchMenuNames[i];
			menu.price = lunchMenuPrice[i];
			
			lunchMenuList[i] = menu; // lunch 메뉴 주소값
		}
	}
	
	/*
	 * 런치메뉴 출력
	 * */
	public void showLunchMenu() {
	
		System.out.println("---------------------");
		System.out.println("=>  LunchMenuList ");
		System.out.println("---------------------");
		for(LunchMenu menu : lunchMenuList) {
			System.out.print(menu.no + ". ");
			System.out.print(menu.name + "\t");
			System.out.print(menu.price + "\n");
		}
		System.out.println("---------------------");
		selectLunchMenu();
	}
	
	/*
	 * 런치메뉴 선택
	 * */
	public void selectLunchMenu() {
		System.out.print("주문메뉴(숫자) > ");
		
		if(scan.hasNextInt()) {
			lunchMenuCheck(scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 올바르지 않습니다. 다시 입력해주세요.");
			scan.next(); // 잘못된 값을 우선적으로 받아야함
			selectLunchMenu();
		}	
	}
	
	/*
	 * 메인메뉴 출력
	 */
	public void showMainMenu() {
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
		createLunchMenu();
		selectMainMenu();
	} // showMainMenu method
	
	/*
	 * 메인메뉴 선택
	 * */
	public void selectMainMenu() {
		System.out.print("메인메뉴(숫자) > ");
		
		if(scan.hasNextInt()) {
			mainMenuCheck(scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 올바르지 않습니다. 다시 입력해주세요.");
			scan.next(); // 잘못된 값을 우선적으로 받아야함
			selectMainMenu();
		}
		
	}
	
	/*
	 * 메인메뉴 체크
	 * */
	public void mainMenuCheck(int mainMenu) {
		switch (mainMenu) {
			case 1: showLunchMenu();	break;
			case 2: orderList();		break;
			case 3: payment();			break;
			case 4: paymentList();		break;
			case 9: 
				System.out.println("-- 음식 주문 시스템을 종료합니다. --");
				System.exit(0);
				break;
			default: 
				System.out.println("=> 메뉴 준비중입니다.");
				showMainMenu();
				break;
		}
	}
	
	/*
	 * 런치메뉴 체크
	 * */
	public void lunchMenuCheck(int lunchMenu) {
		// lunchMenu : 1 ~ 4 값이면 => 주문가능, 다른 번호: 메뉴 준비중입니다. 다시 입력하세요.
		if(lunchMenu >= 1 && lunchMenu <= 4) {
			// 주문 진행
			order(lunchMenu);
		} else {
			System.out.println("=> 런치 메뉴 준비중입니다. 다시 입력해주세요.");
			showLunchMenu();
		}
	}
	
	/*
	 * 주문아이템의 인덱스 확인
	 * */
	public int searchOrderItemIdx(int lunchMenu) {
		int idx = -1;
		for(int i = 0; i < orderCount; i++) {
			LunchOrderItem orderItem = orderItemList[i];
			if(orderItem.no == lunchMenu) idx = i;
		}
		return idx ;
	}
	
	/*
	 * 주문리스트 초기화
	 * */
	public void orderItemListInit() {
		for(LunchOrderItem orderItem : orderItemList) {
			if(orderItem != null) orderItem = null;
		}
		orderCount = 0;
	}
	
	
	/*
	 * 주문 : order()
	 */
	public void order(int lunchMenu) {
		
		// lunchMenuList의 메뉴 번호 확인
		for(LunchMenu menu : lunchMenuList) {
			if(menu.no == lunchMenu) {
				int idx = searchOrderItemIdx(lunchMenu);
				if(idx == -1) {
					orderItemList[orderCount] = new LunchOrderItem(); // 생성될때마다 정의하는 것을 권장함
					
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty = 1;
					orderCount++;
				} else {
					orderItemList[idx].qty += 1;
				}
				break;
			}
		}
		showMainMenu();
		System.out.println("=> 주문이 완료되었습니다.");
	}
	
	/*
	 * 주문 내역 : orderList()
	 */
	public void orderList() {
		if(orderCount == 0) {
			System.out.println("=> 주문 내역이 존재하지 않습니다. 음식을 먼저 주문해주세요.");
		} else {
			System.out.println("----------------------------------------");
			System.out.println("\t\t음식 주문 리스트");
			System.out.println("----------------------------------------");
			System.out.println("번호\t  메뉴명\t\t가격\t수량");
			System.out.println("----------------------------------------");
			for(LunchOrderItem orderItem: orderItemList) {
				if(orderItem != null) {
					System.out.print(orderItem.no + "\t");
					System.out.print(orderItem.name + "\t\t");
					System.out.print(orderItem.price + "\t ");
					System.out.print(orderItem.qty + "\t\n");	
				}
				
			}
			System.out.println("----------------------------------------");
		}
		showMainMenu();	
	}
	
	/*
	 * 결제 예정금액
	 * */
	public int totalPayment() {
		int sum = 0; 
		for(LunchOrderItem orderItem: orderItemList) {
			if(orderItem != null) {
				sum += orderItem.price * orderItem.qty;
			}
		}
		System.out.println("sum : " + sum);
		return sum;
	}
	
	/*
	 * 결제
	 */
	public void payment() {
		if(orderCount == 0) {
			System.out.println("=> 주문 내역이 존재하지 않습니다. 음식을 먼저 주문해주세요.");
		} else {
			int total = totalPayment();
			System.out.println("=> 결제 예정 금액 : " + total);
			System.out.print("결제할 요금 입력(숫자) > ");
			
			if(scan.hasNextInt()) {
				
				amount += scan.nextInt();
				System.out.println("=> 총 입력 금액 : " + amount);
				
				if(amount >= total) {
					change = amount - total;
					System.out.println("=> 결제가 완료되었습니다.");
					
					paymentItem = new LunchPaymentItem();
					paymentItem.name = orderItemList[0].name + "등";
					paymentItem.totalPayment = total;
					paymentItem.amount = amount;
					paymentItem.change = change;
					
					// 주문리스트 초기화
					orderItemListInit();
					
				} else {
					System.out.println("=> 요금이 부족합니다. 추가 금액을 입력해주세요.");
					payment();
				}
				 
			} else {
				System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
				scan.next();
			} // if
		}
		showMainMenu();
	}
	
	/*
	 * 결제 내역
	 */
	public void paymentList() {
		if(paymentItem == null) {
			System.out.println("=> 결제 내역이 없습니다. 결제 먼저 진행해주세요.");
		} else {
			System.out.println("----------------------------------------");
			System.out.println("\t\t결제 내역");
			System.out.println("----------------------------------------");
			System.out.println("주문명\t\t결제금액\t총입금액\t잔돈");
			System.out.println("----------------------------------------");
			System.out.print(paymentItem.name + "\t");
			System.out.print(paymentItem.totalPayment + "\t");
			System.out.print(paymentItem.amount + "\t");
			System.out.print(paymentItem.change + "\t\n");	
			System.out.println("----------------------------------------");
		}
		showMainMenu();
	}
	
} // class
