package es.minsait.poc.soft.delete.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.minsait.poc.soft.delete.model.ProductFlag;
import es.minsait.poc.soft.delete.repositories.ProductFlagRepository;


@Service
public class ProductFlagServiceImpl implements ProductFlagService{
	
	private final ProductFlagRepository productFlagRepository;
	
	

	public ProductFlagServiceImpl(ProductFlagRepository productFlagRepository) {
		this.productFlagRepository = productFlagRepository;
	}


	@Override
	public List<ProductFlag> findAll() {
		// TODO Auto-generated method stub
		return productFlagRepository.findAll();
	}

	@Override
	public ProductFlag save(ProductFlag productFlag) {
		// TODO Auto-generated method stub
		return productFlagRepository.save(productFlag);
	}
	
	@Override
	public ProductFlag update(ProductFlag productFlag) {
		// TODO Auto-generated method stub
		return productFlagRepository.save(productFlag);
	}

	@Override
	public void deleteByID(Long id) {
		// TODO Auto-generated method stub
		//productRepository.delete(product);
		productFlagRepository.deleteById(id);	
	}

}
