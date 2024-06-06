package com.jsp.wm.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.wm.exception.IllegalOperationException;

@RestControllerAdvice
public class ApplicationHandler {

	@SuppressWarnings("unchecked")
	private ResponseEntity<ErrorStructure<String>> errorResponse(HttpStatus status,String message,String rootCause){

		return ResponseEntity.status(status).body(new ErrorStructure()
				.setStatus(status.value())
				.setMessage(message)
				.setRootCause(rootCause)
				);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> illegalOperationException(IllegalOperationException exception){
		return errorResponse(HttpStatus.FORBIDDEN, exception.getMessage(), "Only one super_admin is allowed");
	}
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<Map<String,String>>> IllegalOperationException(MethodArgumentNotValidException exception){
		List<ObjectError> allErrors = exception.getAllErrors();
		
		Map<String,String> errorList = new HashMap<>();
		allErrors.forEach(error-> {
			FieldError fieldError = (FieldError) error;
			String field = fieldError.getField();
			String defaultMessage = fieldError.getDefaultMessage();
			errorList.put(field, defaultMessage);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorStructure().setStatus(HttpStatus.BAD_REQUEST.value())
						.setMessage("Invalid Value")
						.setRootCause(errorList));
	}
}
