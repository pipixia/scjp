package scjp.designpattern.bridge;

public abstract class AbstractCar {
	private final Product product;
	private final String carType;

	public AbstractCar(Product product, String carType) {
		this.product = product;
		this.carType = carType;
	}

	public abstract void assemble();

	public abstract void produceProduct();

	public void printDetails() {
		System.out.println("AAAAbstractCar: " + carType + ", Product:" + product.getProductName());
	}
}
