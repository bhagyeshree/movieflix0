package com.koushik.movieflix.repository;

import com.koushik.movieflix.entities.RatingEntity;

public interface RatingRepository {

	public RatingEntity createRating(String userId,String movieId,RatingEntity ratingEntity);
	
}
