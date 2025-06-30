package chapter06;

/*
 * 향상된 for - 배열이나 컬렉션(List) 객체에 사용됨
 * */
public class ArrayOfForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nList = {1, 2, 3, 4, 5};
		
		// 일반적인 for문을 이용하여 출력
		System.out.println("일반적인 for문 예");
		for(int i = 0; i < nList.length; i++) System.out.print(nList[i] + "\t");
		
		// 향상된 for문을 이용하여 출력 : 데이터를 출력할 경우
		System.out.println("\n\n향상된 for문 예");
		for(int number : nList) {
			System.out.print(number + "\t");
		}

	}

}
