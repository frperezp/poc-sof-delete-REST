package es.minsait.poc.soft.delete.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.minsait.poc.soft.delete.model.Product;
import es.minsait.poc.soft.delete.repositories.ProductRepository;
import es.minsait.poc.soft.delete.services.ProductService;

@DataJpaTest
//@Slf4j
class ProductControllerTest {

	@Mock
	ProductRepository productRepository;

	@Mock
	ProductService productService;

	@InjectMocks
	ProductController productController;

	static List<Product> listProducts = new ArrayList<>();

	@Mock
	Product iphoneDocePro;

	@Mock
	static Product iphoneXP;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		listProducts.add(iphoneXP);
		listProducts.add(iphoneXP);
		listProducts.add(iphoneXP);

	}

	@Test
	void testGetAll() {

		given(productService.findAll()).willReturn(listProducts);

		assertEquals(new ResponseEntity<>(listProducts, HttpStatus.OK), productController.getAll());
	}

	@Test
	void testInsert() {

		given(productService.save(iphoneDocePro)).willReturn(iphoneDocePro);

		assertEquals(new ResponseEntity<>(iphoneDocePro, HttpStatus.OK), productController.insert(iphoneDocePro));

	}

	@Disabled
	@Test
	void testUpdate() {

	}
	
	@Disabled
	@Test
	void testDelete() {

	}

}
