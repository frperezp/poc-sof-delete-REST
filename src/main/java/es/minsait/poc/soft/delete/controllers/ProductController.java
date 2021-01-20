package es.minsait.poc.soft.delete.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.minsait.poc.soft.delete.model.Product;
import es.minsait.poc.soft.delete.services.*;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(ProductController.BASE_URL)
public class ProductController {

	public static final String BASE_URL = "/api/v1";

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Método para obtener la lista de todos los product.
	 * 
	 * @return Lista de todos los product.
	 */
	@GetMapping(value = "/products")
	ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}

	/**
	 * Método que inserta un product.
	 * 
	 * @param product El parámetro product es el objeto producto que se insertará en
	 *                BBDD.
	 * @return Devuelve el objeto insertado.
	 */
	@PutMapping(value = "/product")
	ResponseEntity<Product> insert(@RequestBody Product product) {

		productService.save(product);

		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	/**
	 * Método que actualiza un product.
	 * 
	 * @param product El parámetro product es el objeto product que se actualizará
	 *                en BBDD.
	 * @return Devuelve el objeto actualizado.
	 */
	@PostMapping(value = "/product")
	ResponseEntity<Product> update(@RequestBody Product product) {

		log.debug("Updating {}, {} and {}", 1, 2, 3);
		productService.update(product);
		log.debug("Updating??? {}, {} and {}", 1, 2, 3);

		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	/**
	 * Método que elimina un product dado un id.
	 * 
	 * @param id El parámetro id es el identificador del product que se quiere
	 *           eliminar.
	 * @return Devuelve el id del product eliminado.
	 */
	@DeleteMapping(value = "/product/{id}")
	ResponseEntity<Long> delete(@PathVariable Long id) {

		log.debug("Deleting {}, {} and {}", 1, 2, 3);
		productService.deleteProductByID(id);
		log.debug("Deleting {}, {} and {}", 1, 2, 3);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

}
