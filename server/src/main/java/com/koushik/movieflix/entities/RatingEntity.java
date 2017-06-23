package com.koushik.movieflix.entities;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@EnableTransactionManagement
@NamedQueries({
	@NamedQuery(name="RatingEntity.calculateAverage", query="select AVG(r.rating) from RatingEntity r where r.movie.id=:mId")
})
public class RatingEntity {
	@Id
	@JsonProperty("RatingId")
	private String id;
	
	@JsonProperty("Rating")
	private double rating;
	
	@ManyToOne(targetEntity=User.class,cascade=CascadeType.DETACH)
	@JoinColumn(name="USER_ID", referencedColumnName="id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private MovieEntity movie;
	
	public RatingEntity() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "RatingEntity [id=" + id + ", rating=" + rating + ", user=" + user + ", movie=" + movie + "]";
	}
	
}
