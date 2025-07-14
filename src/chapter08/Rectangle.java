package chapter08;

public class Rectangle extends Shape implements ShapeInterface{
	// Field
//	String color;
	int width;
	int height;
	
	// Constructor
	public Rectangle(String color, int width, int height) {
		super(color);
//		this.color = color;
		this.width = width;
		this.height = height;
	}
	
	// Method
	@Override
	public void draw() {
		System.out.println(color + "사각형을 그린다.");
	};	
	
	@Override
	public double getArea() {
		return width * height;	// 묵시적 형변환
	};
}
