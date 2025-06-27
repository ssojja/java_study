package chapter05;

/*
 [시작]
 * 
 **
 ***
 ****
 ***** 
 [종료]
 */

/* 예제 6번
  [시작]
    *
   ***
  *****
 *******
*********
  [종료] 
 */
public class ForOverlabStarTest {

	public static void main(String[] args) {
		// 연습문제 예제6번
		System.out.println("  [시작]");
		// 줄반복
		for(int i = 1; i <= 5; i++) {	// 행
			
			// 공백출력			
			for(int j = 5-i; j > 0; j--) {	// 열
				System.out.print(" ");
			}
			
			// 별출력
			for(int k = 1; k <= 2*i-1; k++) {	// 열
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println("  [종료]");
				
//		System.out.println("------");
//		System.out.println("[시작]");
//		for(int i = 1; i <= 5; i++) {	// 행
//			for(int j = 1; j <= i; j++) {	// 열
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("[종료]");

//		System.out.println("------");
//		System.out.println("[시작]");
//		for(int i = 5; i > 0; i--) {	// 행
//			for(int j = 1; j <= i; j++) {	// 열
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("[종료]");
		
	}

}
