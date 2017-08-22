package scjp.levelone;

public class WidenAndBoxing {
	static void go(Long x) { System.out.println("Long"); }
	
	public static void main(String [] args) {
		byte b = 5;
		//go(b); 
		// The compiler complained : 
		// The method go(Long) in the type WidenAndBoxing is not applicable for the arguments (byte)
	}
}
