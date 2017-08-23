package scjp.levelone;

import java.util.*;

public class PrimitiveNumbers {
	public static void main(String args[]){
		
		compare();
		
		long l = 130L;
		System.out.println(Long.toBinaryString(128));
		byte b = (byte)128;
		System.out.println("Integer.parseInt(\"1000\", 2) = " + Integer.parseInt("1000", 2));
		short s2 = 0600;
		byte s = (new Integer(100000)).byteValue(); //equivalent to "(byte) (100000)"
		System.out.println(s);
		System.out.println((byte) (100000));
		
	}
	
	private void bytes(){
		//Range from -128 to 127, 9 bit signed
		byte a = 3; // No problem, 3 fits in a byte
		byte b = 8; // No problem, 8 fits in a byte
		byte c = 3 + 8; // No problem, 11 fits in a byte
		b += 500;//No problem, equivalent to b = (byte) (b + 500) 
		byte e = (byte) (a + b); //No problem 		
		//Compile Error 
		//byte f = 129; // Compile error: Good from -128 to 127
		//byte d = a + b; // Compile error : possible loss of precision, can't convert int to byte
	}
	
	private void ints(){
		//Range 32-bit signed two's complement integer.
		//Minimum value is - 2,147,483,648 (-2^31)
		//Maximum value is 2,147,483,647(inclusive) (2^31 -1)
	}
	
	private void longs(){
		//54-bit signed two's complement integer.
		//Minimum value is - 9,223,372,036,854,775,808 (-2^63)
		//Maximum value is   9,223,372,036,854,775,807(inclusive) (2^63 -1)
	}
	
	private void shorts(){
		//Range -32,768 ~ 32,767, 16-bit signed
	}
	
	private void chars(){
		//Legal Range 0 ~ 65535, unsigned 16-bit
		//Defulat Value: '\u0000'
		//Minimum value is '\u0000' (or 0)
		//Maximum value is '\uffff' (or 65,535 inclusive)
		
		//Logal, No error 
		char a = 'a';
		char b = '@';
		char letter = '\u004E';
		char e = 0x892; // hexadecimal literal
		char f = 982; // int literal
		char g = (char)70000;
		char h = (char)-100;
		char m = (char)(a+b);
	
		//Compile error:
		//char m = a + b; // Type mismatch: cannot convert from int to char
	}
	
	private void implicit(){

		int i = 123;
		
		long l = i; // int -> long
		
		float f = l; //long -> float
		
		double d = f; //float -> double
		
	}

	private static void defaultValue(){
		/*
		*	Local variables, including primitives, 
				-	always, always, always must be initialized
					before you attempt to use them (though not necessarily on the same line of code).
					Java does not give local variables a default value; you must explicitly initialize them
					with a value, as in the preceding example. If you try to use an uninitialized primitive
					in your code, you'll get a compiler error: Variable xxx may not have been initialized.
		
		*	Instance variable references are always given a default value of null
		*	Local references are not given a default value; in other words, they aren't null.
		*/
	}
	
	private static void wrapperClass(){
		/*
		Primitive    Wrapper Class      Constructor Arguments
		boolean      Boolean            boolean or String
		byte         Byte               byte or String
		char         Character          char (**** No String ****)
		double       Double             double or String
		float        Float              float, double, or String
		int          Integer            int or String, any type can implicit cast to int
		long         Long               long or String, any type can implicit cast to long
		short        Short              short or String
		*/
		Integer i2 = Integer.parseInt("101011", 2);
	}
	
	private void concept(){
		
	/*

	- parseXxx() returns the named primitive
	- valueOf() returns a newly created wrapped object of the type
	
	*/
		
	}
	
	private void advanced(){
		// - 	Cannot cast from Integer to Long
		// 		Remember, none of the wrapper classes will widen from one to another!
		
		//		Bytes won’t widen to Shorts, Shorts won’t widen to Longs, etc
		
		Integer objInt = new Integer("5");
		
		//Long objLong = (Long) objInt; //Cannot cast from Integer to Long
	}
	
	private static void compare(){
		Long objL = new Long(100);
		long l = 100L;
		double d = 100.0;
		Integer objI = new Integer(100);
		int i = 100;
		byte b = 100;
		char c = 100;
		float f = 100.0f;
		if(objL == b) System.out.println("Long 100 == byte 100");//OK
		if(objL == l) System.out.println("Long 100 == long 100");//OK
		if(objL == d) System.out.println("Long 100 == double 100");//OK
		if(objL == c) System.out.println("Long 100 == char 100");//OK
		if(objL == f) System.out.println("Long 100 == float 100");//OK
		if(objL == i) System.out.println("Long 100 == int 100");//OK
		
		if(objL.equals(l)) System.out.println("Long 100 equals to long 100");//NOT
		if(objL.equals(i)) System.out.println("Long 100 equals to int 100");//NOT		
		if(objL.equals(b)) System.out.println("Long 100 equals to byte 100");//NOT		
		if(objL.equals(objI)) System.out.println("Long 100 equals Integer 100");//NOT
		
		/*
		 * Long.equals
		public boolean equals(Object obj) {
	        if (obj instanceof Long) {
	            return value == ((Long)obj).longValue();
	        }
	        return false;
    	}
		 */
		
		System.out.println("" + 7 + 5);//75
		System.out.println(7 + 5 + "");//12
		System.out.println(objI + objL + "");//200, Mind: Long + Integer is LEGAL
	}
}
