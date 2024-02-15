package com.review.tfg.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.review.tfg.dto.auth.response.ErrorDetailsResponse;
import com.review.tfg.error.exception.BadTokenException;
import com.review.tfg.error.exception.CantCreateUserException;
import com.review.tfg.error.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
     * ###################################################
     * #       Conflictos al crear usuarios - 409       ##
     * ###################################################
     * @param ex
     * @param request
     * @return ErrorDetailsResponse
     */
    @ExceptionHandler(CantCreateUserException.class)
    public ResponseEntity<ErrorDetailsResponse> handleCantCreateUserException(CantCreateUserException ex, WebRequest request) {
    	ErrorDetailsResponse errorDetails = new ErrorDetailsResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

	/**
     * ###################################################
     * #        No se encuentra el usuario - 404        ##
     * ###################################################
     * @param ex
     * @param request
     * @return ErrorDetailsResponse
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetailsResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
    	ErrorDetailsResponse errorDetails = new ErrorDetailsResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

	/**
     * ###################################################
     * #        No se encuentra el usuario - 404        ##
     * ###################################################
     * @param ex
     * @param request
     * @return ErrorDetailsResponse
     */
    @ExceptionHandler(BadTokenException.class)
    public ResponseEntity<ErrorDetailsResponse> handleBadTokenException(BadTokenException ex, WebRequest request) {
    	ErrorDetailsResponse errorDetails = new ErrorDetailsResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
    
}
