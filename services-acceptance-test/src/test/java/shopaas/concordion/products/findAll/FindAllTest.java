package shopaas.concordion.products.findAll;

import java.util.List;

import org.concordion.api.ResultSummary;
import org.concordion.internal.ConcordionBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shopaas.domain.model.product.ProductReference;
import shopaas.services.CatalogueService;
import shopaas.services.ProductDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/products-test-context.xml" })
public class FindAllTest {

	@Test
	public void run() throws Exception {
		ResultSummary resultSummary = new ConcordionBuilder().build().process(
				this);
		resultSummary.print(System.out);
		resultSummary.assertIsSatisfied();
	}

	@Autowired
	private CatalogueService catalogueService;

	public void givenAnEmptyCatalogue() {
		// No hacemos nada de momento
	}

	/**
	 * Construimos el DTO y lo enviamos al servicio para que construya el
	 * Producto y lo guarde.
	 * 
	 * @param ref Código de identificación del producto.
	 * @param name Nombre del producto.
	 * @param isOnSale Si está a la venta o no.
	 */
	public void addProductToCatalogue(String ref, String name, String isOnSale) {
		ProductDTO dto = new ProductDTO();
		dto.setReference(ref);
		dto.setName(name);
		dto.setOnSale(Boolean.parseBoolean(isOnSale));
		catalogueService.addProduct(dto);
	}

	public List<ProductReference> findAllProductsOnSale() {
		return catalogueService.findAllProductsOnSale();
	}
}
