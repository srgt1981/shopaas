package shopaas.domain.model.product;

/**
 * Referencia de los productos. M�s adelante podremos incluir la
 * validaci�n de formato aqu�.
 * 
 * @ValueObject
 */
public class ProductReference implements Comparable<ProductReference> {
	
	private String reference;
	
	public ProductReference(String reference) {
		this.reference = reference;
	}
	
	@Override
	public String toString() {
		return ""+reference;
	}

	public int compareTo(ProductReference o) {
		return reference.compareTo(o.toString());
	}

}
