package chapter07;

import java.util.Scanner;

/*
 * - 학생 3명의 점수를 입력받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 받는다.
 * 
 * */
public class ScoreMgmSystem {
	// Field
	String admin;
	Student student = new Student();
	Scanner scan = new Scanner(System.in);
	Student[] sList = new Student[10];
	int count = 0;
	
	// Constructor
	public ScoreMgmSystem() {}
	
	// Method 등록(insert), 검색(search), 수정(update), 삭제(remove)
	/*
	 * 메뉴 선택
	 * */
	public void showMenu() {
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
		
		System.out.print("메뉴 선택(숫자) > ");
		menuCheck(scan.nextInt());
	}
	
	/*
	 * 선택한 메뉴를 체크하여 기능별 메소드 호출
	 * */
	public void menuCheck(int menu) {
		switch (menu) {
			case 1: 
				insert();
				showMenu();	// 재귀호출
				break;
			case 2: 
				showList();
				showMenu();	// 재귀호출
				break;
			case 3: 
				search();	
				showMenu();	// 재귀호출
				break;
			case 4: 
				update();	
				showMenu();	// 재귀호출
				break;
			case 5: 
				remove();	
				showMenu();	// 재귀호출
				break;
			case 9: 
				System.out.println("-- 성적관리 시스템 종료 --");
				System.exit(0);
				break;
			default:
				System.out.println("=> 메뉴 준비중입니다.");
				showMenu();
				break;
		}
	}
	
	public void insert() {	
		System.out.println("=> 학생 정보를 등록하세요.");
		sList[count] = new Student();

		System.out.print("학생명 > ");
		sList[count].name = scan.next();
		
		System.out.print("국어 점수 > ");
		sList[count].kor = scan.nextInt();
		
		System.out.print("영어 점수 > ");
		sList[count].eng = scan.nextInt();
		
		System.out.print("수학 점수 > ");
		sList[count].math = scan.nextInt();
		
		count++;		
		System.out.println("=> 등록 완료!!");
		
		System.out.print("계속 등록하시겠습니까? (계속:아무키나 누르세요, 종료:n) > ");
		if(scan.next().equals("n")) {
			showMenu();
		} else {
			insert();
		}
		
	}
	
	public void showList() {
		if(count != 0) {
			System.out.println("-------------------------------------------");
			System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
			System.out.println("-------------------------------------------");
			for(Student student : sList) {
				if(student != null) {
					System.out.print(student.name + "\t");
					System.out.print(student.kor + "\t");
					System.out.print(student.eng + "\t");
					System.out.print(student.math + "\t");
					System.out.print(student.getTot() + "\t");
					System.out.print(student.getAvg() + "\n");
				} else {
					break;
				}
			}
			System.out.println("-------------------------------------------");			
		} else {
			System.out.println("=> 등록된 데이터 없음, 등록부터 진행해주세요.");
		}
		
	}
	
	// 학생명을 검색하여 주소를 리턴하는 메소드
	public int searchIndex(String pName) {
		System.out.print("=>" + pName + "학생명 검색 > ");
		String searchNanme = scan.next();
		
		int searchIdx = -1;
		for(int i = 0; i < count; i++) {
			Student student = sList[i];
			if(student.name.equals(searchNanme)) searchIdx = i;
		}
		return searchIdx;
	}
	
	
	public void search() {
		if(count != 0) {
			int searchIdx = searchIndex("[검색]");
			
			if(searchIdx != -1) {
				System.out.println("-------------------------------------------");
				System.out.println("\t\t검색 결과");
				listPrint(searchIdx);
				
				System.out.print("학생을 더 검색하시겠습니까? (계속:아무키나 누르세요, 종료:n) > ");
				if(scan.next().equals("n")) showMenu();
				else search();

			} else {
				System.out.println("=> 검색한 학생이 존재하지 않습니다.\n");
				
				System.out.print("학생을 더 검색하시겠습니까? (계속:아무키나 누르세요, 종료:n) > ");
				if(scan.next().equals("n")) showMenu();
				else search();
			}
			
		} else {
			System.out.println("=> 등록된 데이터 없음, 등록부터 진행해주세요.");
		}
	}

	public void update() {
		if(count != 0) {
			int modiIdx = searchIndex("[수정]");

			if(modiIdx == -1) {
				System.out.println("=> 수정할 학생 데이터가 존재하지 않습니다.");
				System.out.print("계속 수정 하시겠습니까(계속:아무키나 누르세요, 종료:n) ? > ");
				if(scan.next().equals("n")) showMenu();					
				else update();
				
			} else {
//				String oldName = sList[modiIdx].name;	// 중요!!!!!!!!!! 새로 생성된 객체에 학생명 복사
//				sList[modiIdx] = new Student();
//				sList[modiIdx].name = oldName;
				
				System.out.print("국어 점수 > ");
				sList[modiIdx].kor = scan.nextInt();
				
				System.out.print("영어 점수 > ");
				sList[modiIdx].eng = scan.nextInt();
				
				System.out.print("수학 점수 > ");
				sList[modiIdx].math = scan.nextInt();
				
				System.out.println("=> 수정 완료되었습니다.");
				System.out.println("-------------------------------------------");
				System.out.println("\t\t수정 결과");
				listPrint(modiIdx);
				
				System.out.print("계속 수정 하시겠습니까(계속:아무키나 누르세요, 종료:n) ? > ");
				if(scan.next().equals("n")) showMenu();					
				else update();
			}
		
		} else {
			System.out.println("=> 등록된 데이터 없음, 등록부터 진행해주세요.");
		}
	}
	
	public void remove() {
		if(count != 0) {
			int deleteIdx = searchIndex("[삭제]");
			
			if(deleteIdx != -1) {
				
				for(int i = deleteIdx; i < count-1; i++) {
					sList[i] = sList[i+1];
				}
				
				// 출력 함수에서 조건이 count가 아닌 null로 체크하기 때문에 마지막 주소 지워줘야함!
				sList[count-1] = null;
				count--;
				
				System.out.println("=> 삭제 완료되었습니다.");
				System.out.print("계속 삭제 하시겠습니까(계속:아무키나 누르세요, 종료:n) ? > ");
				if(scan.next().equals("n")) showMenu();
				else remove();
				
				
			} else {
				System.out.println("=> 삭제할 학생 데이터가 존재하지 않습니다.");
				System.out.print("계속 삭제 하시겠습니까(계속:아무키나 누르세요, 종료:n) ? > ");
				if(scan.next().equals("n")) showMenu();
				else remove();
			}

		} else {
			System.out.println("=> 등록된 데이터 없음, 등록부터 진행해주세요.");
		}
	}
	
	public void listPrint(int idx) {
		System.out.println("-------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------");
		System.out.print(sList[idx].name + "\t");
		System.out.print(sList[idx].kor + "\t");
		System.out.print(sList[idx].eng + "\t");
		System.out.print(sList[idx].math + "\t");
		System.out.print(sList[idx].getTot() + "\t");
		System.out.print(sList[idx].getAvg() + "\n");
		System.out.println("-------------------------------------------");
	}
	
} // class
