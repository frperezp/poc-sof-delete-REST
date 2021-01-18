package es.minsait.poc.soft.delete.model;

import java.time.Instant;

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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.annotations.ResultCheckStyle;

@Slf4j
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "ProductFlag.FindByName", query = "SELECT a FROM ProductFlag a WHERE name like :name")
@SQLDelete(sql = "UPDATE productFlag SET state = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "state <> 'DELETED'")
public class ProductFlag {
 
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id", updatable = false, nullable = false)
      private Long id;
 
      @Column
      private String name;
 
      @Column
      @Enumerated(EnumType.STRING)
      private ProductState state;
	      
}
