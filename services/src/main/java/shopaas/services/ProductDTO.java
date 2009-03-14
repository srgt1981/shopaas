package shopaas.services;

public class ProductDTO {

	private String reference;
	private String name;
	private boolean isOnSale;
	
	public String getReference() {
		return reference;
	}
	public String getName() {
		return name;
	}
	public boolean isOnSale() {
		return isOnSale;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOnSale(boolean isOnSale) {
		this.isOnSale = isOnSale;
	}
	
}
