package com.sjbb.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sjbb.entity.Category;

public class CategoryDAOTest extends BaseDAOTest{

	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		BaseDAOTest.setUpBeforeClass();
		categoryDAO = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
		
	}

	@Test
	public void testCreateCategory() {
		Category newCat= new Category("Bot AA");
		Category category= categoryDAO.create(newCat);
		
		assertTrue(category != null && category.getIdCategory()>0);
	}

	@Test
	public void testUpdateCategory() {
		Category cat= new Category("Bot Memancing");
		cat.setIdCategory(4);
		
		Category category= categoryDAO.update(cat);
		
		assertEquals(cat.getNameCategory(), category.getNameCategory());
		
	
	}

	@Test
	public void testGet() {
		Integer idCategory= 4;
		Category cat= categoryDAO.get(idCategory);
		
		assertNotNull(cat);
	}

	@Test
	public void testDeleteCategory() {
		Integer idCategory=5;
		categoryDAO.delete(idCategory);
		
		Category cat= categoryDAO.get(idCategory);
		
		assertNull(cat);
		
	}

	@Test
	public void testListAll() {
		List<Category> listCategory= categoryDAO.listAll();
		listCategory.forEach(c-> System.out.println(c.getNameCategory()+","));
		assertTrue(listCategory.size()>0);
	}

	@Test
	public void testCount() {

	long totalCategories= categoryDAO.count();
	
	assertEquals(2,totalCategories);
	}

}
