package drink;

public class DrinkOrder {
	// Field
	int no;			// 음료 번호
	String name;	// 선택한 음료
	int price;		// 음료 가격
	int qty; 		// 수량
	
	
	// Constructor
	
	// Method
	public int getTot() {	// 합계 계산
		return price*qty;
	}

}
