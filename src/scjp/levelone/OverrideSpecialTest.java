package scjp.levelone;

public class OverrideSpecialTest {

	public void foo(String s) {
		System.out.println("String");
	}

	public void foo(StringBuffer sb) {
		System.out.println("StringBuffer");
	}

	public static void main(String[] args) {
		Object s = null;
		//new Test().foo(s); //Compile Error - Ambiguous
	}
}
