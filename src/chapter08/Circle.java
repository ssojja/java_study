package chapter08;

public class Circle extends Shape implements ShapeInterface {	// 자바는 단일상속만 가능하며, 상속은 클래스만 가능 
	// Field
//	String color;
	int radius;
	public static final double PI = 3.14;
	
	// Constructor
	public Circle(String color, int radius) {
		super(color);
//		this.color = color;
		this.radius = radius;
	}
	
	// Method
	@Override
	public void draw() {
		System.out.println(color + "원을 그린다.");
	};
	
	@Override
	public double getArea() {
		return PI * radius * radius;
	};
}
