package vending_machine_ver1;

import commons.Menu;

/*
1. ☕ 밀크커피 - 300원
2. ☕ 아메리카노 - 400원
3. 🍋 유자차 - 300원
4. 🥛 우유 - 200원
 * */
public class VendingMachine {
	// Field
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 우유"};
	int[] priceList = {300, 400, 300, 200};
	Menu[] menuList;
	String title;
	
	// Constructor
	public VendingMachine() {
		this("막심");
	}
	
	public VendingMachine(String title) {
		this.title = title;
		crateMenuList();
		showMenuList();
	}
	
	// Method
	/*
	 * 메뉴 리스트 생성
	 * */
	public void crateMenuList() {
		menuList = new Menu[nameList.length];
		for(int i = 0; i < nameList.length; i++) {
			int no = i+1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}
	}
	
	/*
	 * 메뉴 출력
	 * */
	public void showMenuList() {
		System.out.println("-----------------------------------------");
		System.out.println("\t☕🍵🥤 " + title +" Coffee Menu");
		System.out.println("-----------------------------------------");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ".\t");
			System.out.print(menu.getName() + "\t\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("-----------------------------------------");
	}
	
}
