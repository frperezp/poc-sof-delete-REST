package es.minsait.poc.soft.delete.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.minsait.poc.soft.delete.model.ProductFlag;
import es.minsait.poc.soft.delete.repositories.ProductFlagRepository;
import es.minsait.poc.soft.delete.services.ProductFlagService;

@DataJpaTest
class ProductFlagControllerTest {

	@Mock
	ProductFlagRepository productFlagRepository;

	@Mock
	ProductFlagService productFlagService;

	@InjectMocks
	ProductFlagController productFlagController;

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
	void testGetAll() {
		given(productFlagService.findAll()).willReturn(listProductFlags);

		assertEquals(new ResponseEntity<>(listProductFlags, HttpStatus.OK), productFlagController.getAll());
	}

	@Test
	void testInsert() {
		given(productFlagService.save(iphoneDocePro)).willReturn(iphoneDocePro);

		assertEquals(new ResponseEntity<>(iphoneDocePro, HttpStatus.OK), productFlagController.insert(iphoneDocePro));

	}

	@Test
	void testUpdate() {
		given(productFlagService.save(iphoneDocePro)).willReturn(iphoneDocePro);

		assertEquals(new ResponseEntity<>(iphoneDocePro, HttpStatus.OK), productFlagController.update(iphoneDocePro));
	}

	@Test
	void testDelete() {
		productFlagController.delete(1L);
		verify(productFlagService, times(1)).deleteByID(anyLong());

	}

}
