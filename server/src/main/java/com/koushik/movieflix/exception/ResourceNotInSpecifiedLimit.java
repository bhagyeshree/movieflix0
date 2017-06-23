package com.koushik.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class ResourceNotInSpecifiedLimit extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotInSpecifiedLimit(String message) {
		super(message);
	}
	
}
