package scjp.designpattern.bridge;

public class TestBridgePattern {

	public static void main(String[] args) {
		Product blueDoor = new BlueCarDoor("Blue Door");
		Product redDoor = new RedCarDoor("Red Door");
		AbstractCar car = new BigWheelCar(blueDoor , "BigWheel Blue Door model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		
		System.out.println();
		
		car = new BigWheelCar(redDoor , "BigWheel Blue Door model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		
		System.out.println("-----------------------------------------------------");
		
		car = new SmallWheelCar(blueDoor , "SmallWheel Blue Door model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		
		System.out.println();
		
		car = new SmallWheelCar(redDoor , "SmallWheel Red Door model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		
	}

}
