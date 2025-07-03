package chapter07;

public class ScoreMgmSystemTest {

	public static void main(String[] args) {
		ScoreMgmSystem tjsms = new ScoreMgmSystem();
		Student student = new Student();
		
		tjsms.insert();
		tjsms.show();
		System.out.println("-- 프로그램 종료 --");
	}

}
