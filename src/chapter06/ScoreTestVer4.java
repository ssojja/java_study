package chapter06;

import java.util.Scanner;

/*
 * - 2차원 배열 구조로 수정함
 * - 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
 * - 과목은 국어, 영어, 수학 3과목의 점수를 입력
 * - 입력받은 과목의 총점과 평균을 구함
 * - 학생 이름, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * - 입·출력을 위해서 각 배열의 주소를 통일시킨다.
 * - 학생 성적 수정 메뉴를 추가한다. (검색 + 등록)
 * - 학생명 및 점수 삭제 메뉴를 추가한다. (검색 + 삭제)
 * 
 * 프로그래밍 방식 : 구조적(Structured) 방식, 객체지향적(Object Oriented) 방식
 * */
public class ScoreTestVer4 {

	public static void main(String[] args) {
		System.out.println("-------------------------------------------");
		System.out.println("더조은 고등학교 성적관리 프로그램");
		System.out.println("-------------------------------------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 리스트 출력");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 학생 성적 수정");
		System.out.println("5. 학생 삭제");		
		System.out.println("9. 프로그램 종료");		
		System.out.println("-------------------------------------------");
		
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		boolean menuFlag = true;
		
		System.out.print("입력할 학생 수는 ? ");
		final int MAX_SIZE = scan.nextInt(); // 상수인 경우, final을 붙이고 상수명은 대문자로!!
	
		String[] nameList = new String[MAX_SIZE];
		int[][] scoreList = new int[MAX_SIZE][];		

		int count = 0;		// 등록된 학생 수
		
		while(menuFlag) {
			System.out.print("메뉴선택(숫자) > ");
			menu = scan.nextInt();
			String[] subjectList = {"국어", "영어", "수학"};
			int tot = 0;	// 메뉴1, 4 공용으로 사용하는 변수이므로, 단계별 초기화 필요!!
			int avg = 0;
			
			if(menu == 1) {	// 학생 등록
				if(count == nameList.length) System.out.println("학생이 모두 등록되었습니다.");
				for(int i = count; i < nameList.length; i++) {
					System.out.print("학생 이름 > ");
					nameList[i] = scan.next();

					// 학생의 점수를 입력할 배열을 생성함
					scoreList[i] = new int[5];
					tot = 0; avg = 0;
					for(int j = 0; j < subjectList.length; j++) {
						System.out.print(subjectList[j] + " 점수 > ");
						scoreList[i][j] = scan.nextInt();
						tot += scoreList[i][j];
						avg = tot/3;
					}
					
					scoreList[i][scoreList[i].length-2] = tot;	// 총점
					scoreList[i][scoreList[i].length-1] = avg; 	// 평균
					
					count++; // 등록된 학생 수 저장
					
					
					if(count == nameList.length) {
						System.out.println("=> 저장공간 부족, 추가 등록 기능이 종료됩니다.");
					} else {
						System.out.print("계속 등록 하시겠습니까(계속:아무키나 누르세요, 종료:n) > ");
						if(scan.next().equals("n")) {	// 객체로 생성된 값을 비교할 때, '==' 이 아닌 equals이 사용됨
							i = nameList.length; // break;
							System.out.println("=> 등록이 완료되었습니다!! ");
						}						
					}
					
				} // for
			} else if(menu == 2){	// 학생 리스트 출력
				if(count != 0) {	// nameList[i] != null
					// step 3 : 데이터 출력
					System.out.println("-------------------------------------------");
					System.out.println("학생이름\t국어\t영어\t수학\t총점\t평균");
					System.out.println("-------------------------------------------");
					for(int i = 0; i < count; i++) {
						// 이름이 null이 아닌 경우에만 출력
						if(nameList[i] != null) {
							System.out.print(nameList[i] + "\t");
							for(int j = 0; j < scoreList[i].length; j++) {
								System.out.print(scoreList[i][j] + "\t");
							}
							System.out.println();
						}
					}
					System.out.println("-------------------------------------------");
					
				} else{
					System.out.println("=> 등록된 데이터가 없습니다. 등록을 먼저 진행해주세요.");
				}
				
			} else if(menu == 3){	// 학생 성적 검색
				
				if(count != 0) {
					// 조회할 학생명 입력
					boolean searchFlag = true;
					while(searchFlag) {
						
						System.out.print("학생명 검색 > ");
						String searchName = scan.next();
						
						// nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다.
						int searchIdx = -1;
						int countIdx = 0;
						for(String name : nameList) {
							if(name != null) {
								if(name.equals(searchName)) searchIdx = countIdx;
								countIdx++;
							}
						}
						
						// step 5 : 데이터 조회 결과 출력
						if(searchIdx != -1) {
							System.out.println("검색결과 주소 : " + searchIdx);
							
							System.out.println("-------------------------------------------");
							System.out.println("학생이름\t국어\t영어\t수학\t총점\t평균");
							System.out.println("-------------------------------------------");
							System.out.print(nameList[searchIdx] + "\t");

							for(int i = 0; i < scoreList[searchIdx].length; i++) {
								System.out.print(scoreList[searchIdx][i] + "\t");
							}
							
//							for(int score : scoreList[searchIdx]) { // 확장 for문
//								System.out.print(score + "\t");
//							}

							System.out.println("\n-------------------------------------------");
							
							System.out.print("학생을 더 검색하시겠습니까? (계속:아무키나 누르세요, 종료:n) > ");
							if(scan.next().equals("n")) {
								searchFlag = false;
							}
						} else {
							System.out.println("=> 검색한 학생이 존재하지 않습니다.\n");
						}
						
					}
				} else {					
					System.out.println("=> 등록된 데이터가 없습니다. 등록을 먼저 진행해주세요.");
				}
				
			} else if(menu == 4){	// 학생 성적 수정
				if(count != 0) {
					boolean modiFlag = true;
					
					while(modiFlag) {
						
						System.out.print("[수정]학생명 검색 > ");
						String modifiedName = scan.next();
						
						int modiIdx = -1;
						for(int i = 0; i < count; i++) {
							if(nameList[i].equals(modifiedName)) modiIdx = i;
						}
						
						if(modiIdx != -1) {
							
							scoreList[modiIdx] = new int[5];
							tot = 0; avg = 0;
							for(int j = 0; j < subjectList.length; j++) {
								System.out.print(subjectList[j] + " 점수 > ");
								scoreList[modiIdx][j] = scan.nextInt();
								tot += scoreList[modiIdx][j];
								avg = tot/3;
							}

							scoreList[modiIdx][scoreList[modiIdx].length-2] = tot;	// 총점
							scoreList[modiIdx][scoreList[modiIdx].length-1] = avg; 	// 평균
							
							
							System.out.println("=> 수정 완료되었습니다.");
							
							System.out.println("\n-------------------------------------------");
							System.out.println("학생이름\t국어\t영어\t수학\t총점\t평균");
							System.out.println("-------------------------------------------");
							for(int score : scoreList[modiIdx]) {
								System.out.print(score + "\t");
							}
							System.out.println("-------------------------------------------");
							
							System.out.print("계속 수정 하시겠습니까(계속:아무키나 누르세요, 종료:n) ? > ");
							if(scan.next().equals("n")) {	
								modiFlag = false;
							}	
							
						} else {
							System.out.println("=> 수정할 학생 데이터가 존재하지 않습니다. 다시 입력해주세요.");
						}
						
					}
					
				} else {
					System.out.println("=> 등록된 데이터가 없습니다. 등록을 먼저 진행해주세요.");
				}
				
				
			} else if(menu == 5) { // 학생 삭제
				if(count != 0) {
					boolean deleteFlag = true;
					
					while(deleteFlag) {
						System.out.print("[삭제]학생명 검색 > ");
						String deleteName = scan.next();
						
						int deleteIdx = -1;
						for(int i = 0; i < count; i++) {
							if(nameList[i].equals(deleteName)) deleteIdx = i;
						}
						
						if(deleteIdx != -1) {
							
							for(int i = deleteIdx; i < count-1; i++) {
								nameList[i] = nameList[i+1];
								scoreList[i] = scoreList[i+1];
							}
							
							count--;
							System.out.println("=> 삭제 완료되었습니다.");
							System.out.print("계속 삭제 하시겠습니까(계속:아무키나 누르세요, 종료:n) ? > ");
							if(scan.next().equals("n")) {	
								deleteFlag = false;
							}
							
						} else {
							System.out.println("=> 삭제할 학생 데이터가 존재하지 않습니다. 다시 입력해주세요.");
						}
			
					} // while-deleteFlag
					
				} else {
					System.out.println("=> 등록된 데이터가 없습니다. 등록을 먼저 진행해주세요.");
				} 
				
			} else if(menu == 9){	// 프로그램 종료
				System.out.println("-- 프로그램 종료 --");
				System.exit(0);
				
			} else {
				System.out.println("메뉴 준비중입니다.");
			}
			
//			System.out.print("계속 진행 하시겠습니까(계속:아무키나 누르세요, 종료:n) > ");
//			if(scan.next().equals("n")) {	// 객체로 생성된 값을 비교할 때, '==' 이 아닌 equals이 사용됨
//				menuFlag = false;
//			}
		}
		System.out.println("-- 프로그램 종료 --");

	}

}
