/**
 * GlobalExceptionHandler.java
 * @author Gener Badenas
 * Date Created: Mar 25, 2024
 */
package com.ota.api.handler;

import java.util.Date;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.ota.api.model.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoteNotFoundHandlerException.class)
    public ResponseEntity<?> resourceNotFoundException(NoteNotFoundHandlerException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler({  MethodArgumentTypeMismatchException.class,
        TypeMismatchException.class })
    public final ResponseEntity<ErrorDetails> handleMismatchException(Exception ext, WebRequest request) {
    	 ErrorDetails errorDetails = new ErrorDetails(new Date(), "Mismatch: Invalid Note Id", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }
}