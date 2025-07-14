package chapter08;

public class Shape {
	String color;
	
	// protected : 자식 클래스에서만 생성자 접근 가능하게 함!
	protected Shape(String color) {	
		this.color = color;
	}

}
