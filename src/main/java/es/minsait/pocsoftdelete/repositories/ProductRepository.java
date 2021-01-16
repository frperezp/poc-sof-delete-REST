package es.minsait.pocsoftdelete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.minsait.pocsoftdelete.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
 
}
 