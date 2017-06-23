package com.koushik.movieflix.entities;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Koushik
 *
 */
@Entity
@Table
@EnableTransactionManagement
@NamedQueries({
		@NamedQuery(name="CommentEntity.showAllComments",query="select e from CommentEntity e"),
		@NamedQuery(name="CommentEntity.showCommentsByMovie",query="select e from CommentEntity e where e.movieEntity.id=:mid")
})
public class CommentEntity {
	@Id
	@JsonProperty("CommentId")
	private String id;
	@JsonProperty("Comment")
	@Column(length=5000)
	private String comment;
	@ManyToOne(cascade=CascadeType.DETACH)
	private User user;
	@ManyToOne(targetEntity=MovieEntity.class,cascade=CascadeType.DETACH)
	@JoinColumn(name="MovieEntity_ID", referencedColumnName="id")
	@JsonBackReference
	private MovieEntity movieEntity;
	
	public CommentEntity() {
		this.id=UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MovieEntity getMovieEntity() {
		return movieEntity;
	}

	public void setMovieEntity(MovieEntity movieEntity) {
		this.movieEntity = movieEntity;
	}

	@Override
	public String toString() {
		return "CommentEntity [id=" + id + ", comment=" + comment + ", user=" + user + ", movieEntity=" + movieEntity
				+ "]";
	}		
		
}
