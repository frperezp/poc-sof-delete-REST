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

import es.minsait.poc.soft.delete.model.ProductFlag;
import es.minsait.poc.soft.delete.services.*;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(ProductFlagController.BASE_URL)
public class ProductFlagController {

	public static final String BASE_URL = "/api/v1";

	private final ProductFlagService productFlagService;

	public ProductFlagController(ProductFlagService productFlagService) {
		this.productFlagService = productFlagService;
	}

	/**
	 * Método para obtener la lista de todos los productFlag.
	 * 
	 * @return Lista de todos los productos.
	 */
	@GetMapping(value = "/product-flags")
	ResponseEntity<List<ProductFlag>> getAll() {
		return new ResponseEntity<>(productFlagService.findAll(), HttpStatus.OK);
	}

	/**
	 * Método que inserta un productFlag.
	 * 
	 * @param productFlag El parámetro productFlag es el objeto product que se
	 *                    insertará en BBDD.
	 * @return Devuelve el objeto insertado.
	 */
	@PutMapping(value = "/product-flag")
	ResponseEntity<ProductFlag> insert(@RequestBody ProductFlag productFlag) {

		log.debug("Deleting {}, {} and {}", 1, 2, 3);
		productFlagService.save(productFlag);
		log.debug("Deleting {}, {} and {}", 1, 2, 3);

		return new ResponseEntity<>(productFlag, HttpStatus.OK);
	}

	/**
	 * Método que actualiza un productFlag.
	 * 
	 * @param productFlag El parámetro productFlag es el objeto product que se
	 *                    actualizará en BBDD.
	 * @return Devuelve el objeto actualizado.
	 */
	@PostMapping(value = "/product-flag")
	ResponseEntity<ProductFlag> update(@RequestBody ProductFlag productFlag) {

		log.debug("Deleting {}, {} and {}", 1, 2, 3);
		productFlagService.update(productFlag);
		log.debug("Deleting {}, {} and {}", 1, 2, 3);

		return new ResponseEntity<>(productFlag, HttpStatus.OK);
	}

	/**
	 * Método que elimina un productFlag dado un id.
	 * 
	 * @param id El parámetro id es el identificador del productFlag que se quiere
	 *           eliminar.
	 * @return Devuelve el id del productFlag eliminado.
	 */
	@DeleteMapping(value = "/product-flag/{id}")
	ResponseEntity<Long> delete(@PathVariable Long id) {

		log.debug("Deleting {}, {} and {}", 1, 2, 3);
		productFlagService.deleteProductByID(id);
		log.debug("Deleting {}, {} and {}", 1, 2, 3);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

}
