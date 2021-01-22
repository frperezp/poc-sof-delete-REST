package es.minsait.poc.soft.delete.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.minsait.poc.soft.delete.model.Product;
import es.minsait.poc.soft.delete.repositories.ProductRepository;

@DataJpaTest
class ProductServiceImplTest {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

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
	void testFindAll() {

		given(productRepository.findAll()).willReturn(listProducts);

		assertEquals(listProducts, productServiceImpl.findAll());
	}

	@Test
	void testSave() {
		given(productRepository.save(iphoneDocePro)).willReturn(iphoneDocePro);

		assertEquals(iphoneDocePro, productServiceImpl.save(iphoneDocePro));
	}

	@Test
	void testUpdate() {
	}

	@Test
	void testDeleteProductByID() {
	}

}
