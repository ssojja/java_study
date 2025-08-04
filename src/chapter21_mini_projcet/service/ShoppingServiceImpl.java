package chapter21_mini_projcet.service;

import java.util.List;
import java.util.Scanner;

import chapter21_mini_projcet.application.BookShoppingApplication;
import chapter21_mini_projcet.model.BookVo;
import chapter21_mini_projcet.model.CartVo;
import chapter21_mini_projcet.model.MemberVo;
import chapter21_mini_projcet.repository.BookRepositoryImpl;
import chapter21_mini_projcet.repository.CartRepositoryImpl;
import chapter21_mini_projcet.repository.MemberRepositoryImpl;
import chapter21_mini_projcet.repository.ShoppingRepositoryInterface;

public class ShoppingServiceImpl implements ShoppingService{
	String name, phone;
	Scanner scan;
	BookShoppingApplication BookApp;
	ShoppingRepositoryInterface<MemberVo> memberRep = new MemberRepositoryImpl();
	ShoppingRepositoryInterface<BookVo> bookRep = new BookRepositoryImpl();
	ShoppingRepositoryInterface<CartVo> cartRep = new CartRepositoryImpl();
		
	public ShoppingServiceImpl() {}
	public ShoppingServiceImpl(BookShoppingApplication BookApp) {
		this.BookApp = BookApp;
		this.scan = BookApp.scan;
	}
	
	/**
	 * 고객 정보 등록
	 * */
	public int insert(MemberVo member) {
		this.name = member.getName();
		this.phone = member.getPhone();
		return memberRep.insert(member);
	}
	
	@Override
	public void info() {
		MemberVo member = memberRep.find(phone);
		System.out.println("현재 고객 정보 >> ");
		System.out.println("이름 : " + member.getName() + ", 연락처 : " + member.getPhone());
		
		// 메인메뉴 호출!
		BookApp.showMenu();
		BookApp.selectMenu();
	}
	
	@Override
	public void register() {
		CartVo cart = new CartVo();
		List<BookVo> bookList = bookRep.findAll();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("도서 ID | 도서 제목 | 가격 | 저자명 | 내용 | 도서 종류 | 출판일");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		bookList.forEach((book) -> {
			System.out.println(book.getBid() + " | " + book.getTitle() + " | " + book.getPrice() + " | " + 
					book.getAuthor() + " | " +  book.getContent() + " | " + book.getCategory() + " | " + book.getBdate());
		});
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		
		System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
		String id = scan.next();
		System.out.print("장바구니에 추가하시겠습니까 ? y:종료 | 아무키:계속 추가 > ");

		if(scan.next().equals("y")) {
			BookVo book = bookRep.find(id);
			MemberVo member = memberRep.find(phone);
			
			cart.setBid(book.getBid());
			cart.setMid(member.getMid());
			if(cartRep.insert(cart) == 1) System.out.println(id + " 도서가 장바구니에 추가되었습니다.");
			else System.out.println(id + " 도서 추가 실패");			
		} 
		
		// 메인메뉴 호출!
		BookApp.showMenu();
		BookApp.selectMenu();
	}
	
	@Override
	public void list() {
		MemberVo member = memberRep.find(phone);
		String mid = String.valueOf(member.getMid());
		
		CartVo cartList = cartRep.find(mid);
		System.out.println("------------------------------------------------");
		System.out.println("도서ID\t |\t수량|\t합계 |");
		System.out.println("------------------------------------------------");
		System.out.print(cartList.getBid() + " | \t"); 
		System.out.print(cartList.getCnt() + " | \t"); 
		System.out.print(cartList.getTotPrice() + " | \n"); 
		System.out.println("------------------------------------------------");
		
		// 메인메뉴 호출!
		BookApp.showMenu();
		BookApp.selectMenu();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete_all() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void receipt() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void exit() {
		System.out.println("-- 프로그램이 종료됩니다. --");
		cartRep.close();
		System.exit(0);
		
	}
	
}
