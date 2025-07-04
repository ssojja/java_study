package chapter07;

public class ArithmeticTest {
	
	public static void main(String[] args) {
		
		Arithmetic arithmetic = new Arithmetic();
		ArithmeticOverloading arithmetic_o1 = new ArithmeticOverloading();
		
		System.out.println("arithmetic_o1.add = " + arithmetic_o1.add(10, 20));
		System.out.println("arithmetic_o1.add = " + arithmetic_o1.add(3.14, 1.5));
		System.out.println("arithmetic_o1.add = " + arithmetic_o1.add("100", "200"));
		System.out.println("arithmetic_o1.add = " + arithmetic_o1.add(1,2,3,4,5,6,7,8,9,10));
		System.out.println("arithmetic_o1.add = " + arithmetic_o1.add("1", "2", "3"));
		
		
		System.out.println("------------------------");
		int add = arithmetic.add(10.5, 10.5);
		int sub = arithmetic.sub(100, 10);
		double mul = arithmetic.mul(3.14, 10);	// 결과는 실수값
		int div = arithmetic.div(10, 20);
		int mod = arithmetic.mod(10, 20);
		
		System.out.println("add = " + add);
		System.out.println("sub = " + sub);
		System.out.println("mul = " + mul);
		System.out.println("div = " + div);
		System.out.println("mod = " + mod );		
		
	}

}
