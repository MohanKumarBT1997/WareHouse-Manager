package com.jsp.wm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class AddressNotFoundByIdException extends RuntimeException {
	
	private String message;

}
