package com.sjbb.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sjbb.entity.Category;

public class CategoryTest {

	public static void main(String[] args) {
	Category newCat= new Category();
	newCat.setNameCategory("Bot Memancing");
	
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("SJBB");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	
	entityManager.getTransaction().begin();
	
	entityManager.persist(newCat);
	
	entityManager.getTransaction().commit();
	entityManager.close();
	entityManagerFactory.close();
	
	System.out.println("Object is persist");
	}

}
