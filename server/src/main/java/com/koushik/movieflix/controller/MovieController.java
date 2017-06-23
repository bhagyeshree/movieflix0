package com.koushik.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koushik.movieflix.entities.MovieEntity;
import com.koushik.movieflix.service.MovieService;
@RestController
public class MovieController {
	@Autowired
	private MovieService service;
	
	@RequestMapping(method=RequestMethod.GET,value="/titles")
	public List<MovieEntity> showAllMovies(){
		return service.showAllMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/titles/year/{year}")
	public List<MovieEntity> showMovieByYear(@PathVariable("year") String year){
		return service.showByYear(year);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/titles/genre/{genre}")
	public List<MovieEntity> showMovieByGenre(@PathVariable("genre") String genre){
		return service.showByGenre(genre);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/titles/type/{type}")
	public List<MovieEntity> showMovieByType(@PathVariable("type") String type){
		return service.showByType(type);
	}

	@RequestMapping(method=RequestMethod.GET,value="/titles/top/{type}")
	public List<MovieEntity> showMovieByTopType(@PathVariable("type") String type){
		return service.showByTopType(type);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/titles/imdbvotes")
	public List<MovieEntity> showMovieByImdbVotes(){
		return service.showByImdbVotes();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/titles/imdbrating")
	public List<MovieEntity> showMovieByImdbRating(){
		return service.showByImdbRating();
	}
		
	@RequestMapping(method=RequestMethod.GET,value="/titles/{id}")
	public MovieEntity showOneMovie(@PathVariable("id") String mid){
		return service.showOneMovie(mid);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/titles/title/{title}")
	public List<MovieEntity> showMovieByTitle(@PathVariable("title") String title){
		return service.showByTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/admin/titles")	
	public MovieEntity createMovie(@RequestHeader("Authorization") String authorization,@RequestBody MovieEntity movieEntity){
		return service.createMovie(authorization,movieEntity);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/admin/titles/{id}")	
	public MovieEntity updateMovie(@RequestHeader("Authorization") String authorization, @PathVariable("id") String mid,@RequestBody MovieEntity movieEntity){
		return service.updateMovie(authorization,mid, movieEntity);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/admin/titles/{id}")	
    public void deleteMovie(@RequestHeader("Authorization") String authorization, @PathVariable("id") String mid){
		service.deleteMovie(authorization,mid);
    }	
		
}
