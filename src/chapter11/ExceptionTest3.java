package chapter11;

public class ExceptionTest3 {

	public static void main(String[] args) {
		
		String name1 = "홍길동";
		String name2 = null;
		ExceptionObject eo = null;
		
		eo = new ExceptionObject();
		eo.name = "홍길동";
		
		try {
			if(name1.equals(eo.name)) {
				System.out.println("동일합니다.");
			} else {
				System.out.println("동일하지 않습니다.");
			}			
		} catch (NullPointerException e) {
			System.out.println("NullPointerException이에옹..");
			System.out.println(e);
			e.printStackTrace();
		}
		
		

	} // main

} // class
