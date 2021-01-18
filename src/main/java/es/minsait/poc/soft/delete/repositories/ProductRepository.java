package es.minsait.poc.soft.delete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.minsait.poc.soft.delete.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
 
}
 