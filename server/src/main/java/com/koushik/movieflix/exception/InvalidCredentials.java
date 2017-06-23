package com.koushik.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,code=HttpStatus.BAD_REQUEST,reason="Invalid Credentials")
public class InvalidCredentials extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
