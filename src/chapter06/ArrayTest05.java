package chapter06;

public class ArrayTest05 {

	public static void main(String[] args) {
		int[] nList = new int[3];
		
//		nList[0] = "1"; // Type mismatch
		nList[2] = 99;	// Runtime시에 ArrayIndexOutOfBoundsException 발생
		
		System.out.println(nList.hashCode());
		System.out.println(nList[2]);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(nList[i]);
		}

	}

}
