package com.ead.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ead.pojo.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		if(sessionFactory == null){
			System.out.println("sess Fac is null");
		}
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public User logIn(User user) {
		Query query = getSession()
				.createQuery("from User u where u.name = :name and u.password = :pass");
		query.setParameter("name", user.getName());
		query.setParameter("pass", user.getPassword());
		List<User> list = query.list();
		
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public boolean checkUserExists(User user) {
		Query query = getSession()
				.createQuery("select count(*) from User u where u.name = :name");
		query.setParameter("name", user.getName());
		Long count = (Long) query.uniqueResult();
		
		return count > 0;
	}

	@Override
	public boolean addUser(User user) {
		int changedRows = (Integer) getSession().save(user);
		return changedRows != 1;
	}

}
