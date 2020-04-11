package com.sjbb.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sjbb.entity.Users;

public class UserDAOTest extends BaseDAOTest{
	
	private static UserDAO userDAO;

	@BeforeClass
	public static void setupClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		userDAO = new UserDAO(entityManager);
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("malike345@gmail.com");
		user1.setNameCust("Mohd Malik");
		user1.setPassword("you_89");

		user1 = userDAO.create(user1);

		assertTrue(user1.getIdCust() > 0);

	}

	@Test (expected= PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		Users user1 = new Users();
	
		user1 = userDAO.create(user1);

		//assertTrue(user1.getIdCust() > 0);
	}
	
	@Test
	public void testUpdateUser() {
		Users user= new Users();
		user.setIdCust(1);
		user.setEmail("ahmad_96@luv2code.com");
		user.setNameCust("Ahmad");
		user.setPassword("qwert456");
		
		user= userDAO.update(user);
		String expected="qwert456";
		String actual =user.getPassword();
		assertEquals(expected, actual);
	}

	
	@Test
	public void testGetUsersFound() {
		Integer idCust=1;
		Users user= userDAO.get(idCust);
		System.out.println(user.getEmail());
	//	Users user= userDAO.get(idCust);
		
		assertNotNull(user);
	}
	
	@Test 
	public void testDeleteUsers() {
		Integer idCust= 8;
		userDAO.delete(idCust);
		
		Users user= userDAO.get(idCust);
		
		assertNull(user);
	}
	
	@Test (expected= EntityNotFoundException.class)
	
	public void testDeleteNonExistUsers() {
		Integer idCust=1000;
		userDAO.delete(idCust);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers= userDAO.listAll();
		
		for(Users user : listUsers) {
			System.out.println(user.getEmail());
		}
		assertTrue(listUsers.size()>0);
	}
	
	@Test 
	public void testCount() {
		long totalUsers=userDAO.count();
		
		assertEquals(8,totalUsers );
	}
	
	@Test
	public void testFindByEmail() {
		String email= "mzln@gmail.com";
		Users user= userDAO.findByEmail(email);
		
		assertNotNull(user);
				
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}
}
