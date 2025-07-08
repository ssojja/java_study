package lunch;

public class LunchOrderSystemOOPTest {
	
	public static void main(String[] args) {
		LunchOrderSystemOOP system = new LunchOrderSystemOOP();
		system.title = "더조은";
		system.menuManager.showMainMenu();	// 같은 pacakage에서는 import 필요없음 ,,
		
		// 생성자를 객체 초기화 후 실행 메소드를 호출하는 경우
//		new LunchOrderSystemOOP("Happy");
	}

}
