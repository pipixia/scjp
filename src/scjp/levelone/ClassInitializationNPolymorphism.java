package scjp.levelone;

/*
 * Key Points:
 * 		- Polymorphism is only for instance methods, not applying to fields and static methods
 * 		- Static Block -> Instance Init Block -> Constructor
 * 		- MultipleBlocks run in order
 * 
 */

public class ClassInitializationNPolymorphism {
	public static void main(String[] args) {
		new Son(); 
		/*
		father-static
		son-static
		father-init-block
		father-constructor
		son-init-block
		son-constructor
		 */
		
		System.out.println("===========================================================");

		Father f = new Son();
		
		//Polymorphism is only for instance methods, not applying field and static methods
		//Output : 
		/*
		father-init-block
		father-constructor
		son-init-block
		son-constructor
		BigMan, STUDY, Static-Working
		 */
		System.out.println(f.name + ", " + f.task() + ", " + f.staticTask());
		
	}
}

class Father {
	static {
		System.out.println("father-static");
	}
	
	{
		System.out.println("father-init-block");
		
	}
	
	String name = "BigMan";
	Father() {
		System.out.println("father-constructor");
	}

	Father(String name) {
		//this();
		System.out.print("Fathe-Name " + name + " --> ");
	}
	
	String task(){
		return "WORKING";
	}
	
	static String staticTask(){
		return "Static-Working";
	}
}

class Son extends Father {
	static {
		System.out.println("son-static");
	}
	
	{
		System.out.println("son-init-block");
		
	}
	
	String name = "LittleKid";
	Son() {
		System.out.println("son-constructor");
	}

	Son(String name) {
		System.out.println("Son-Name " + name + " --> ");
	}
	
	String task(){
		return "STUDY";
	}

	static String staticTask(){
		return "Static-Studying";
	}
}