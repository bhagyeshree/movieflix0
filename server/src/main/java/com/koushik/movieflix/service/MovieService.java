package com.koushik.movieflix.service;

import java.util.List;


import com.koushik.movieflix.entities.MovieEntity;

public interface MovieService {

	public List<MovieEntity> showAllMovies();
	
	public List<MovieEntity> showByYear(String year);
	
	public List<MovieEntity> showByTitle(String title);
	
	public List<MovieEntity> showByGenre(String genre);
	
	public List<MovieEntity> showByType(String type);
	
	public List<MovieEntity> showByTopType(String type);
	
	public List<MovieEntity> showByImdbRating();
	
	public List<MovieEntity> showByImdbVotes();
	
	public MovieEntity showOneMovie(String mid);
	
	public MovieEntity createMovie(String authorization, MovieEntity movieEntity);
	
	public MovieEntity updateMovie(String authorization, String id, MovieEntity movieEntity);
	
	public void deleteMovie(String authorization,String mid);
	
	
}
