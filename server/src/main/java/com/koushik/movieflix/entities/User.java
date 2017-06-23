package com.koushik.movieflix.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author Koushik
 *
 */
@Entity
@Table
@EnableTransactionManagement
@NamedQueries({
	@NamedQuery(name="User.findAll", query="select u from User u"),
	@NamedQuery(name="User.authorize", query="select u from User u where u.email=:email and u.password=:password"),
	@NamedQuery(name="User.byEmail", query="select u from User u where u.email=:email")
})
public class User {
	@Id
	@JsonProperty("UserId")
	private String id;
	@JsonProperty("FirstName")
	private String firstName;
	@JsonProperty("LastName")
	private String lastName;
	@Column(unique=true)
	@JsonProperty(access=Access.WRITE_ONLY)
	private String email;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	private String role;
	
	@OneToMany(mappedBy="user",orphanRemoval=true,cascade=CascadeType.REMOVE)
	private List<CommentEntity> commentEntities; 
	
	@OneToMany(mappedBy="user",orphanRemoval=true,cascade=CascadeType.REMOVE)
	private List<RatingEntity> ratingEntities; 
	
	public User() {
		this.id = UUID.randomUUID().toString();
		this.role="User";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
    
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}
	
}
