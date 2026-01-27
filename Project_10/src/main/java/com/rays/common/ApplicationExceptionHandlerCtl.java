package com.rays.common;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handles application propagated exceptions
 * 
 * SANAT KUMAR CHOUHAN
 *
 */

@RestControllerAdvice // handle exception globally
public class ApplicationExceptionHandlerCtl {

	// All database related problems
	@ExceptionHandler({ CannotCreateTransactionException.class, DataAccessResourceFailureException.class })
	public ResponseEntity<ORSResponse> handleDatabaseException(Exception e) {

		ORSResponse res = new ORSResponse(false);
		res.addMessage("Database service is currently unavailable. Please try again later.");

		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(res);
	}

	// All other runtime exceptions
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ORSResponse> handleRuntimeException(RuntimeException e) {

		ORSResponse res = new ORSResponse(false);
		res.addMessage(e.getMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	}

}
