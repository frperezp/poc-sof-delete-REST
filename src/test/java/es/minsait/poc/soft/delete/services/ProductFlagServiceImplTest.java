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

import es.minsait.poc.soft.delete.model.ProductFlag;
import es.minsait.poc.soft.delete.repositories.ProductFlagRepository;

@DataJpaTest
class ProductFlagServiceImplTest {

	@Mock
	ProductFlagRepository productFlagRepository;

	@InjectMocks
	ProductFlagServiceImpl productFlagServiceImpl;

	static List<ProductFlag> listProductFlags = new ArrayList<>();

	@Mock
	ProductFlag iphoneDocePro;

	@Mock
	static ProductFlag iphoneXP;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		listProductFlags.add(iphoneXP);
		listProductFlags.add(iphoneXP);
		listProductFlags.add(iphoneXP);

	}

	@Test
	void testFindAll() {
		given(productFlagRepository.findAll()).willReturn(listProductFlags);

		assertEquals(listProductFlags, productFlagServiceImpl.findAll());
	}

	@Test
	void testSave() {
		given(productFlagRepository.save(iphoneDocePro)).willReturn(iphoneDocePro);

		assertEquals(iphoneDocePro, productFlagServiceImpl.save(iphoneDocePro));
	}

	@Test
	void testUpdate() {
	}

	@Test
	void testDeleteProductByID() {
	}

}
