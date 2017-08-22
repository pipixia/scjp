package scjp.levelone;

public class StringRelated {
	public static void main(String[] args) throws Exception {
		String str1 = "ABC";
		String str2 = new String("ABC");
		
		if(str1 == str2) System.out.println("ABC=ABC"); //False
		
		str2 = str2.intern();
		
		if(str1 == str2) System.out.println("After intern, ABC equals to ABC"); //True
	}
}

