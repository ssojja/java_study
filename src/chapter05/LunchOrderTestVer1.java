package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1 {

	public static void main(String[] args) {
		// 메뉴판
		System.out.println("*******************************************");
		System.out.println("\tWelcome to Food Market!!!");
		System.out.println("*******************************************");
		System.out.println("\t1. 햄버거(🍔):100\t2. 피자(🍕):200");
		System.out.println("\t3. 라멘(🍜):300\t4. 샐러드(🥗):400");
		System.out.println("\t9. 나가기");
		System.out.println("*******************************************");
		System.out.println("***** Food Mart에 오신것을 환영합니다!");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		int menuNo = -1;
		String menuName = "";
		int menuPrice = 0;
		
		// 1. 메뉴 주문
		System.out.print("메뉴 선택(숫자로) > ");
		if(scan.hasNextInt()) {
			menuNo = scan.nextInt();

			// if문
/*			if(menuNo == 1) {
				menuName = "햄버거(🍔)";
				menuPrice = 100; 
			} else if(menuNo == 2) {
				menuName = "피자(🍕)";
				menuPrice = 200; 
			} else if(menuNo == 3) {
				menuName = "라멘(🍜)";
				menuPrice = 300; 
			} else if(menuNo == 4) {
				menuName = "샐러드(🥗)";
				menuPrice = 400;
			} else if(menuNo == 9){
				System.out.println("- 프로그램을 종료합니다 -");
				System.exit(0);	// System.exit(0) -> 정상종료 
			} else {
				System.out.println("메뉴 준비중입니다.");
			}
*/			
			// switch ~ case문
			switch (menuNo) {
				case 1:	menuName = "햄버거(🍔)";	menuPrice = 100;	break;
				case 2:	menuName = "피자(🍕)";	menuPrice = 200;	break;
				case 3:	menuName = "라멘(🍜)";	menuPrice = 300;	break;
				case 4:	menuName = "샐러드(🥗)";	menuPrice = 400;	break;
				case 9:
					System.out.println("- 프로그램을 종료합니다 -");
					System.exit(0);
					break;
	
				default:
					System.out.println("메뉴 준비중입니다.");
					break;
			}
			
		} else {
			System.out.print("올바르지 않은 입력값입니다.");
		}// if
		
		System.out.println("주문하신 메뉴는 " + menuName + ", 가격은 " + menuPrice + "원 입니다.");
		
		
		// 2. 주문 메뉴 결제
		int charge = 0;
		int change = 0;
		System.out.print("결제할 요금 입력 > ");
		
		if(scan.hasNextInt()) {
			charge = scan.nextInt();
			
			if(charge >= menuPrice) {
				change = charge - menuPrice;
			} else {
				System.out.println("요금이 부족합니다. 다시 입력해 주세요");
			}
			
			
		} else {
			System.out.print("올바르지 않은 입력값입니다.");
		}// if
		
		// 3. 주문 내역 출력 : 주문한 메뉴는(), 결제 금액(), 잔돈() 입니다.
		System.out.println("주문한 메뉴는 "+ menuName + ", 결제금액(" + charge + "원), 잔돈(" + change + "원)입니다.");
		
	}

}
