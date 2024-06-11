package com.jsp.wm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class AdminNotFindByIdException extends RuntimeException {
	
	private String message;
	
}
