package scjp.designpattern.bridge;

public class RedCarDoor implements Product {

	private final String productName;
	
	public RedCarDoor(String productName){
		this.productName = productName;
	}
	
	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public void produce() {
		System.out.println("### RedCarDoor Class is Producing Red Car Door");
	}

}
