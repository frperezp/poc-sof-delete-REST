package es.minsait.pocsoftdelete.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.minsait.pocsoftdelete.model.Product;
import es.minsait.pocsoftdelete.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;
	
	

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	@Override
	public void deleteProductByID(Long id) {
		// TODO Auto-generated method stub
		//productRepository.delete(product);
		productRepository.deleteById(id);
		
	}

}
