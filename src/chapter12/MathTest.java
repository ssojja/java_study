package chapter12;

public class MathTest {
	
	public static void main(String[] args) {
		// java.lang : 자주 사용되는 클래스들의 그룹으로 import를 하지 않아도 사용 가능
		// 모든 메소드가 static으로 정의되어 있음 : 클래스명.메소드명()
		System.out.println(Math.abs(-100));	// 절대값
		System.out.println(Math.floor(123.4567));	// 소수점 절삭
		System.out.println(Math.max(100, 200));
		System.out.println(Math.min(100, 200));
		System.out.println(Math.random());
		System.out.println((int)Math.floor(Math.random() * 100));	// 정수 2자리 랜덤
		System.out.println(Math.round(123.567));
	}

}
