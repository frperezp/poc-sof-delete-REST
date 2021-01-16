package es.minsait.pocsoftdelete.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.time.Instant;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.minsait.pocsoftdelete.model.Product;
import es.minsait.pocsoftdelete.repositories.ProductRepository;

class ProductServiceImplTest {
	
	ProductService productServiceMock = mock(ProductService.class);
	
	

	/*public ProductServiceImplTest(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}*/

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void listOfAllProductsTest() {
		
		Product productMockOne = mock(Product.class);
		Product productMockTwo = mock(Product.class);
		Product productMockThree = mock(Product.class);
        
		
		List<Product> products = Arrays.asList(productMockOne, productMockTwo, productMockThree);
		
		when(productServiceMock.findAllProducts()).thenReturn(products);
		
		assertEquals(4, products.size());
		
	}
	
//	@Test
//	void deleteProductByIdTest() {
//		
//		verify(productServiceMock.deleteProductByID(4L));
//		
//		assertEquals(4, products.size());
//
//	}

}
