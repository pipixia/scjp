package scjp.designpattern.bridge;

public class BlueCarDoor implements Product {

	private final String productName;
	
	public BlueCarDoor(String productName){
		this.productName = productName;
	}
	
	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public void produce() {
		System.out.println("=== BlueCarClass is Producing Blue Car Door");
	}

}
