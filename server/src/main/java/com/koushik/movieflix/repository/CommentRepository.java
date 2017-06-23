package com.koushik.movieflix.repository;

import java.util.List;

import com.koushik.movieflix.entities.CommentEntity;

public interface CommentRepository {

	public List<CommentEntity> showAll();
	
	public List<CommentEntity> showCommentsByMovie(String mid);
	
	public CommentEntity createComment(String userId, String movieId, CommentEntity entity);
	
}
