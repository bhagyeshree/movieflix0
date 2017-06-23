package com.koushik.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koushik.movieflix.entities.RatingEntity;
import com.koushik.movieflix.service.RatingService;

@RestController
public class RatingController {
	
	@Autowired
	private RatingService service;	
	
	@RequestMapping(method=RequestMethod.POST,value="/ratings/user/{uid}/title/{mid}")
	public RatingEntity createRating(@PathVariable("uid") String userId,@PathVariable("mid") String movieId,@RequestBody RatingEntity ratingEntity){
		return service.createRating(userId, movieId, ratingEntity);
	}
	
}
