/**
 * ResourceNotFoundException.java
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoteNotFoundHandlerException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NoteNotFoundHandlerException(String message) {
		super(message);
	}
}
