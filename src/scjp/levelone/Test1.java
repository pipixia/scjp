package scjp.levelone;

public class Test1 {
	
	static String s = "-";
	
	public static void main(String[] args) {
		
		
		A1[] aa = new A1[2];
		B[] ba = new B[2];
		sifter(aa);
		sifter(ba);
		sifter(7);
		System.out.println(s);
		boolean b = false;
		
		System.out.println(false ^ false);//false
		
		if(b = true){ //like if(true)
			System.out.println("true"); //True
		}
		
		if(b = false){//like if(false);
			System.out.println("No showing");//Not get here
		}
		
		int j = 0;
		j = j++;
		
		System.out.println("J = " + j); //J = 0

	}

	static void sifter(A1[]... a2) {
		s += "1";
	}

	static void sifter(B[]... b1) {
		s += "2";
	}

	static void sifter(B[] b1) {
		s += "3";
	}
	
	static void sifter(A1[] a1) {
		s += "7";
	}

	static void sifter(Object o) {
		s += "4";
	}
}

class A1 {
	
}

class B extends A1 {
}

