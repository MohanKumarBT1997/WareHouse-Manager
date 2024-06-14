package com.jsp.wm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class StorageNotFoundByIdException extends RuntimeException{

	private String message;
}
