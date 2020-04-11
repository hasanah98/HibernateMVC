package com.sjbb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.sjbb.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);

	}

	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		return super.update(user);
	}

	@Override
	public Users get(Object idCust) {
		return super.find(Users.class, idCust);

	}

	public Users findByEmail(String email) {
	List<Users> listUsers=	super.findWithNamedQuery("Users.findByEmail", "email", email);
			
		if(listUsers != null && listUsers.size()>0) {
			return listUsers.get(0);
		}
		return null;
	}

	@Override
	public void delete(Object idCust) {
		super.delete(Users.class, idCust);
	}

	@Override
	public List<Users> listAll() {

		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {

		return super.countWithNamedQuery("Users.countAll");
	}

}
