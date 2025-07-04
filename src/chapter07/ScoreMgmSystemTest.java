package chapter07;

public class ScoreMgmSystemTest {

	public static void main(String[] args) {
		ScoreMgmSystem tjsms = new ScoreMgmSystem();
		Student student = new Student();
		
		tjsms.showMenu();	// 메뉴정보
		
		System.out.println("-- main 종료 --");
	}

}
