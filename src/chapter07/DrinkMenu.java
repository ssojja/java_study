package chapter07;

import java.util.Scanner;

public class DrinkMenu {
	// Field
	Scanner scan = new Scanner(System.in);
	
	String[] drinkMenuNames = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
	int[] drinkMenuPrice = {2800, 3500, 4000};
	DrinkMenu[] drinkMenuList = new DrinkMenu[3];		// 주문할 메뉴
	DrinkOrder[] orderItemList = new DrinkOrder[3];		// 주문 메뉴
	DrinkPayment paymentItem;
	int no;			// 음료 번호
	String name;	// 음료명
	int price;		// 음료 가격
	int orderCount = 0;
	int amount = 0; // 결제 금액 - 사용자 입력
	int change = 0; // 잔돈
	
	// Constructor
	
	// Method

	/*
	 * 메뉴 출력
	 */
	public void showMenu() {
		System.out.println("[시작]");
		System.out.println("==== 메뉴판 ====");
		System.out.println("1. ☕ 아메리카노 	- 2,800원");
		System.out.println("2. 🍵 바닐라 라떼	- 3,500원");
		System.out.println("3. 🥤 딸기 쉐이크 	- 4,000원");
		createDrinkMenu();
		selectMenu();
	}
	
	/*
	 * 음료 메뉴 생성 
	 * */
	public void createDrinkMenu() {
		for(int i = 0; i < drinkMenuNames.length; i++) {
			DrinkMenu menu = new DrinkMenu();
			
			menu.no = i+1;
			menu.name = drinkMenuNames[i];
			menu.price = drinkMenuPrice[i];
			
			drinkMenuList[i] = menu; // 음료 메뉴 주소값
		}

	}
	
	
	
	/*
	 * 음료 선택
	 * */
	public void selectMenu() {
		System.out.print("주문할 메뉴 번호 입력 > ");
		if(scan.hasNextInt()) {
			menuCheck(scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 올바르지 않습니다. 다시 입력해주세요.");
			scan.next();
			selectMenu();
		}
	}
	
	/*
	 * 주문 음료 체크
	 * */
	public void menuCheck(int menuNum) {
		if(menuNum >= 1 && menuNum <= 3) {
			// 주문 진행
			order(menuNum);
		} else {
			System.out.println("=> 준비중인 메뉴입니다. 다시 입력해주세요.");
			selectMenu();
		}
	}
	
	/*
	 * 음료 주문!!!!!!!!
	 * */
	public void order(int menuNum) {
		// drinkMenuList의 메뉴 번호 확인
		for(DrinkMenu menu : drinkMenuList) {
			if(menu.no == menuNum) {
				int idx = searchOrderItemIdx(menuNum);
				if(idx == -1) {
					orderItemList[orderCount] = new DrinkOrder(); // 생성될때마다 정의하는 것을 권장함
					
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty = 1;
					String menuPriceStr = String.format("%,d", new Object[] {Integer.valueOf(orderItemList[orderCount].price)});
					System.out.println("=> 주문 메뉴 : " + orderItemList[orderCount].name + ", 결제 예정 금액 : " + menuPriceStr+ "원");
					
					orderCount++;
				} else {
					orderItemList[idx].qty += 1;
				}
				break;
			}

		}
		payment();
		
	}
	
	/*
	 * 주문아이템의 인덱스 확인
	 * */
	public int searchOrderItemIdx(int menuNum) {
		int idx = -1;
		for(int i = 0; i < orderCount; i++) {
			DrinkOrder orderItem = orderItemList[i];
			if(orderItem.no == menuNum) idx = i;
		}
		return idx ;
	}
	
	/*
	 * 결제
	 */
	public void payment() {
		if(orderCount == 0) {
			System.out.println("=> 주문 내역이 존재하지 않습니다. 음식을 먼저 주문해주세요.");
		} else {
			int total = totalPayment();
			System.out.print("결제할 금액 입력 > ");
			
			if(scan.hasNextInt()) {
				
				amount += scan.nextInt();
				System.out.println("총 입력 금액 : " + amount);
				
				if(amount >= total) {
					change = amount - total;
					
					String changeStr = String.format("%,d", new Object[] {Integer.valueOf(change)});
					System.out.println("=> 결제 완료! 잔돈: " + changeStr + "원 ");
					
					paymentItem = new DrinkPayment();

					paymentItem.amount = amount;
					paymentItem.change = change;
					
					// 주문리스트 초기화
				//	orderItemListInit();
					
				} else {
					System.out.println("=> 금액이 부족합니다. 다시 입력해주세요.");
					payment();
				}
				 
			} else {
				System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
				scan.next();
			} // if
		}
	}
	
	/*
	 * 결제 예정금액
	 * */
	public int totalPayment() {
		int sum = 0; 
		for(DrinkOrder orderItem: orderItemList) {
			if(orderItem != null) {
				sum += orderItem.price * orderItem.qty;
			}
		}
		return sum;
	}

}
