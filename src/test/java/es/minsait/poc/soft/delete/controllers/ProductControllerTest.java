package es.minsait.poc.soft.delete.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.minsait.poc.soft.delete.model.Product;


class ProductControllerTest {
	
	
	public static Session session;
	public static SessionFactory factory;
	
	@BeforeAll
	void beforeTests() {
		System.out.println("Before all Tests");
//		factory = new Configuration().configure("hibernate.cfg.xml")
//		  		.addAnnotatedClass(Product.class).buildSessionFactory();
		factory = new Configuration().configure("application.properties")
		  		.addAnnotatedClass(Product.class).buildSessionFactory();
		
		session = factory.openSession();
	}
	
	@BeforeEach
	void forEachTest(){
		
		session.beginTransaction();
        
        Product iphoneX = new Product();
        iphoneX.setName("iPhone X");
        iphoneX.setFromInstant(Instant.parse("2019-04-09T10:15:30.00Z"));
        iphoneX.setToInstant(Instant.parse("2021-01-11T10:17:46.00Z"));
         
        session.save(iphoneX);
        
        Product iphoneXP= new Product();
        iphoneXP.setName("iPhone X Plus");
        iphoneXP.setFromInstant(Instant.parse("2019-04-09T10:15:30.00Z"));
        iphoneXP.setToInstant(Instant.parse("2021-01-01T10:15:30.00Z"));
         
        session.save(iphoneXP);
        
        Product iphoneXR= new Product();
        iphoneXR.setName("iPhone XR");
        iphoneXR.setFromInstant(Instant.parse("2019-04-09T10:15:30.00Z"));
        iphoneXR.setToInstant(Instant.parse("2021-01-31T10:15:30.00Z"));
         
        session.save(iphoneXR);

        Product iphoneXS= new Product();
        iphoneXS.setName("iPhone XS");
        iphoneXS.setFromInstant(Instant.parse("2019-04-09T10:15:30.00Z"));
        iphoneXS.setToInstant(Instant.parse("2021-01-31T10:15:30.00Z"));
         
        session.save(iphoneXS);
        
        session.getTransaction().commit();
	}
	
	
	@Test
	void testGetAllProducts() {
		try {	 
            session.beginTransaction();            
            List<Product> productos = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            
            for(Product product : productos) {
            	System.out.println("Nombre del producto " + product.getName());
            }
            
            
            System.out.println("List size " + productos.size());
            assertEquals(productos.size(), 3);
            
            
            System.out.println("Succefull connection");
             
            
            
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
            ex.printStackTrace();
            fail("Not yet implemented");
        }
	}

	@Test
	void testDeleteProduct() {
		try {	 
			
			
			session.beginTransaction();            
	        session.delete(factory);
	        session.getTransaction().commit();
			
			
            session.beginTransaction();            
            List<Product> productos = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            
            for(Product product : productos) {
            	System.out.println("Nombre del producto " + product.getName());
            }
            
            
            System.out.println("List size " + productos.size());
            assertEquals(productos.size(), 3);
            
            
            System.out.println("Succefull connection");
             
            
            
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
            ex.printStackTrace();
            fail("Not yet implemented");
        }
	}

}
