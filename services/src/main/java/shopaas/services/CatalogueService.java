package shopaas.services;

import java.util.List;

import shopaas.domain.model.product.ProductReference;

/**
 * Domain Service to manage all the Catalogue domain. Hides the Domain layer
 * from the Application layer and other Bounded Contexts.
 */
public interface CatalogueService {

	/**
	 * Devuelve la lista de referencias de producto s�lo de los productos que
	 * est�n a la venta. Adem�s, la devuelve ordenada alfab�ticamente.
	 */
	List<ProductReference> findAllProductsOnSale();

	void addProduct(ProductDTO product);

	ProductDTO getProductByReference(ProductReference reference);

}
