package com.koushik.movieflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.koushik.movieflix.entities.MovieEntity;
import com.koushik.movieflix.entities.RatingEntity;
import com.koushik.movieflix.entities.User;

@Repository
public class RatingRepositoryImpl implements RatingRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public RatingEntity createRating(String userId, String movieId, RatingEntity ratingEntity) {
		User userEntity = em.find(User.class, userId);
		MovieEntity movieEntity = em.find(MovieEntity.class, movieId);
		ratingEntity.setUser(userEntity);
		ratingEntity.setMovie(movieEntity);
		em.persist(ratingEntity);
		Query query = em.createNamedQuery("RatingEntity.calculateAverage");
		query.setParameter("mId", movieId);
		double rating = (double) query.getSingleResult();
		double avgRating = Math.round(rating * 10.0) / 10.0;
		movieEntity.setAvgRating(avgRating);
		em.merge(movieEntity);
		return ratingEntity;
	}

}
