package chapter06;

public class ArrayLottoTest {

	public static void main(String[] args) {
		// 로또
		// step 1
		int[] lotto = new int[6];
		int idx = 0; // 추첨된 번호 갯수
		
		while(true) {
			int number = (int)(Math.random()*45)+1;	// 1 ~ 45 사이의 정수 범위(로또 번호)
			boolean insert = true;
			
			for(int i = 0; i <= idx; i++) {
				if(lotto[i] == number) {
					insert = false;
					break;
				}
			}
			
			if(insert == true) {
				lotto[idx] = number;
				idx++;
			}
			
			if(idx == 6) break;
		
		}
		
		for(int number : lotto) {
			System.out.println(number);
		}
		
	}

}
