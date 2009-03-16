package shopaas.services;

import java.util.Collections;
import java.util.List;

import shopaas.domain.model.product.Product;
import shopaas.domain.model.product.ProductReference;
import shopaas.domain.model.product.ProductRepository;

/**
 * 
 * @DomainService
 *
 */
public class CatalogueServiceImpl implements CatalogueService {

	private ProductRepository productRepository;
	
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<ProductReference> findAllProductsOnSale() {
		List<ProductReference> result = productRepository.findAllProductsOnSale(); 
		Collections.sort(result);
		return result;
	}

	public void addProduct(ProductDTO dto) {
		ProductReference ref = new ProductReference(dto.getReference());
		String name = dto.getName();
		boolean onSale = dto.isOnSale();
		Product product = new Product(ref,name,onSale);
		productRepository.addProduct(product);
	}

	public ProductDTO getProductByReference(ProductReference reference) {
		// TODO Auto-generated method stub
		return null;
	}

}
