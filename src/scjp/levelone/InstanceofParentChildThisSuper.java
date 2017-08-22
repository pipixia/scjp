package scjp.levelone;

public class InstanceofParentChildThisSuper {
	static void init(final Car car){
		if(car instanceof Audi){
			Audi audi = (Audi)car;
			audi.brandName = "Audi";
			System.out.println("Set Audi BrandName");
		}
		
		car.wheelNumber = "4";
	}
	
	public static void main(final String[] args){
		new Audi();
		
		/*
		 * 
'this' is scjp.levelone.Audi

Set Audi BrandName
wheelNumber = 4
brandName = null

		 */
		
		new Car();
//		'this' is scjp.levelone.Car
	}
	
	public static void main2(final String[] args){
		Car car = new Car();
		Audi audi = new Audi();
		if (car instanceof Audi){
			System.out.println("car instanceof Audi");
		}
	}
}

class Car{
	String wheelNumber;
	Car(){
		System.out.println("'this' is " + this.getClass().getName());
		InstanceofParentChildThisSuper.init(this);
	}
}

class Audi extends Car{
	String brandName = null; //will set brandName (4) to be null again after InstanceofParentChild.init(this);
	//String brandName;
	
	Audi(){
		super();
		System.out.println("wheelNumber = " + wheelNumber);
		System.out.println("brandName = " + brandName);
	}
}
