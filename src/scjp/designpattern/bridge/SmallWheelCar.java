package scjp.designpattern.bridge;

public class SmallWheelCar extends AbstractCar {

	private final Product product;
	private final String carType;
	
	public SmallWheelCar(Product product, String carType) {
		super(product, carType);
		this.product = product;
		this.carType = carType;
	}

	@Override
	public void assemble() {
		System.out.println("Assembling "+product.getProductName()+" for "+carType);
	}

	@Override
	public void produceProduct() {
		product.produce();
		System.out.println("Modifing product "+product.getProductName()+" according to "+carType);
	}

}
