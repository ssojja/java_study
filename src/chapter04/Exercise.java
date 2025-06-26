package chapter04;

public class Exercise {

	public static void main(String[] args) {
		// 연습문제1
		int var = 7 - 1 * 20 / 5;
		System.out.println("연습문제 1 답안 : " + var); 	// 3
		System.out.println();
		
		// 연습문제2
		int colorPen = 5 * 12;
		int studentCount = 27;
		int divColorPen = colorPen / studentCount;
		System.out.println("학생당 나눠가지는 색연필수 : " + divColorPen);
		
		int remainColorPen = colorPen % studentCount;
		System.out.println("똑같이 나눠가지고 남은 색연필수 : " + remainColorPen);
		System.out.println();
		
		// 연습문제3
		// (1) 연도를 4로 나누어 떨어지면 윤년, (2) 100으로 나누어 떨어지는 연도는 윤년이 아님, (3) 400으로 나누어 떨어지면 윤년
		int year = 2020;
		boolean leapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ;
		
		// 윤년이면 true, 윤년이 아니면 false
		System.out.println(leapYear);
		
		// 연습문제4
		// 지불해야할 금액이 187,000원인데 5만원권과 1만원권, 5천원권, 1천원권 지폐를 가장 적은 지폐수량으로 지불하는 코드를 작성하시오.
		int price = 187000;
		int oman = price / 50000;
		int ilman = price % 50000 / 10000;
		int ochun = price % 10000 / 5000;
		int ilchun = price % 5000 / 1000;
		
		System.out.println("5만원권 : " + oman + "장");
		System.out.println("1만원권 : " + ilman + "장");
		System.out.println("5천원권 : " + ochun + "장");
		System.out.println("1천원권 : " + ilchun + "장");
		
	}

}
