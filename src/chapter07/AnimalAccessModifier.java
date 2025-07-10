package chapter07;

//class AnimalAccessModifier { → chapter07 에서만 사용 가능 
public class AnimalAccessModifier {
	// Field
	String name; 	// default로 같은 패키지에서만 가능
	int age;		// default로 같은 패키지에서만 가능
	
	private String pName; 	// 같은 클래스 내부에서만 접근 가능
	private int pAge;		// 같은 클래스 내부에서만 접근 가능
	
	static String sName;	// static 변수, 클래스 변수
	static int sAge;
	
	final String fname = "홍길동";		// final 키워드 적용 => 외부에서 값을 변경할 수 없음!
	final int fage = 20;
	
	// 상수 정의
	public static final int START = 0;		// public static final 기재하는 순서 상관없음
	public static final int CONTINUE = 1;
	public static final int END = -1;
	
	// Constructor
	public AnimalAccessModifier() {}
	
	public AnimalAccessModifier(String pName, int pAge) {
		this.pName = pName;
		this.pAge = pAge;
	}

	// static method
	void getInfo() {	// 같은 패키지 안에서만...
		System.out.println("pName : " + pName + ", pAge : " + pAge);
	}

	public void getInfo2() {	// 모든 클래스...
		System.out.println("pName : " + pName + ", pAge : " + pAge);
	}
	
	static public void getInfo3() {	// 모든 클래스...
		System.out.println("sName : " + sName + ", sAge : " + sAge);
	}

	
	
	// Method
	// getter/setter
	public String getPname() { return pName;	}
	public int getPage() { return pAge;}

	public void setPname(String pName) { this.pName = pName; }
	public void setPage(int pAge) { this.pAge = pAge;}
	
}
