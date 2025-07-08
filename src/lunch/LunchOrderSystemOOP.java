package lunch;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	// Field
	Scanner scan;
	LunchOrderMenuManager menuManager;
	String[] lunchMenuNames = {"햄버거(🍔)", "피자(🍕)", "라멘(🍜)", "샐러드(🥗)"};	// 선언과 할당이 동시에 주워져야함
	int[] lunchMenuPrice = {100, 200, 300, 400};
	LunchMenu[] lunchMenuList; // = new LunchMenu[4];  , 크기만 선언
	LunchOrderItem[] orderItemList; // = new LunchOrderItem[4];
	LunchPaymentItem paymentItem;
	int orderCount = 0;
	int amount = 0; // 결제 금액 - 사용자 입력
	int change = 0; // 잔돈
	String title;
	
	// 시스템 메뉴 : MainMenu
	
	// Constructor
	public LunchOrderSystemOOP() {	// 호출할 때 초기화
		scan = new Scanner(System.in);
		// class LunchOrderSystemOOP가 주소정보를 넘길때 this사용
		menuManager = new LunchOrderMenuManager(this);
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		
		menuManager.createLunchMenu();	// 런치 메뉴 생성 메소드 호출
	}

	public LunchOrderSystemOOP(String title) {	// 호출할 때 초기화
		this.title = title; 
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager(this);
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		 
		menuManager.createLunchMenu();	// 런치 메뉴 생성 메소드 호출
		menuManager.showMainMenu();
	}
	
	// Method
	
	
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
		menuManager.showMainMenu();
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
		menuManager.showMainMenu();	
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
		menuManager.showMainMenu();
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
			System.out.print(paymentItem.name + "\t\t");
			System.out.print(paymentItem.totalPayment + "\t");
			System.out.print(paymentItem.amount + "\t");
			System.out.print(paymentItem.change + "\t\n");	
			System.out.println("----------------------------------------");
		}
		menuManager.showMainMenu();
	}
	
} // class
