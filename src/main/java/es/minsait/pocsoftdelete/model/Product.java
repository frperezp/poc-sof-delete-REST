package es.minsait.pocsoftdelete.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

import org.hibernate.annotations.ResultCheckStyle;

//@Data
@Entity
@NamedQuery(name = "Product.FindByName", query = "SELECT a FROM Product a WHERE name like :name")
@SQLDelete(sql = "UPDATE product SET toInstant = (select * from current_timestamp) WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "current_timestamp between fromInstant and toInstant")
public class Product {
 
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      @Column(name = "id", updatable = false, nullable = false)
      private Long id;
 
      @Column
      private String name;
 
      @Column
      private Instant fromInstant;
      
      @Column
      private Instant toInstant;

   	  
   	  
   	  
      
    /*public Product() {
		super();
	}



	public Product(Long id, Instant fromInstant, String name, Instant toInstant) {
		super();
		this.id = id;
		this.fromInstant = fromInstant;
		this.name = name;
		this.toInstant = toInstant;
	}*/
    
    

	@Override
	public String toString() {
		return "Product [id=" + id + ", fromInstant=" + fromInstant + ", name=" + name + ", toInstant=" + toInstant
				+ "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getFromInstant() {
		return fromInstant;
	}

	public void setFromInstant(Instant fromInstant) {
		this.fromInstant = fromInstant;
	}

	public Instant getToInstant() {
		return toInstant;
	}

	public void setToInstant(Instant toInstant) {
		this.toInstant = toInstant;
	}

      
}

