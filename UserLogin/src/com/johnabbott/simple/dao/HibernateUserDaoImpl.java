package com.johnabbott.simple.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import com.johnabbott.simple.model.UserEntity;

@Repository
public class HibernateUserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertUser(UserEntity user) {
		sessionFactory.getCurrentSession().save(user);
		return 1;
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();

	}

	@Override
	public List<UserEntity> getUsers() {
		return getSession().createQuery("from UserEntity", UserEntity.class).list();
	}

	@Override
	public UserEntity getUserById(int userId) {
		return (UserEntity) getSession().get(UserEntity.class, userId);
	}

	@Override
	public UserEntity getUserByEmail(String email) {
		String hql = "from UserEntity where email= :email";

		Query query = getSession().createQuery(hql);

		query.setParameter("email",email);

		if (query.list().size() > 0) {

			return (UserEntity)query.list().get(0);

		}

		else {

			return null;

		}
	}

}
