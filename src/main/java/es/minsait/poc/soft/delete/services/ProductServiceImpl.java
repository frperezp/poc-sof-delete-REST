package es.minsait.poc.soft.delete.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.minsait.poc.soft.delete.model.Product;
import es.minsait.poc.soft.delete.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;
	
	

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}
	
	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public void deleteProductByID(Long id) {
		// TODO Auto-generated method stub
		//productRepository.delete(product);
		productRepository.deleteById(id);
		
	}




}
