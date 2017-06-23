package com.koushik.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.koushik.movieflix.entities.User;
@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> showAllUsers() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll",User.class);
		return query.getResultList();
	}

	@Override
	public User showOneUser(String uid) {
		return em.find(User.class, uid);
	}

	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		em.remove(user);
	}

	@Override
	public User authorizeUser(String email, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.authorize", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		System.out.println(email +" and "+password);
		return query.getSingleResult();
	}

	@Override
	public User showByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.byEmail", User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
