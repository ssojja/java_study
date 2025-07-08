package lunch;

public class LunchOrderMenuManager {
	// Field
	LunchOrderSystemOOP system;
	
	// Constructor
	public LunchOrderMenuManager() { // 기본생성자
		
	}
	
	public LunchOrderMenuManager(LunchOrderSystemOOP system) {
		this.system = system;		
	}
	
	
	// Method
	/*
	 *	런치메뉴 생성 
	 * */
	public void createLunchMenu() {
		for(int i = 0; i < system.lunchMenuNames.length; i++) {
			// for문 밖에 존재할 경우 객체가 한번만 생성되어 모두 동일한 주소 정보와 마지막 값이 리스트에 저장됨
			LunchMenu menu = new LunchMenu();
			
			menu.no = i+1;
			menu.name = system.lunchMenuNames[i];
			menu.price = system.lunchMenuPrice[i];
			
			system.lunchMenuList[i] = menu; // lunch 메뉴 주소값
		}
	}
	
	/*
	 * 런치메뉴 출력
	 * */
	public void showLunchMenu() {
	
		System.out.println("---------------------");
		System.out.println("=>  LunchMenuList ");
		System.out.println("---------------------");
		for(LunchMenu menu : system.lunchMenuList) {
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
		
		if(system.scan.hasNextInt()) {
			lunchMenuCheck(system.scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 올바르지 않습니다. 다시 입력해주세요.");
			system.scan.next(); // 잘못된 값을 우선적으로 받아야함
			selectLunchMenu();
		}	
	}
	
	/*
	 * 메인메뉴 출력
	 */
	public void showMainMenu() {
		System.out.println("*******************************************");
		System.out.println("\tWelcome to " + system.title + " Food Market!!!");
		System.out.println("*******************************************");
		System.out.println("\t 1. 음식 주문");
		System.out.println("\t 2. 주문 내역");
		System.out.println("\t 3. 음식 결제");
		System.out.println("\t 4. 결제 내역");
		System.out.println("\t 9. 프로그램 종료");
		System.out.println("*******************************************");
		System.out.println("\tFood Mart에 오신것을 환영합니다!");
		System.out.println("*******************************************");
//		createLunchMenu();
		selectMainMenu();
	} // showMainMenu method
	
	/*
	 * 메인메뉴 선택
	 * */
	public void selectMainMenu() {
		System.out.print("메인메뉴(숫자) > ");
		
		if(system.scan.hasNextInt()) {
			mainMenuCheck(system.scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 올바르지 않습니다. 다시 입력해주세요.");
			system.scan.next(); // 잘못된 값을 우선적으로 받아야함
			selectMainMenu();
		}
		
	}
	
	/*
	 * 메인메뉴 체크
	 * */
	public void mainMenuCheck(int mainMenu) {
		switch (mainMenu) {
			case 1: showLunchMenu();	break;
			case 2: system.orderList();		break;
			case 3: system.payment();			break;
			case 4: system.paymentList();		break;
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
			system.order(lunchMenu);
		} else {
			System.out.println("=> 런치 메뉴 준비중입니다. 다시 입력해주세요.");
			showLunchMenu();
		}
	}

}
