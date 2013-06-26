package com.company.product.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.company.product.dao.UserDAO;
import com.company.product.domain.User;

public class UserDAOImpl implements UserDAO{

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) 
    {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public boolean saveUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean updateUser(User updatedUser) {
		hibernateTemplate.update(updatedUser);
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		return hibernateTemplate.loadAll(User.class);
	}

	@Override
	public void deleteUser(Long id) {
		User user = getUserById(id);
		if(user != null){
			hibernateTemplate.delete(user);
		}
	}

	@Override
	public User getUserById(Long id) {
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}

}
