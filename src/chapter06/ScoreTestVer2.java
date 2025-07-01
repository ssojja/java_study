package chapter06;

import java.util.Scanner;

/*
 * 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
 * - 과목은 국어, 영어, 수학 3과목의 점수를 입력
 * - 입력받은 과목의 총점과 평균을 구함
 * - 학생 이름, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * - 입·출력을 위해서 각 배열의 주소를 통일시킨다.
 * 
 * 프로그래밍 방식 : 구조적(Structured) 방식, 객체지향적(Object Oriented) 방식
 * */
public class ScoreTestVer2 {

	public static void main(String[] args) {
		System.out.println("-------------------------------------------");
		System.out.println("\t더조은 고등학교 1-1 성적관리 프로그램");
		System.out.println("-------------------------------------------");
		
		// step 1 : 배열 선언
		Scanner scan = new Scanner(System.in);
		System.out.print("입력할 학생 수는 ? ");
		final int MAX_SIZE = scan.nextInt(); // 상수인 경우, final을 붙이고 상수명은 대문자로!!
	
		String[] nameList = new String[MAX_SIZE];
		int[] korList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
		
		// step 2 : 데이터 입력 - 실행 시 외부에서 입력
		for(int i = 0; i < nameList.length; i++) {
			System.out.print("학생 이름 > ");
			nameList[i] = scan.next();

			System.out.print("국어 점수 > ");
			korList[i] = scan.nextInt();
			
			System.out.print("영어 점수 > ");
			engList[i] = scan.nextInt();
			
			System.out.print("수학 점수 > ");
			mathList[i] = scan.nextInt();

			totList[i] = korList[i] + engList[i] + mathList[i];	// 총점
			avgList[i] = totList[i] / 3; 						// 평균
			
			System.out.print("계속 입력 하시겠습니까(계속:아무키나 누르세요, 종료:n) > ");
			if(scan.next().equals("n")) {	// 객체로 생성된 값을 비교할 때, '==' 이 아닌 equals이 사용됨
				i = nameList.length; // break;
			}
			
		}
		
		
		// step 3 : 데이터 출력
		System.out.println("-------------------------------------------");
		System.out.println("학생이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------");
		for(int i = 0; i < nameList.length; i++) {
			
			// 이름이 null이 아닌 경우에만 출력
			if(nameList[i] != null) {
				System.out.print(nameList[i] + "\t");
				System.out.print(korList[i] + "\t");
				System.out.print(engList[i] + "\t");
				System.out.print(mathList[i] + "\t");
				System.out.print(totList[i] + "\t");
				System.out.print(avgList[i] + "\n");
			}
		}
		System.out.println("-------------------------------------------");
		
		// step 4 : 데이터 조회
		// 조회할 학생명 입력
		boolean searchFlag = true;
		while(searchFlag) {
			
			System.out.print("\n학생명 검색 > ");
			String searchName = scan.next();
			
			// nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다.
			int searchIdx = -1;
			int count = 0;
			for(String name : nameList) {
				if(name != null) {
					if(name.equals(searchName)) searchIdx = count;
					count++;
				}
			}
			
			if(searchIdx != -1) {System.out.println("검색결과 주소 : " + searchIdx);}
			else {System.out.println("해당 학생 결과가 없습니다.\n");}
			
			// step 5 : 데이터 조회 결과 출력
			if(searchIdx != -1) {				
				System.out.println("\n-------------------------------------------");
				System.out.println("학생이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println("-------------------------------------------");
				
				System.out.print(nameList[searchIdx] + "\t");
				System.out.print(korList[searchIdx] + "\t");
				System.out.print(engList[searchIdx] + "\t");
				System.out.print(mathList[searchIdx] + "\t");
				System.out.print(totList[searchIdx] + "\t");
				System.out.print(avgList[searchIdx] + "\n");
				System.out.println("-------------------------------------------");
			}
			
			System.out.print("학생을 더 검색하시겠습니까? (계속:아무키나 누르세요, 종료:n) > ");
			if(scan.next().equals("n")) {
				searchFlag = false;
			}
		}
		
		System.out.println("-- 프로그램이 종료되었습니다. --");

	} // main

} // class
