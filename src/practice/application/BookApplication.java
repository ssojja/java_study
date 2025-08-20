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
	
	public void showMenu() {
		System.out.println("메뉴 확인;;;;;;;;");
	}
	
	public static void main(String[] args) {
		new BookApplication();
	}
	
}
