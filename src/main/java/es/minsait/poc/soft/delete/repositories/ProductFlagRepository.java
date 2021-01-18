package es.minsait.poc.soft.delete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.minsait.poc.soft.delete.model.ProductFlag;

public interface ProductFlagRepository extends JpaRepository<ProductFlag, Long>{
 
}
 