package scjp.levelone;

public class Garbage {
	public static void main(String[] args) {
		Beta b1 = new Beta("B1");
		Beta b2 = new Beta("B2");
		Alpha a1 = new Alpha();
		Alpha a2 = new Alpha();
		a1.b1 = b1;
		a1.b2 = b1;
		a2.b2 = b2;
		a1 = null;
		b1 = null;
		b2 = null;
		// Go here, only 1 object eligible for garbage collection (it is a1)
		// Alpha.b1 is static, so it can be accessed by any Alpah Class 
		// even though a1 has bee null
		System.out.println(a2.b1.toString()); 
	}
}

class Beta {
	private String name;
	public Beta(String name){
		this.name = name;
	}
	@Override
	public String toString(){
		return "Beta-" + this.name;
	}
}

class Alpha {
	static Beta b1;
	Beta b2;
}
