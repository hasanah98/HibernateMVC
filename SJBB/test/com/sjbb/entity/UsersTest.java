package com.sjbb.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sjbb.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
	Users user1= new Users();
	user1.setEmail("nurhalimah34@gmail.com");
	user1.setNameCust("Halimah");
	user1.setPassword("lpo09");
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("SJBB");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	
	entityManager.getTransaction().begin();
	
	entityManager.persist(user1);
	
	entityManager.getTransaction().commit();
	entityManager.close();
	entityManagerFactory.close();
	
	System.out.println("Object is persist");
	}

}
