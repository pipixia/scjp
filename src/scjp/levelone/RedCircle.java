package scjp.levelone;

// Static Block (Parent, Son) => Constructor Block => Constructor

class Shape {
	static{		
		System.out.println("Static SSS");
	}
	
	{		
		System.out.println("Constructor Block SSS");
	}
	
	static String s = ":::";

	protected Shape() {
		s += "Shape ";
		System.out.println("Shape Constructor");
	}
}

class Circle extends Shape {
	static{		
		System.out.println("ssss");
	}
	
	private Circle() {
		s += "Circle ";
	}
}

public class RedCircle extends Shape {
	static{		
		System.out.println("RRRRR");
	}
	
	static{		
		System.out.println("RRRRR111");
	}
	
	{		
		System.out.println("Constructor Block RRRR");
	}
	
	private RedCircle() {
		super();
		s += "Red-Circle ";
	}

	public static void main(String[] args) {
		new RedCircle();
		System.out.println(s);
	}
	
	
}
