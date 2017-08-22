package scjp.levelone;

import java.util.HashSet;

public class Test2 {

	public static void main(String[] args) {
		String s3 = "01234567";
		int start = 1;
		char end = 5;
		System.out.println(start + end); // 6
		System.out.println(s3.substring(start, end)); // 1234

		// ---------------------
		/*
		 * The size of the shortSet will be 100. 
		 * Java Autoboxing feature has been introduced in JDK 5, 
		 * so while adding the short to HashSet<Short> 
		 * it will automatically convert it to Short object. 
		 * Now “i-1” will be converted to int while evaluation 
		 * and after that it will autoboxed to Integer object 
		 * but there are no Integer object in the HashSet, 
		 * so it will not remove anything from the HashSet and finally its size will be 100.
		 */
		HashSet shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
			shortSet.add(i);
			shortSet.remove(i-1);// i - 1 will be converted to int
		}
		System.out.println(shortSet.size()); // Size is 100
		
		HashSet<Integer> intSet = new HashSet<Integer>();
		for (int i = 0; i < 100; i++) {
			intSet.add(i);
			intSet.remove(i - 1);
		}
		System.out.println(intSet.size()); // Size is 1

		// ---------------------
		//What will be the boolean “flag” value to reach the finally block?
		//The finally block will never be reached here. 
		//If flag will be TRUE, it will go into an infinite loop and if it’s false it’s exiting the JVM. 
		//So finally block will never be reached here.
		/*
		boolean flag = false;
		try {
			if (flag) {
				while (true) {
				}
			} else {
				System.exit(1);
			}
		} finally {
			System.out.println("In Finally");
		}
		*/
		
		//----------------------
		/*
		 * The given statements output will be “false” 
		 * because in java + operator precedence is more than == operator. 
		 * So the given expression will be evaluated to “s1 == s2 is:abc” == “abc” i.e. false.
		 */
		String s1 = "abc"; 
		String s2 = "abc"; 
		System.out.println("s1 == s2 is:" + s1 == s2); //false
		
		//----------------------
		/*
		 * The given print statement will throw java.lang.NullPointerException 
		 * because while evaluating the OR logical operator 
		 * it will first evaluate both the literals and 
		 * since str is null, .equals() method will throw exception. 
		 * It’s always advisable to use short circuit logical operators 
		 * i.e. “||” and “&&” which evaluates the literals values from left and 
		 * since the first literal will return true, it will skip the second literal evaluation.
		 * 
		 */
		String str = null; 
		String str1="abc"; 
		//System.out.println(str1.equals("abc") | str.equals(null)); // java.lang.NullPointerException
		
		unboxing(new Long(100));//Unboxing to long, then Primitive type long formal argument :100
	}
	
	public static void unboxing(long i)
    {
         
        System.out.println("Primitive type long formal argument :" + i);
    }
}
