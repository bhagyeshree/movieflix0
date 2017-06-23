package com.koushik.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.koushik.movieflix.entities.MovieEntity;

@Repository
public class MovieRepositoryImpl implements MovieRepository{
	
	@PersistenceContext
	private EntityManager em;
	
		
	@Override
	public List<MovieEntity> showAllMovies() {
		TypedQuery<MovieEntity> query = em.createNamedQuery("MovieEntity.findAll",MovieEntity.class);
		return query.getResultList();
	}
	
	@Override
	public MovieEntity showOneMovie(String mid) {
		return em.find(MovieEntity.class,mid);
	}

	@Override
	public MovieEntity createMovie(MovieEntity movieEntity) {
		em.persist(movieEntity);
		return movieEntity;
	}

	@Override
	public MovieEntity updateMovie(MovieEntity movieEntity) {
		return em.merge(movieEntity);
	}

	@Override
	public void deleteMovie(MovieEntity movieEntity) {
		em.remove(movieEntity);
	}

	@Override
	public List<MovieEntity> showByYear(String year) {
		TypedQuery<MovieEntity> query = em.createNamedQuery("MovieEntity.findTitlesByYear",MovieEntity.class); 
		query.setParameter("mYear", year);
		return query.getResultList();
	}

	@Override
	public List<MovieEntity> showByGenre(String genre) {
		TypedQuery<MovieEntity> query = em.createNamedQuery("MovieEntity.findTitlesByGenre",MovieEntity.class); 
		query.setParameter("mGenre", "%"+genre+"%");
		return query.getResultList();
	}

	@Override
	public List<MovieEntity> showByType(String type) {
		TypedQuery<MovieEntity> query = em.createNamedQuery("MovieEntity.findTitlesByType",MovieEntity.class); 
		query.setParameter("mType", type);
		return query.getResultList();
	}

	@Override
	public List<MovieEntity> showByImdbRating() {
		TypedQuery<MovieEntity> query = em.createNamedQuery("MovieEntity.findTitlesByImdbRating",MovieEntity.class); 
		return query.getResultList();
	}

	@Override
	public List<MovieEntity> showByImdbVotes() {
		TypedQuery<MovieEntity> query = em.createNamedQuery("MovieEntity.findTitlesByImdbVotes",MovieEntity.class); 
		return query.getResultList();
	}

	@Override
	public List<MovieEntity> showByTitle(String title) {
		TypedQuery<MovieEntity> query = em.createNamedQuery("MovieEntity.findTitlesByTitle",MovieEntity.class); 
		query.setParameter("mTitle", "%"+title+"%");
		return query.getResultList();
	}

	@Override
	public List<MovieEntity> showByTopType(String type) {
		TypedQuery<MovieEntity> query = em.createNamedQuery("MovieEntity.findTitlesByTopType",MovieEntity.class); 
		query.setParameter("mTopType", type);
		return query.getResultList();
	}
		
}
