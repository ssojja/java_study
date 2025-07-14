package chapter08;

public class InheritanceTest2 {

	public static void main(String[] args) {
		Circle redC = new Circle("빨강색", 12);
		Circle blueC = new Circle("파란색", 3);
		Rectangle yellowR = new Rectangle("노란색", 5, 6);
		Rectangle greenR = new Rectangle("초록색", 5, 6);
		Triangle orangeT = new Triangle("주황색", 5, 6);
		
		redC.draw();
		System.out.println("원의 넓이 : " + redC.getArea());
		yellowR.draw();
		System.out.println("사각형의 넓이 : " + yellowR.getArea());
		orangeT.draw();
		System.out.println("삼각형의 넓이 : " + orangeT.getArea());
	}

}
