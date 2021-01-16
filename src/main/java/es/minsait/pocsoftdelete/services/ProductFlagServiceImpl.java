package es.minsait.pocsoftdelete.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.minsait.pocsoftdelete.model.ProductFlag;
import es.minsait.pocsoftdelete.repositories.ProductFlagRepository;


@Service
public class ProductFlagServiceImpl implements ProductFlagService{
	
	private final ProductFlagRepository productFlagRepository;
	
	

	public ProductFlagServiceImpl(ProductFlagRepository productFlagRepository) {
		this.productFlagRepository = productFlagRepository;
	}


	@Override
	public List<ProductFlag> findAllProducts() {
		// TODO Auto-generated method stub
		return productFlagRepository.findAll();
	}


	@Override
	public void deleteProductByID(Long id) {
		// TODO Auto-generated method stub
		//productRepository.delete(product);
		productFlagRepository.deleteById(id);
		
	}

}
