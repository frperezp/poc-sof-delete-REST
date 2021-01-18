package es.minsait.poc.soft.delete.services;

import java.util.List;

import es.minsait.poc.soft.delete.model.Product;
import es.minsait.poc.soft.delete.model.ProductFlag;

public interface ProductService {
	
	List<Product> findAll();
	
	Product save(Product product);
	
	Product update(Product product);
	
	void deleteProductByID(Long id);

}
 