package com.koushik.movieflix.service;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koushik.movieflix.entities.LoginEntity;
import com.koushik.movieflix.entities.LoginResponseEntity;
import com.koushik.movieflix.entities.User;
import com.koushik.movieflix.exception.InvalidCredentials;
import com.koushik.movieflix.exception.ResourceNotFoundException;
import com.koushik.movieflix.exception.ResourceNotInSpecifiedLimit;
import com.koushik.movieflix.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> showAllUsers() {
		return repository.showAllUsers();
	}

	@Override
	public User showOneUser(String uid) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		return existing;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		if(user.getEmail()==null || user.getPassword()==null)
		{
			throw new ResourceNotInSpecifiedLimit("Please fill all required fields");
		}
		return repository.createUser(user);
	}

	@Override
	@Transactional
	public User updateUser(String uid, User user) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		return repository.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String uid) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		repository.deleteUser(existing);
	}

	@Override
	public LoginResponseEntity authorizeUser(LoginEntity login) throws ServletException {
        LoginResponseEntity response;
		if(login.getEmail() == null && login.getPassword()==null){
          throw new ServletException("Invalid Username/Password"); 	
        }
        User user = repository.authorizeUser(login.getEmail(), login.getPassword());
        if(user!=null){
        	String token = Jwts.builder().setSubject(login.getEmail())
        			.claim("roles", user.getRole()).setExpiration(new Date((new Date()).getTime() + (30 * 60 * 1000))).setIssuedAt(new Date())
        			.signWith(SignatureAlgorithm.HS256, "movieflix").compact();
        	response = new LoginResponseEntity(user.getEmail(), user.getRole(),user.getFirstName(), user.getLastName(), user.getId(), token);
        }
        else{
        	throw new InvalidCredentials();
        }
		return response;
	}

}
