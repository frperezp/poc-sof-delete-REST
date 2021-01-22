package es.minsait.poc.soft.delete.services;

import java.util.List;

import es.minsait.poc.soft.delete.model.ProductFlag;

/**
 * 
 * @author fperezp
 *
 */
public interface ProductFlagService {
	
	/**
	 * 
	 * @return
	 */
	List<ProductFlag> findAll();
	
	ProductFlag save(ProductFlag productFlag);
	
	ProductFlag update(ProductFlag productFlag);
	
	void deleteByID(Long id);

}
 