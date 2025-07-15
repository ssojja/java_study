package chapter08;

public class ObjectTypeCasting {

	public static void main(String[] args) {
		Circle yellowC = new Circle("노랑", 1);
		Rectangle blueR = new Rectangle("파란", 1, 2);
//		Rectangle t = new Circle("초록색", 2);	// 자식 클래스끼리는 독립적임!

		Shape s = new Circle("초록색", 2);	// 자식 클래스에서 부모 정보를 가지고 있기에 가능함, 자동(묵시적) 형변환
		Circle cs = (Circle)s;	// 강제(명시적) 형변환 O
		
		Shape s2 = new Shape("빨강");
//		Circle cs2 = (Circle)s2;	// 강제(명시적) 형변환 X
		
		// 인터페이스를 통해 자식의 모습으로 객체를 구현하는 것을 권장함!
		ShapeInterface si = new Circle("코랄", 1);
		si.draw();	// 자식인 Circle의 draw() 호출됨
		System.out.println(si.getArea());
		System.out.println();
		
		Circle cs3 = (Circle)si;
		cs3.draw();// 자식인 Circle의 draw() 호출됨
		System.out.println(cs3.getArea());
		System.out.println();
		
		// 상속받은 인터페이스 통한 객체 생성
		// 사각형, 삼각형
		ShapeInterface sRec = new Rectangle("녹색", 1, 2);
//		  (추상메소드) -- 다형성 구현 --  (상속받아 오버라이딩)
		sRec.draw();
		System.out.println("sRec의 넓이 : " + sRec.getArea());
		
		ShapeInterface sTri = new Triangle("주황색", 1, 2);
		sTri.draw();
		System.out.println("sTri의 넓이 : " + sTri.getArea());
		
		
		
		System.out.println();
		cs.draw();
//		cs2.draw();
		
		yellowC.draw();
		blueR.draw();
//		s.draw();	// Shape 클래스는 draw() 메소드를 정의하지 않음
		System.out.println(s.color);
	}

}
