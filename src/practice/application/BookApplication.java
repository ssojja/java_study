package practice.application;

import java.util.Scanner;

import practice.service.ShoppingServiceImpl;

public class BookApplication {
	public Scanner scan;
	public ShoppingServiceImpl service;
	
	public BookApplication() {
		scan = new Scanner(System.in);
		service = new ShoppingServiceImpl(this);
//		insertInfo();
		showMenu();
	}
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		// 배열을 이용하여 메뉴 출력
				String[] labels = {"도서 등록", "도서 목록 조회", "도서 검색", "도서 수정", "도서 삭제", "종료"};
				System.out.println("===== 📕📖📚 도서 관리 시스템 📕📖📚 =====");
//				System.out.println(" 전체 도서 수 : " + service.getCount());
				System.out.println("===================================");
				
				for(int i = 0; i < labels.length; i++) {
					System.out.println("\t" + (i+1)+ ". " + labels[i]);	
				}
				System.out.println("===================================");
//				selectMenu();
	}
	
	public static void main(String[] args) {
		new BookApplication();
	}
	
}
