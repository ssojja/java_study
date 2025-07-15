package drink_interface;

public class Payment {
	// Field
	int amount;
	int change;
	
	// Constructor
	public Payment() {}
	
	// Method
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount += amount;
	}
	
	public int getChange() {
		return change;
	}
	
	public boolean getPayment(int total) {
		boolean result = false;
		if(amount >= total) {
			change = amount - total;
			result = true;
		}
		
		return result;
	}
	
}
