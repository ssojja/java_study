package com.today.app;

import java.util.Scanner;

import com.today.service.ScoreService;
import com.today.service.ScoreServiceImpl;

/**
 * 메뉴 생성 및 출력
 * */
public class ScoreMgmSystem {
	public Scanner scan;
	ScoreService service;
	public static final int RESISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;
	
	public ScoreMgmSystem() {
		scan = new Scanner(System.in);
		service = new ScoreServiceImpl(this);
		showMenu();
		selectMenu();
	}

	public void showMenu() {
		System.out.println("===== 학생 성적 관리 시스템 =====");
		System.out.println("전체 학생 수 : " + service.getCount());
		System.out.println("\t1. 등록");
		System.out.println("\t2. 조회");
		System.out.println("\t3. 검색");
		System.out.println("\t4. 수정");
		System.out.println("\t5. 삭제");
		System.out.println("\t6. 종료");
		System.out.println("----------------------------");
	}

	public void selectMenu() {
		System.out.print("메뉴 선택 > ");
		switch (scan.nextInt()) {
			case RESISTER: 	service.register(); break;
			case LIST: 		service.list(); 	break;
			case SEARCH: 	service.search(); 	break;
			case UPDATE: 	service.update(); 	break;
			case DELETE: 	service.delete(); 	break;
			case EXIT: 		service.exit(); 	break;
			default: System.out.println("=> 메뉴 준비중입니다."); 	break;
		}
	}
	
	public static void main(String[] args) {
		new ScoreMgmSystem();
	}

}
