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
	int money = 0;
	String name, phone, mid;
	Scanner scan;
	BookShoppingApplication bms;
	ShoppingRepositoryInterface<MemberVo> memberRep = new MemberRepositoryImpl();
	ShoppingRepositoryInterface<BookVo> bookRep = new BookRepositoryImpl();
	ShoppingRepositoryInterface<CartVo> cartRep = new CartRepositoryImpl();
		
	public ShoppingServiceImpl() {}
	public ShoppingServiceImpl(BookShoppingApplication bms) {
		this.bms = bms;
		this.scan = bms.scan;
	}
	
	/**
	 * 고객 정보 등록
	 * */
	@Override
	public void menuMemberAdd() {		
		MemberVo member = new MemberVo();
		
		System.out.print("당신의 이름을 입력하세요 : ");
		member.setName(scan.next());
		
		System.out.print("연락처를 입력하세요 : ");
		member.setPhone(scan.next());
		
		System.out.print("주소를 입력하세요 : ");
		scan.nextLine();  //nextLine() : 띄어쓰기 필요한 문장 입력시, \n을 포함
		member.setAddr(scan.nextLine()); 
		
		memberRep.insert(member);
		this.mid = memberRep.findId();  //방금전 회원등록한 회원의 mid 가져오기!!
	}
	
	@Override
	public void info() {
		MemberVo member = memberRep.find(mid);
		if(member != null) {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("고객번호\t고객명\t주소\t\t전화번호\t\t가입일자");
			System.out.println("------------------------------------------------------------------------");
			System.out.print(member.getMid() +"\t");
			System.out.print(member.getName() +"\t");
			System.out.print(member.getAddr() +"\t");
			System.out.print(member.getPhone() +"\t");
			System.out.print(member.getMdate() +"\n");	
			System.out.println("------------------------------------------------------------------------");
		} else {
			System.out.println("🚫 등록된 회원이 존재하지 않습니다.");
		}
		// 메인메뉴 호출!
		bms.showMenu();
		bms.selectMenu();
	}
	
	@Override
	public void register() {
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
		System.out.print("장바구니에 추가하시겠습니까 ? (y:추가, 아무키:추가취소) > ");

		if(scan.next().equals("y")) {
			CartVo cart = new CartVo();
			BookVo book = bookRep.find(id);

			CartVo findCart = cartRep.find(id);
			
			if(findCart != null && findCart.getMid().equals(mid)) {
				cart.setMid(mid);
				cart.setBid(book.getBid());
				cart.setCnt(findCart.getCnt()+1);
				if(cartRep.update(cart) == 1) System.out.println(id + " 도서가 장바구니에 수량 추가되었습니다.");
				else System.out.println(id + " 도서 수량 추가 실패");				
			} else {
				cart.setMid(mid);
				cart.setBid(book.getBid());
				if(cartRep.insert(cart) == 1) System.out.println(id + " 도서가 장바구니에 추가되었습니다.");
				else System.out.println(id + " 도서 추가 실패");					
			}
		} 
		
		// 메인메뉴 호출!
		bms.showMenu();
		bms.selectMenu();
	}
	
	@Override
	public void list() {
		List<CartVo> cartList = cartRep.findAll();
		if(cartList.size() != 0) {
			System.out.println("-------------------------------------------------");
			System.out.println("	도서ID	|	수량	|	합계	");
			System.out.println("-------------------------------------------------");
			cartList.forEach((cart) -> {
				System.out.print(cart.getBid() + "	|	"); 
				System.out.print(cart.getCnt() + "	|	"); 
				System.out.print(cart.getTotPrice() + "	\n"); 			
			});
			System.out.println("-------------------------------------------------");
			
		} else {
			System.out.println("=> 장바구니에 담은 상품이 없습니다.");
		}

		// 메인메뉴 호출!
		bms.showMenu();
		bms.selectMenu();
	}
	
	@Override
	public void update() {
		CartVo cart = new CartVo();
	
		System.out.print("항목 수정할 도서의 ID를 입력하세요 : ");
		String bookId = scan.next();
		
		cart.setBid(bookId);
		
		System.out.print("수량을 입력하세요 : ");
		int cnt  = scan.nextInt();
		
		cart.setMid(mid);
		cart.setCnt(cnt);
		
		BookVo book = bookRep.find(bookId);
		
		if(book != null) {
			if(cartRep.update(cart) == 1) System.out.println("=> 도서 수량이 수정되었습니다.");
			else System.out.println("=> 도서 수량 수정 실패");
		} else {
			System.out.println("🚫 입력한 도서가 존재하지 않습니다.");
		}

		// 메인메뉴 호출!
		bms.showMenu();
		bms.selectMenu();
	}
	
	@Override
	public void delete() {
		List<CartVo> cartList = cartRep.findAll();
		if(cartList.size() != 0) {
			System.out.println("-------------------------------------------------");
			System.out.println("	도서ID	|	수량	|	합계	");
			System.out.println("-------------------------------------------------");
			cartList.forEach((cart) -> {
				System.out.print(cart.getBid() + "	|	"); 
				System.out.print(cart.getCnt() + "	|	"); 
				System.out.print(cart.getTotPrice() + "	\n"); 			
			});
			System.out.println("-------------------------------------------------");
			System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
			String bookId = scan.next();
			
			CartVo cart = cartRep.find(bookId);
			
			if(cart != null) {
				// 정말로 삭제 진행 여부 확인!
				System.out.print("참말로 삭제하시겠습니까? (y:삭제, 아무키:삭제취소) > ");
				if(scan.next().equals("y")) {
					cartRep.remove(bookId);
					System.out.println("✅해당 항목이 삭제되었습니다.");
				} else {
					// 메인메뉴 호출!
					bms.showMenu();
					bms.selectMenu();
				}
			} else {
				System.out.println("🚫 입력한 도서가 존재하지 않습니다.");
			}
			
		} else {
			System.out.println("=> 장바구니에 담은 상품이 없습니다.");
		}

		// 메인메뉴 호출!
		bms.showMenu();
		bms.selectMenu();
	}
	
	@Override
	public void delete_all() {
		// 정말로 삭제 진행 여부 확인!
		System.out.print("참말로 전부 삭제하시겠습니까? (y:삭제, 아무키:삭제취소) > ");
		if(scan.next().equals("y")) {
			cartRep.removeAll();
			System.out.println("✅장바구니를 모두 비웠습니다.");
		} else {
			// 메인메뉴 호출!
			bms.selectMenu();
		}
		
		// 메인메뉴 호출!
		bms.showMenu();
		bms.selectMenu();
	}
	
	@Override
	public void receipt() {
		List<CartVo> cartList = cartRep.findAll();
		if(cartList.size() != 0) {
			System.out.print("=> 배송받을 분은 고객정보와 같습니까? (y:진행, 아무키:재입력) > ");
			if(scan.next().equals("y")) {
				money = 0;
				CartVo cart = new CartVo();
				cartRep.update(cart);
				MemberVo m = memberRep.find(mid);
				cart = cartRep.find(cartList.get(0).getBid());
				System.out.println("-------------------배송 받을 고객 정보-----------------");
				System.out.println("고객명 : " + m.getName() + "\t\t연락처 : " + m.getPhone());
				System.out.println("배송지 : " + m.getAddr() + "\t발송일 : " + cart.getDelivery());
				System.out.println("장바구니 상품 목록 : ");
				System.out.println("-------------------------------------------------");
				System.out.println("	도서ID	|	수량	|	합계	");
				System.out.println("-------------------------------------------------");
				cartList.forEach((c) -> {
					System.out.print(c.getBid() + "	|	"); 
					System.out.print(c.getCnt() + "	|	"); 
					System.out.print(c.getTotPrice() + "	\n"); 
					money += c.getTotPrice();
				});
				System.out.println("-------------------------------------------------");
				System.out.println("\t\t\t\t주문 총 금액 : " + money);
				
			} else {
				money = 0;
				MemberVo member = new MemberVo();
				member.setMid(mid);
				System.out.print("배송받을 고객명을 입력하세요. > ");
				member.setName(scan.next());
				System.out.print("배송받을 고객의 연락처를 입력하세요. > ");
				member.setPhone(scan.next());
				System.out.print("배송받을 고객의 배송지를 입력하세요. > ");
				scan.nextLine();
				member.setAddr(scan.nextLine());				
				
				memberRep.update(member);
				
				CartVo cart = new CartVo();
				cartRep.update(cart);
				MemberVo m = memberRep.find(mid);
				cart = cartRep.find(cartList.get(0).getBid());
				System.out.println("-------------------배송 받을 고객 정보-----------------");
				System.out.println("고객명 : " + m.getName() + "\t\t연락처 : " + m.getPhone());
				System.out.println("배송지 : " + m.getAddr() + "\t발송일 : " + cart.getDelivery());
				System.out.println("장바구니 상품 목록 : ");
				System.out.println("-------------------------------------------------");
				System.out.println("	도서ID	|	수량	|	합계	");
				System.out.println("-------------------------------------------------");
				cartList.forEach((c) -> {
					System.out.print(c.getBid() + "	|	"); 
					System.out.print(c.getCnt() + "	|	"); 
					System.out.print(c.getTotPrice() + "	\n"); 
					money += c.getTotPrice();
				});
				System.out.println("-------------------------------------------------");
				System.out.println("\t\t\t\t주문 총 금액 : " + money);
			}

		} else {
			System.out.println("=> 장바구니에 담은 상품이 없습니다.");
		}

		// 메인메뉴 호출!
		bms.showMenu();
		bms.selectMenu();
	}
	
	@Override
	public void exit() {
		System.out.println("-- 프로그램이 종료됩니다. --");
		memberRep.close();
		bookRep.close();
		cartRep.close();
		System.exit(0);
	}
}
