package shopaas.domain.model.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Repository
 *
 */
public class ProductRepositoryImpl implements ProductRepository {

	Map<ProductReference,Product> products;
	
	public ProductRepositoryImpl() {
		products = new HashMap<ProductReference, Product>();
	}
	
	public List<ProductReference> findAllProductsOnSale() {
		List<ProductReference> result = new ArrayList<ProductReference>();
		for( Product product : products.values() ) {
			if ( product.isOnSale() ) {
				result.add(product.getReference());
			}
		}
		return result;
	}

	public void addProduct(Product product) {
		ProductReference key = product.getReference();
		Product value = product;
		products.put(key, value);
	}

}
