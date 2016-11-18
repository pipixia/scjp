package scjp.levelone;

public class Operator {

	public static void main(String[] args) {
		AA a = new AA();
		BB b = new BB();

		String sss = null;
		/*
		 * a is instance of interface FOO b is instance of interface FOO b is
		 * instance of class AA
		 */

		if (a instanceof Foo) {
			System.out.println("a is instance of interface FOO");
		}

		if (b instanceof Foo) {
			System.out.println("b is instance of interface FOO");
		}

		if (b instanceof AA) {
			System.out.println("b is instance of class AA");
		}

		// No, but it is LEGAL to test whether the null reference is an instance
		// of a class
		if (sss instanceof String) {
			System.out.println("sss is instance of String");
		} else {
			System.out.println("No, but it is LEGAL to test whether the null reference is an instance of a class");
		}
		
		Dog d = new Dog();
		
		//You canNOT use the instanceof operator to test across two different class hierarchies.
		//System.out.println(d instanceof Cat); //Compile Error : Incompatible conditional operand types Dog and Cat
		
	}

}

interface Foo {
}

class AA implements Foo {
}

class BB extends AA {
}

class Cat {
}

class Dog {
}
