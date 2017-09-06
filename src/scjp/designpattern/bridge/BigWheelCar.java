package scjp.designpattern.bridge;

public class BigWheelCar extends AbstractCar {

	private final Product product;
	private final String carType;
	
	public BigWheelCar(Product product, String carType) {
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
