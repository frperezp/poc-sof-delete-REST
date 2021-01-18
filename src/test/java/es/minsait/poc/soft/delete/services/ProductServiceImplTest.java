package es.minsait.poc.soft.delete.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.minsait.poc.soft.delete.model.Product;
import es.minsait.poc.soft.delete.services.ProductService;

class ProductServiceImplTest {
	
	ProductService productServiceMock = mock(ProductService.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testFindAllProducts() {
		Product productMockOne = mock(Product.class);
		Product productMockTwo = mock(Product.class);
		Product productMockThree = mock(Product.class);
        
		
		List<Product> products = Arrays.asList(productMockOne, productMockTwo, productMockThree);
		
		when(productServiceMock.findAllProducts()).thenReturn(products);
		
		assertEquals(3, products.size());
	}

	@Test
	void testDeleteProductByID() {
//		
//		verify(productServiceMock.deleteProductByID(4L));
//		
//		assertEquals(4, products.size());
	}

}
