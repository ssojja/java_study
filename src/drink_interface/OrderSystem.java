package drink_interface;

import java.util.Scanner;

//import commons.Menu;

public class OrderSystem {
	// Field
	String title;
	Scanner scan = new Scanner(System.in);
	String[] names = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
	int[] price = {2800, 3500, 4000};
	Menu[] menuList = new MenuItem[names.length];
	Order order;
	Payment payment;
	
	// Constructor
	public OrderSystem() {
		this("Mega");
	}

	public OrderSystem(String title) {
		this.title = title;
		init();
	}
	
	// Method
	public void init() {
		payment = new Payment();
		createMenuList();
		showMenu();
		selectMenu();
	}

	public void createMenuList() {
		for(int i = 0; i < names.length; i++) {
			Menu menu = new MenuItem((i+1), names[i], price[i]);
			menuList[i] = menu;
		}
	}
	
	public void showMenu() {
		System.out.println("-------------------------------");
		System.out.println("   ☕🍵🥤 " + title +" Coffee Menu");
		System.out.println("-------------------------------");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ".\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("-------------------------------");
		
		/*
		 for(int i = 0; i <menuList.length; i++) {
			Menu menu = 
			System.out.print(menu.no + ".\t");
			System.out.print(menu.name + "\t");
			System.out.print(String.format("%,d", menu.price) + "\n");
		}
		*/
	}
	
	/*
	 * 메뉴 선택
	 * */
	public void selectMenu() {
		System.out.print("주문할 메뉴 번호 입력 > ");
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			if(menu >= 1 && menu <= 3) {
				placeOrder(menu);	// 주문 진행
			} else {
				System.out.println("=> 준비중인 메뉴입니다. 다시 입력해주세요.");
			}
		} else {
			System.out.println("=> 입력된 값이 올바르지 않습니다. 다시 입력해주세요.");
			scan.next();	// 잘못 입력된 값 처리
			selectMenu();
		}
	}
	
	/*
	 * 주문 기능!
	 * */
	public void placeOrder(int menu) {
		// 번호에 맞는 메뉴를 메뉴리스트에서 검색한다. 검색한 메뉴를 Order생성자에 매개변수로 입력
		order = new Order(searchMenu(menu));
		if(order.orderMenu != null) order.getInfo();
		System.out.println("=> 주문이 완료되었습니다.");
		
		processPayment();
	}
	
	/*
	 * 결제 기능!
	 * */
	public void processPayment() {
		System.out.print("결제할 금액 입력 > ");
		if(scan.hasNextInt()) {
			payment.setAmount(scan.nextInt());
			System.out.println("=> 총 입금 금액 : " + payment.getAmount());
			
			if(payment.getPayment(order.orderMenu.getPrice())) {
				// 결제 완료
				System.out.println("=> 결제가 완료되었습니다. 잔돈 : " + payment.getChange() + "원");
				showMenu();
				selectMenu();
			} else {
				// 금액 부족
				System.out.println("=> 금액이 부족합니다. 다시 입력해주세요.");
				processPayment();
			}
			
		} else {
			System.out.println("=> 입력된 값이 올바르지 않습니다. 다시 입력해주세요.");
			scan.next();	// 잘못 입력된 값 처리
			processPayment();
		}
	}
	
	public Menu searchMenu(int menuNo) {
		Menu menu = null;
		
		for(Menu m : menuList) {	// menuList[0] --> m --> Menu(아메리카노);
			if(m.getNo() == menuNo) {
				menu = m;
				break;	// for문을 빠져나오기 위해 브레이크 댄스
			}
		}	
		return menu;
	}
} // class
