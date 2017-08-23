package scjp.levelone;

public class StringRelated {
	public static void main(String[] args) throws Exception {
		String str1 = "ABC";
		String str2 = new String("ABC");
		
		if(str1 == str2) System.out.println("ABC=ABC"); //False
		
		str2 = str2.intern();
		
		if(str1 == str2) System.out.println("After intern, ABC equals to ABC"); //True
		
		String str3 = new String("DDD");
		String str4 = "DDDEEE";
		String str5 = str3 + "EEE"; //Not == str4, even is DDDEEE
		
		// str5 = str5.intern(); after this line, str4 == str5
		if(str5 == str4) System.out.println("str4 == str5");
	}
}

