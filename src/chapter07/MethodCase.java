package chapter07;

/*
<<리턴타입과 매개변수에 따른 메소드 정의 예>>
	(1) 리턴타입 X, 매개변수 X
	(2) 리턴타입 O, 매개변수 X
	(3) 리턴타입 X, 매개변수 O
	(4) 리턴타입 O, 매개변수 O
 * */

public class MethodCase {
	// Field
	// Constructor
	public MethodCase() {
		System.out.println("MethodCase 객체 생성해벌임!");
	}
	
	// Method
	// (1) 리턴타입 X, 매개변수 X
	public void method1() {
		System.out.println("method1 --> 리턴타입 X, 매개변수 X");
	}
	
	public int method2() {
		int num1 = 10;
		int num2 = 20;
		return num1 + num2;
	}
	
	public void method3(int num1, int num2) {
		System.out.println("method3 --> " + (num1 + num2));
	}
	
	public void method3(String name) {
		System.out.println("method3 --> " + name);
	}
	
	public int method4(int num1, int num2) {
		return num1 + num2;
	}
	
	public String method4(String name) {
		return name;
	}
	
	
	// main method
	public static void main(String[] args) {
		MethodCase mc = new MethodCase();
		
		mc.method1();
		int sum = mc.method2();	// 반복실행 시 변수에 담아 활용
		
		System.out.println("method2 --> " + sum);
		System.out.println("method2 --> " + sum + " (리턴타입 O, 매개변수 X)"); 
		
		mc.method3("홍길동");
		mc.method3(10, 20);
		
		System.out.println("method4 --> " + mc.method4("홍길동"));
		System.out.println("method4 --> " + mc.method4(10, 20));		
	}

}
