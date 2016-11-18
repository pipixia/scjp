package scjp.levelone;

public class Special {
	
	static String s = "-";
	
	static int ii = 0;
	
	public static void main(String[] args) {
		
		boolean b = false;
		
		System.out.println(false ^ false);//false
		
		if(b = true){ //like if(true)
			System.out.println("true"); //True
		}
		
		if(b = false){//like if(false);
			System.out.println("No showing");//Not get here
		}
		
		int j = 0; j = j++;		
		System.out.println("J = " + j); //J = 0
		
		int a1,a2,a3; a1=a2=a3=5; //Legal
		
		for(int ii=0;ii<11;ii++){
			System.out.println("Legal " + ii); // will print Legal 0 to 10
		}

		
		//All legal 
		char char1 = 061;
		char char2 = '\61';
		char char3 = '\061';
		char char4 = 0x006f;
		char char5 = '\u0031';
		System.out.println("" + char1 + char2 + char3 + char4 + char5);
		
		
		//Legal, not null point exception
		Special sp = null;
		System.out.println(sp.ii);
	}
}



