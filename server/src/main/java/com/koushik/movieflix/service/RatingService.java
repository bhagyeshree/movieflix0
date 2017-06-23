package com.koushik.movieflix.service;

import com.koushik.movieflix.entities.RatingEntity;

public interface RatingService {

	public RatingEntity createRating(String userId,String movieId,RatingEntity ratingEntity);
	
}
