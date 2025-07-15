package zoopractice;

import java.util.ArrayList;
import java.util.List;

public class ZooTest {
	
	public static void main(String[] args) {
		Lion lion = new Lion("심바마더", 20);
		Tiger tiger = new Tiger("호돌이파더", 30);
		
		List<Lion> list = new ArrayList<Lion>();
		List<AnimalInterface> list2 = new ArrayList<AnimalInterface>();
		
		lion.sleep();
		lion.eat();
		tiger.sleep();
		tiger.eat();
		
		list.add(lion);
//		list.add(tiger); // list는 Lion 클래스 객체만 저장 가능
		
		list2.add(lion);	// interface로 생성한 경우 둘 다 가능!
		list2.add(tiger);	// interface로 생성한 경우 둘 다 가능!

		System.out.println(list2.get(0).getAge());
		System.out.println(list2.get(1).getName());
		
		
	}

}
