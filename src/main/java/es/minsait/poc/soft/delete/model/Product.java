package es.minsait.poc.soft.delete.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.annotations.ResultCheckStyle;

//@SQLDelete(sql = "UPDATE product SET toInstant = (select * from CURRENT_TIMESTAMP()) WHERE id = ?", check = ResultCheckStyle.COUNT)
//CURRENT_TIMESTAMP()


@Slf4j
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Product.FindByName", query = "SELECT a FROM Product a WHERE name like :name")
@SQLDelete(sql = "UPDATE product SET toInstant = current_timestamp WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "current_timestamp between fromInstant and toInstant")
public class Product {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id", updatable = false, nullable = false)
	      private Long id;
	 
	      @Column
	      private String name;
	 
	      @Column
	      private Instant fromInstant;
	      
	      @Column
	      private Instant toInstant;
      
      
      
}

