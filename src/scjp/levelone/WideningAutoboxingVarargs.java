package scjp.levelone;

/*
 * Concept 
 * 		-	When an exact match isn't found, the JVM uses the method with the
			" SMALLEST " argument that is wider than the parameter
 * 		-	Widening beats autoboxing
 * 		-	Widening beats var-args
 * 		-	autoboxing beat var-args (Loser)
 * 	    -	You CANNOT widen from one wrapper type to another. (IS-A fails.)
 * 		- 	Windening & Autoboxign can NOT happen at the same time.
 * 			You CANNOT widen and then box. (An int can't become a Long.) ie. byte to Integer.
 * 			class WidenAndBox {
				static void go(Long x) { System.out.println("Long"); }
				
				public static void main(String [] args) {
					byte b = 5;
					go(b); // WidenAndBox.java:6: go(java.lang.Long) in WidenAndBox cannot be
						   // applied to (byte)
				}
			}
		- 	You can autobox and then widen. (An int can become an Object, via Integer.)
		- 	You can combine var-args with either widening or boxing.
		- 	As always, a var-args method will be chosen only if no non-var-arg method is possible
 */
public class WideningAutoboxingVarargs {

	static void go(Byte x) {
		System.out.print("Object Byte ");
	}

	static void go(int x) {
		System.out.print("int ");
	}

	static void go(long x) {
		System.out.print("long ");
	}
	
	static void go(Long x) {
		System.out.print("Object Long ");
	}

	static void go(double x) {
		System.out.print("double ");
	}
	
	static void go(Double x) {
		System.out.print("Object Double ");
	}

	static void go(int x, int y) {
		System.out.println("int,int");
	}

	static void go(byte... x) {
		System.out.println("byte... ");
	}

	public static void main(String[] args) {
		byte b = 5;
		short s = 5;
		long l = 5;
		float f = 5.0f;
		go(b); // still int, not "Object Byte", Compiler choose "Widening" over
				// "Autoboxing"
		go(s); // int
		go(l); // long
		go(f); // double
		go(b,b);//"int,int" instead of "byte...", Widening beats var-args

		// if there is only go(double), it will return all "double"
		
		go(12.3f);
		
		///////////////////////////////////////////////////////////////////////////////
		//Short s3 = new Short(1); //Error : The constructor Short(int) is undefined
		Short s4 = 1;
		Short s1 = new Short("1");
		Short s2 = s1;
		s1++;
		System.out.println("S1 == S2 is " + (s1==s2)); //S1 == S2 is false
		
		/*
		 * 
		 * s1++ equals to below
		 * 
		 * short tempS1 = s1.shortValue();
		   tempS1++;
		   s1 = new Short(tempS1);
		 * 
		 */
		
	}
}
