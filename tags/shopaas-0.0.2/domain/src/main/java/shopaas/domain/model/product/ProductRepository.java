package shopaas.domain.model.product;

import java.util.List;

public interface ProductRepository {

	List<ProductReference> findAllProductsOnSale();

	void addProduct(Product product);

}
