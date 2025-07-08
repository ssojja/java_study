package drink;

public class Order {
	// Field
	Menu orderMenu;
	
	// Constructor
	public Order() {}
	public Order(Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	// Method
	public String getName() {
		return orderMenu.name;
	}
	
	public int getTotal() {
		return orderMenu.price;
	}
	
	public void getInfo() {
		String price = String.format("%,d", orderMenu.price);
		System.out.println("=> 주문 메뉴 : " + orderMenu.name + ", 결제 예정 금액 : " + price + "원");
	}

}
