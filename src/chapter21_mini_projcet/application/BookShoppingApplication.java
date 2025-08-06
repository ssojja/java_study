package chapter21_mini_projcet.application;

import java.util.Scanner;

import chapter21_mini_projcet.model.MemberVo;
import chapter21_mini_projcet.service.ShoppingServiceImpl;

public class BookShoppingApplication {
	public Scanner scan;
	public ShoppingServiceImpl service;
	public static final int MEMBER_INFO = 1;
	public static final int REGISTER = 2;
	public static final int LIST = 3;
	public static final int UPDATE = 4;
	public static final int DELETE_ALL = 5;
	public static final int DELETE = 6;
	public static final int RECEIPT = 7;
	public static final int EXIT = 8;
	public String phone, name = null;
	
	public BookShoppingApplication() {
		scan = new Scanner(System.in);
		service = new ShoppingServiceImpl(this);
		insertInfo();
		showMenu();
	}
	
	/**
	 * 고객 등록
	 * */
	public void insertInfo() {
		
		System.out.println("회원등록을 하시고 쇼핑을 진행해 주세요~!");
		service.menuMemberAdd();
	}
	
	/**
	 * 메뉴출력
	 * */
	public void showMenu() {
		System.out.println("*************************************************");
		System.out.println("\t Welcome to Shopping Mall 🎉🎉🎉");
		System.out.println("\t Welcome to Book Market! 📕📖📕📖");
		System.out.println("*************************************************");
		System.out.println(" 1. 고객 정보 확인하기 \t 2. 장바구니에 항목 추가하기");
		System.out.println(" 3. 장바구니 상품 목록 보기 \t 4. 장바구니의 항목 수량 줄이기");
		System.out.println(" 5. 장바구니 비우기 \t\t 6. 장바구니의 항목 삭제하기");
		System.out.println(" 7. 영수증 표시하기 \t\t 8. 종료");
		System.out.println("*************************************************");
		selectMenu();
	}
	
	public void selectMenu() {
		System.out.print("메뉴 번호를 선택해주세요 > ");
		
		if(scan.hasNextInt()) {
			switch (scan.nextInt()) {
			case MEMBER_INFO: 	service.info(); break;
			case REGISTER:		service.register();		break;
			case LIST: 			service.list();			break;
			case UPDATE: 		service.update();		break;
			case DELETE: 		service.delete();		break;
			case DELETE_ALL: 	service.delete_all();	break;
			case RECEIPT: 		service.receipt();		break;
			case EXIT:			service.exit();			break;
			default: 
				System.out.println("=> 메뉴 준비중입니다.");
				selectMenu();
			}
		} else {
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해주세요.");
			scan.next();
			selectMenu();
		}
	}
	
	public static void main(String[] args) {	
		new BookShoppingApplication();
	}
}
