package scjp.levelone;

public class ValuePassing {
	
	private static int primitiveValue; //No Matter Static, same result
	 
	private static Integer objInt; //No Matter Static, same result
	
	private static String strValue; //No Matter Static, same result
	
	private StringBuffer sb;
	
	private void changePrimitive(int i){
		i++;
		i++;
		i++;
	}
	
	private void changeIntegerObject(Integer objI){
		objI = new Integer(200);
	}
	
	private void changeStringObject(String str){
		str = new String("DEF");
		//No matter 
		//str = "DEF";
	}
	
	private void changeStringBuffer(StringBuffer sbf){
		sbf.append("DEF");
	}

	public static void main(String[] args) {
		ValuePassing vp = new ValuePassing();
		
		//Primitive - No Change
		vp.primitiveValue = 100;
		System.out.println("Before Change (Privmitive) : " + vp.primitiveValue );//100
		vp.changePrimitive(vp.primitiveValue);
		System.out.println("After Change (Privmitive) : " + vp.primitiveValue );//still 100
		
		//Wraper Class - Integer - No Change
		vp.objInt = new Integer(100);
		System.out.println("Before Change (Integer Object) : " + vp.objInt );//100
		vp.changeIntegerObject(vp.objInt);
		System.out.println("After Change (Integer Object) : " + vp.objInt );//still 100
		
		vp.strValue = "ABC";
		System.out.println("Before Change (String) : " + vp.strValue );//ABC
		vp.changeStringObject(vp.strValue);
		System.out.println("After Change (String) : " + vp.strValue );//still ABC
		
		vp.sb = new StringBuffer("ABC");
		System.out.println("Before Change (StringBuffer) : " + vp.sb );//ABC
		vp.changeStringBuffer(vp.sb);
		System.out.println("After Change (StringBuffer) : " + vp.sb );//Change to ABCDEF

	}
}
