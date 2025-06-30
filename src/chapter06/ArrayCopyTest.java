package chapter06;

import java.util.Arrays;

/*
 * 배열 복사 : for, System.arrayCopy(), Arrays.copyOf()
 * */
public class ArrayCopyTest {

	public static void main(String[] args) {
		// 1. for
		int[] arrInt = {1, 2, 3};
		int[] arrInt2 = new int[5];
		int[] arrInt3 = new int[3];	// System.arrayCopy()
		
		for(int i = 0; i < arrInt.length; i++) {
			arrInt2[i] = arrInt[i];
		}
		
		for(int i = 0; i < arrInt2.length; i++) System.out.print(arrInt2[i] + "\t");
		System.out.println();
		
		// 2. System.arrayCopy(
//		public static void arraycopy(Object src,
//				 int srcPos,
//				 Object dest,
//				 int destPos,
//				 int length))
		
//		System.arraycopy(원본, 0, 복제본, 0, 0);
		System.arraycopy(arrInt, 0, arrInt3, 0, arrInt.length);
		for(int i = 0; i < arrInt3.length; i++) System.out.print(arrInt3[i] + "\t");

		// 3.Arrays.copyOf()
		System.out.println();
		int[] arrInt4 = Arrays.copyOf(arrInt, arrInt.length);
		for(int i = 0; i < arrInt4.length; i++) System.out.print(arrInt4[i] + "\t");
//		public static int[] copyOf(int[] original,
//				 int newLength)		
	}

}
