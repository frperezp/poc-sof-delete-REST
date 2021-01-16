package es.minsait.pocsoftdelete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.ResultCheckStyle;


@Entity
@NamedQuery(name = "ProductFlag.FindByName", query = "SELECT a FROM ProductFlag a WHERE name like :name")
@SQLDelete(sql = "UPDATE productFlag SET state = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "state <> 'DELETED'")
public class ProductFlag {
 
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      @Column(name = "id", updatable = false, nullable = false)
      private Long id;
 
      @Column
      private String name;
 
      @Column
      @Enumerated(EnumType.STRING)
      private ProductState state;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
		this.state = state;
	}
      
      
	      
}
