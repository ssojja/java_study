package chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("홍길동");
		list2.add(String.valueOf(123));
		
		list2.set(0, "이순신");
		list2.add(1, "김유신");
		list2.remove(2);
		
		for(String str : list2) {
			System.out.println("str : " + str);
		}		
		
		System.out.println(list.size());	// 채워진 공간 수 만큼 add할 수 있음
		list.add(100);
		list.add(new String("홍길동"));
		list.add(123.456);
		list.add(new Scanner(System.in));
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
	}

}
