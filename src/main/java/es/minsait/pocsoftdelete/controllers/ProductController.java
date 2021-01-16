package es.minsait.pocsoftdelete.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.minsait.pocsoftdelete.model.Product;
import es.minsait.pocsoftdelete.model.ProductFlag;
import es.minsait.pocsoftdelete.services.*;

@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {
	
	public static final String BASE_URL = "/api/v1";
	
	private final ProductService productService;
	private final ProductFlagService productFlagService;

	public ProductController(ProductService productService, ProductFlagService productFlagService) {
		this.productService = productService;
		this.productFlagService = productFlagService;
	}
	
	@GetMapping(value = "/products")
	List<Product> getAllProducts() {
		return productService.findAllProducts();
	}
	
	@DeleteMapping(value = "/postsd/{id}")
	ResponseEntity<Long> deleteProduct(@PathVariable Long id) {
		
		System.out.println("Deleting ... "+id);
		productService.deleteProductByID(id);
		System.out.println("Deleting??? ... "+id);

	    /*if (!isRemoved) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }*/

	    return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@GetMapping(value = "/productsFlag")
	List<ProductFlag> getAllProductsFlag() {
		return productFlagService.findAllProducts();
	}
	
	@DeleteMapping(value = "/postsflagd/{id}")
	ResponseEntity<Long> deleteProductFlag(@PathVariable Long id) {
		
		System.out.println("Deleting ... ");
		productFlagService.deleteProductByID(id);
		System.out.println("Deleting??? ... ");

	    /*if (!isRemoved) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }*/

	    return new ResponseEntity<>(id, HttpStatus.OK);
	}
	

}
