package es.minsait.pocsoftdelete.services;

import java.util.List;

import es.minsait.pocsoftdelete.model.Product;

public interface ProductService {
	
	List<Product> findAllProducts();
	
	void deleteProductByID(Long id);

}
 