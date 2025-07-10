package chapter07;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Singleton singleton = new Singleton();	// 기본생성자가 private로 접근 제어 됨
		Singleton singleton = Singleton.getInstance();	
		
		singleton.setName("싱글톤");
		System.out.println("name : " + singleton.getName());
	}

}
