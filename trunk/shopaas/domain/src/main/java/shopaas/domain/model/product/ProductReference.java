package shopaas.domain.model.product;

/**
 * Referencia de los productos. Más adelante podremos incluir la
 * validación de formato aquí.
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
