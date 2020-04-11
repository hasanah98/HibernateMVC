package com.sjbb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.sjbb.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Category create(Category category) {
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object idCategory) {
		return super.find(Category.class, idCategory);
	}

	@Override
	public void delete(Object idCategory) {
		super.delete(Category.class, idCategory);
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}

}
