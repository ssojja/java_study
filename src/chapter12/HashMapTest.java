package chapter12;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap map = new HashMap();	// 타입 지정없이 선언
		// key,value 모두 String 타입으로 생성
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		map.put("name", "홍길동");
		map.put("age", 10);
		map.put("scan", new Scanner(System.in));
		
		System.out.println("map.keySet() -> " + map.keySet());
		System.out.println("map.entrySet() -> " + map.entrySet());
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("scan"));

		map2.put("name","hong");
		map2.put("age","10");
		System.out.println(map2.get("name"));
		System.out.println(map2.get("age"));
	}

}
