package com.koushik.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koushik.movieflix.entities.MovieEntity;
import com.koushik.movieflix.entities.User;
import com.koushik.movieflix.exception.ResourceNotFoundException;
import com.koushik.movieflix.exception.ResourceNotInSpecifiedLimit;
import com.koushik.movieflix.exception.UnauthorizedAccessException;
import com.koushik.movieflix.repository.MovieRepository;
import com.koushik.movieflix.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private UserRepository userRepository;

	private MovieEntity result;

	@Override
	public List<MovieEntity> showAllMovies() {
		List<MovieEntity> existing = repository.showAllMovies();
		if (existing == null) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return repository.showAllMovies();
	}

	@Override
	public MovieEntity showOneMovie(String mid) {
		MovieEntity existing = repository.showOneMovie(mid);
		if (existing == null) {
			throw new ResourceNotFoundException("Sorry no movies found with the following reource id " + mid);
		}
		return existing;
	}

	@Override
	@Transactional
	public MovieEntity createMovie(String authorization, MovieEntity movieEntity) {
		if (authorization != null && authorization.startsWith("Bearer ")) {
			String token = authorization.substring(7);
			Claims claims = Jwts.parser().setSigningKey("movieflix").parseClaimsJws(token).getBody();
			String email = claims.getSubject().toString();
			User user = userRepository.showByEmail(email);
			if (user.getRole().equals("Admin")) {
				if (movieEntity.getTitle() == null || movieEntity.getType() == null || movieEntity.getGenre() == null
						|| movieEntity.getCountry() == null || movieEntity.getLanguage() == null) {
					throw new ResourceNotInSpecifiedLimit("Please fill Title, Type, Genre, Country and Language");
				}
				result = repository.createMovie(movieEntity);
			} else {
				throw new UnauthorizedAccessException();
			}
		}
		return result;
	}

	@Override
	@Transactional
	public MovieEntity updateMovie(String authorization, String mid, MovieEntity movieEntity) {
		if (authorization != null && authorization.startsWith("Bearer ")) {
			String token = authorization.substring(7);
			Claims claims = Jwts.parser().setSigningKey("movieflix").parseClaimsJws(token).getBody();
			String email = claims.getSubject().toString();
			User user = userRepository.showByEmail(email);
			if (user.getRole().equals("Admin")) {
				MovieEntity existing = repository.showOneMovie(mid);
				if (existing == null) {
					throw new ResourceNotFoundException("Sorry no movies found with the following id " + mid);
				} else if (movieEntity.getTitle() == null || movieEntity.getType() == null
						|| movieEntity.getGenre() == null || movieEntity.getCountry() == null
						|| movieEntity.getLanguage() == null) {
					throw new ResourceNotInSpecifiedLimit("Please fill Title, Type, Genre, Country and Language");
				}
				result = repository.updateMovie(movieEntity);
			} else {
				throw new UnauthorizedAccessException();
			}
		}
		return result;
	}

	@Override
	@Transactional
	public void deleteMovie(String authorization, String mid) {
		if (authorization != null && authorization.startsWith("Bearer ")) {
			String token = authorization.substring(7);
			Claims claims = Jwts.parser().setSigningKey("movieflix").parseClaimsJws(token).getBody();
			String email = claims.getSubject().toString();
			User user = userRepository.showByEmail(email);
			if (user.getRole().equals("Admin")) {
				System.out.println("entered");
				MovieEntity existing = repository.showOneMovie(mid);
				if (existing == null) {
					throw new ResourceNotFoundException("Sorry no movies found with the following id " + mid);
				}
				repository.deleteMovie(existing);
			} else {
				throw new UnauthorizedAccessException();
			}
		}
	}

	@Override
	public List<MovieEntity> showByYear(String year) {
		List<MovieEntity> movieEntities = repository.showByYear(year);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}

	@Override
	public List<MovieEntity> showByGenre(String genre) {
		List<MovieEntity> movieEntities = repository.showByGenre(genre);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}

	@Override
	public List<MovieEntity> showByType(String type) {
		List<MovieEntity> movieEntities = repository.showByType(type);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}

	@Override
	public List<MovieEntity> showByImdbRating() {
		return repository.showByImdbRating();
	}

	@Override
	public List<MovieEntity> showByImdbVotes() {
		return repository.showByImdbVotes();
	}

	@Override
	public List<MovieEntity> showByTitle(String title) {
		List<MovieEntity> movieEntities = repository.showByTitle(title);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry, No Movies Found with the following title " + title);
		}
		return movieEntities;
	}

	@Override
	public List<MovieEntity> showByTopType(String type) {
		List<MovieEntity> movieEntities = repository.showByTopType(type);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}

}
