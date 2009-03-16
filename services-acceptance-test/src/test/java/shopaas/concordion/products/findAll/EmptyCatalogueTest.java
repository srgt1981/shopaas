package shopaas.concordion.products.findAll;

import java.util.List;

import shopaas.domain.model.product.ProductReference;

public class EmptyCatalogueTest extends FindAllTest {
	
	public boolean isCatalogueEmpty() {
		List<ProductReference> products = findAllProductsOnSale();
		return (products.size() == 0);
	}

}
