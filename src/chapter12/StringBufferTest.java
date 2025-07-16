package chapter12;

public class StringBufferTest {

	public static void main(String[] args) {
		String str = "홍길동";
		str = str + "은 자바를";	// 접합연산자로 인해 객체가 새로 생성되면서 더해짐..
		str = str + " 열심히 공부한다.";
		System.out.println(str);
		
		StringBuffer sb = new StringBuffer();
		System.out.println("StringBuffer 기본 크기 : " + sb.capacity());
		sb.append("홍길동");
		sb.append("은 자바를");
		sb.append(" 열심히 공부한다.");
		System.out.println("문자열 추가 후 크기 : " + sb.capacity());
		System.out.println(sb.toString());
		System.out.println(sb);
	}

}
