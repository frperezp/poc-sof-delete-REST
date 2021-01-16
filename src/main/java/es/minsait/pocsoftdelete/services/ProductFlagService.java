package es.minsait.pocsoftdelete.services;

import java.util.List;

import es.minsait.pocsoftdelete.model.ProductFlag;

public interface ProductFlagService {
	
	List<ProductFlag> findAllProducts();
	
	void deleteProductByID(Long id);

}
 