package chapter08;

public class Triangle extends Shape implements ShapeInterface{
	// Field
//	String color;
	int width;
	int height;
	
	// Constructor
	public Triangle(String color, int width, int height) {
		super(color);
//		this.color = color;
		this.width = width;
		this.height = height;
	}
	
	// Method
	@Override
	public void draw() {
		System.out.println(color + "삼각형을 그린다.");
	};
	
	@Override
	public double getArea() {
		return width * height / 2;
	};
}
