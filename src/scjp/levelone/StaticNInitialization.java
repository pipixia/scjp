package scjp.levelone;

/* http://www.cnblogs.com/lanxuezaipiao/p/4170157.html
 * 1. Init MainClass and find need SubClass.s
 * 2. Init SubClass, at that time, m is default value is 0. so s=1
 * 3. get back s=1 to m, so m=2;
 */
public class StaticNInitialization {
	public static void main(String[] args) {
		System.out.println("M = " + MainClass.m  + ", S = " + SubClass.s);
		//	M = 2, S = 1
	

	}
}

class SubClass {
	//static field, then static block
	public static int s;
	public static String str = "subclass string";
	static {
		s = MainClass.m + 1;
	}
}

class MainClass {
	public static int m = SubClass.s + 1;
	public static String str = SubClass.str + "";
	
	static {
		
	}

}