package chapter05;

public class Exercise {

	public static void main(String[] args) {
		// 연습문제 1
		// 1부터 100까지의 정수 중 5의 배수의 합계를 출력하는 프로그램을 작성하시오.
		int sum = 0;
		
		// for문을 이용하여 반복 합계 연산
		for(int i = 0; i <= 100; i++) {
			if(i % 5 == 0) sum += i;
		}
		System.out.println("5의 배수의 합계는 " + sum);
		System.out.println();
		
		// 연습문제 2
		// 1부터 100까지의 수 중 짝수와 홀수의 합을 각각 구하시오.
		int evenSum = 0;
		int oddSum = 0;
		
		// for문을 이용하여 반복 합계 연산
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}
		
		System.out.println("짝수의 합계는 " + evenSum);
		System.out.println("홀수의 합계는 " + oddSum);
		System.out.println();
		
		// 연습문제 3
		// 두 개의 주사위의 두 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.	
		for(int x = 1; x <= 6; x++) {
			for(int y = 1; y <= 6; y++) {
				if((x + y) == 6) {
					System.out.println("(" + x + "," + y + ")");
				}
			}
		}
		System.out.println();
		
		
		// 연습문제 4 & 연습문제 5
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int k = 5; k >= 1; k--) {
			for(int m = 1; m <= k; m++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		// 연습문제 6
		// 이중 for문을 이용하여 아래와 같은 실행 결과가 출력되도록 코드를 작성하시오.
		for(int i = 1; i <= 5; i++) {
			// 공백출력
			for(int j = 5-i; j > 0; j-- ) {
				System.out.print(" ");
			}
			
			// 별출력
			for(int k = 1 ; k <= 2*i-1; k++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
		System.out.println();
		
		
		// 연습문제 7
		// 주사위의 눈이 6이 나올때까지 계속 반복해서 굴리고, 눈이 6이 되면 지금까지 주사위를 굴린 횟수까지 출력하는 코드는 작성하시오.
		// while문으로 반복, 주사위는 Math.random()으로 작성
		int num = 0;
		int time = 0;
	
		
		while(num != 6) {
			num = (int)(Math.random()*6) + 1;
			time += 1;
			System.out.println("(" + num + ")");
		}
		
		System.out.println("총 주사위 굴린 횟수는 : " + time + "회");
		
	}

}
