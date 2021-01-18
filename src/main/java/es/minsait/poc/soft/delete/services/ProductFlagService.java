package es.minsait.poc.soft.delete.services;

import java.util.List;

import es.minsait.poc.soft.delete.model.ProductFlag;

public interface ProductFlagService {
	
	List<ProductFlag> findAll();
	
	ProductFlag save(ProductFlag productFlag);
	
	ProductFlag update(ProductFlag productFlag);
	
	void deleteProductByID(Long id);

}
 