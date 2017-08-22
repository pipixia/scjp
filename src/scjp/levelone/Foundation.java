package scjp.levelone;

import scjp.common.Util;

public class Foundation{
	
	public static void misc(){
		Util.print(String.valueOf(80 < 90 ? 90 : 100.0)); //Result is 90.0, not 90
		
		//
		int i = 0xFFFFFFF1;
		Util.print(String.valueOf(i)); //print -15
		int j = ~i;
		Util.print(String.valueOf(j));
		
		//
		Integer myInteger = new Integer (42);
		Long myLong = new Long (42);
		Double myDouble = new Double (42.0);
		Short myShort = new Short((short)42);
		Util.print(myInteger.equals(42));//true
		Util.print(myInteger.equals(myShort));//false ****** equals should only happen in same wrapper type
		Util.print(myInteger.equals(myLong));//false ****** because of obj instanceof Double(or Long, Integer)
		Util.print(myDouble.equals(myInteger));//false
		Util.print(myInteger.equals(myDouble));//false
		
		//String
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");// THis line, Two Objects created in memory
		String str4 = str3.intern();
		// any two strings s and t, s.intern() == t.intern() is true 
		// if and only if s.equals(t) is true. 
		
		Util.print(str1 == str2); //true
		Util.print(str1 == str3); //false
		Util.print(str1 == str4); //true
		
	}
	
	
	
	public static void main(String[] args){
		misc();
	}
}
