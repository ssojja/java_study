package vending_machine_ver2;

import commons.Menu;

public class VendingMachine {
	// Field
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 초코우유"};
	int[] priceList = {300, 400, 300, 200};
	
	Menu[] menuList;
	Menu[] orderMenuList;
	
	String title;
	User user;
	int totalCoin;
	int orderCount = 0;
	int change;
	
	Menu orderMenu;
	
	public final static int EXIT = 9;
	
	// Constructor
	public VendingMachine(User user) {
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	// Method
	
	public void showMenuList() {
		System.out.println("-------------------------------------------");
		System.out.println("\t☕🍵🥤 Maxim Coffee Machine");
		System.out.println("-------------------------------------------");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ".\t   ");
			System.out.print(menu.getName() + "\t\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("-------------------------------------------");
	}
	
	/*
	 * 주문 가능한 목록만 출력
	 * */
	public void showMenuList(String msg) {
		System.out.println("-------------------------------------------");
		System.out.println("\t☕🍵🥤 Maxim Coffee Machine");
		System.out.println("-------------------------------------------");
		System.out.println("\t" + msg);
		System.out.println("-------------------------------------------");
		for(int i = 0; i < orderCount; i++) {
			Menu menu = orderMenuList[i];
			
			System.out.print(menu.getNo() + ".\t   ");
			System.out.print(menu.getName() + "\t\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("-------------------------------------------");	
	
	}
	
	public int insertCoin() {
		int resultCoin = 0;
		System.out.print("["+ user.name +"] 동전입력 > ");
		if(user.scan.hasNextInt()) {
			int coin = user.scan.nextInt();
			resultCoin = coin;
		} else {
			System.out.println("=> 올바르지 않은 입력입니다. 다시 입력해주세요.");
			user.scan.next();
			insertCoin();
		}
		return resultCoin;
	}	
	
	/*
	 * 주문 가능한 메뉴 리스트 생성
	 * */
	public void createOrderMenuList(int totalCoin) {
		orderMenuList = new Menu[nameList.length];	
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[orderCount] = menu;
				orderCount++;
			}
		}
	}
	
	public void createMenuList() {
		menuList = new Menu[nameList.length];	// 메뉴 리스트에 메뉴명과 가격 담기
		for(int i = 0; i < nameList.length; i++) {
			int no = i+1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}
	}
	
	/*
	 * 메뉴 정합성 검증
	 * */
	public boolean menuCheck(int menuNo) {
		boolean result = false;
		for(int i = 0; i < orderCount; i++) {
			Menu menu = orderMenuList[i];
			if(menuNo == menu.getNo()) {
				result = true;
			}			
		}
		return result;
	}
	
	/*
	 * 찐 주문
	 * */
	public void placeOrder(int menuNo) {
		// 주문 가능한 메뉴리스트에서 선택한 menuNo를 비교하여 메뉴 주소를 orderMenu에 대입!
		for(Menu menu : orderMenuList) {
			if(menu != null) {
				if(menu.getNo() == menuNo) orderMenu = menu;	// 주소값을 넣어준다. 		
					orderMenu = menu;
			} else break;
		}
		System.out.println("=> 주문이 완료되었습니다.");
		processPayment();
	}
	
	/*
	 * 결제......
	 * */
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			if(price <= totalCoin) {
				change = totalCoin - price;
				System.out.println("=> 결제 완료되었습니다.");
				reset(); // 사용한 객체 초기화 작업 => orderMenuList, orderMenu, orderMenuCount, totalCoin
			}
		}
		
		finalCheck();
	}
	
	/*
	 * 마지막 체크.....
	 * */
	public void finalCheck() {
		int price = menuList[menuList.length -1].getPrice();
		if(change >= price) { // 메뉴리스트의 마지막 주소가 가리키는 객체의 가격
			// 잔돈이 최소 주문금액보다 크면!! 계속 주문 가능하게 만듬
			System.out.println("잔돈 : " + change);
			totalCoin = change;
			createOrderMenuList(totalCoin);
			showMenuList("주문 가능 메뉴 리스트"); 
			selectMenu();
		} else {
			System.out.println("=> 결제 내역");
			System.out.println("=> 잔돈 : " + change);
			System.out.println("=> 이용해 주셔서 감사합니다.");
		}
	}
	
	
	/*
	 * 종료 후 객체 초기화
	 * */
	public void reset() {
		orderMenuList = null;
		orderMenu = null;
		orderCount = 0;
		totalCoin = 0;
	}
	
	
	/*
	 * 주문
	 * */
	public void selectMenu() { // 정확한 메뉴 선택!
		System.out.println("=> 메뉴를 선택해주십셔! > ");
		System.out.print("=> 취소하고 싶으면은....." + VendingMachine.EXIT + "번 눌러봐요... > ");
		if(user.scan.hasNextInt()) {
			int menuNo = user.scan.nextInt();
			if(menuNo != VendingMachine.EXIT) {
				if(menuCheck(menuNo)) {
					placeOrder(menuNo);
				} else {
					System.out.println("=> 주문할 수 없는 메뉴입니다.");
					selectMenu();
				}
			} else {
				System.out.println("=> 동전을 반환합니다....");
				System.out.println("=> 반환 금액 : " + totalCoin + "원");
				System.exit(0);
			}
			
		} else {
			System.out.println("=> 올바르지 않은 값입니다. 다시 입력해주세요.");
		}
		
		
	}
	
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입해주세요!");
		int coin = insertCoin();
		if(coin == 100 || coin == 500) { // 사용가능 동전 체크!
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			if(totalCoin < 200) {
				System.out.println("=> 최소 금액 부족합니다요.");
				checkInsertCoin();
			} else {
				System.out.print("=> 메뉴선택(n), 동전 투입을 계속하시면 아무키나 입력 > ");
				if(user.scan.next().equals("n")) {
					createOrderMenuList(totalCoin);
					showMenuList("주문 가능 메뉴 리스트"); 
					selectMenu();
				} else {
					checkInsertCoin();
				}
			}
		} else {
			System.out.println("동전은 100원, 500원만 사용 가능하며 투입한 동전은 반환됩니다.");
			checkInsertCoin();
		}
	}
	
	
}
