package chapter04;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		// 놀이기구 탑승 전 체크사항
		// 1. 6세 이상 탑승 가능(단, 6세 이하는 키가 120cm 이상이고 보호자 동반하에 탑승가능)
		// 2. 키 120cm 이상 탑승 가능
		// 3. 심장질환자는 탑승 불가
		String name = "";
		int age, height = 0;
		boolean parent = false;
		boolean dease = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("******************************");
		System.out.println("놀이기구 탑승 전 유의사항 및 체크");
		System.out.println("******************************");
		
		System.out.println();
		System.out.print("이름 > ");
		name = scan.next();
		
		System.out.print("나이 > ");
		age = scan.nextInt();
		
		System.out.print("키 > ");
		height = scan.nextInt();
		
		System.out.print("보호자 동반 여부 (y:1 / n:0) > ");
		parent = scan.nextInt() == 1 ? true : false;
		
		System.out.print("심장질환 유무 (유:1 / 무:0) > ");
		dease = scan.nextInt() == 1 ? true : false;
		
		System.out.println();
		System.out.println(name + ", " +age + ", " +height + ", " +parent + ", " +dease);
		
		String result = (((age >= 6) && (height >= 120)) || ((age < 6) && (height >= 120) && (parent == true))) 
				&& (dease == false) ? "탑승 가능" : "탑승 불가능";
		
		System.out.println();
		System.out.println("result : " + result);
		
	}

}
