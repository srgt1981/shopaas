package shopaas.domain.model.product;


public class Product {

	private ProductReference reference;
	private String name;
	private boolean onSale;
	
	public Product(ProductReference productReference, String name,
			boolean isOnSale) {
		this.reference = productReference;
		this.name = name;
		this.onSale = isOnSale;
	}

	public ProductReference getReference() {
		return new ProductReference(reference.toString());
	}
	
	public String getName() {
		return ""+name;
	}
	
	public boolean isOnSale() {
		return onSale;
	}

	@Override
	public String toString() {
		return "{ ref: "+reference+", name: "+name+", onSale: "+onSale+" }";
	}
}
