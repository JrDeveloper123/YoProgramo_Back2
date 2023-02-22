/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ImagenesNotFoundException extends RuntimeException {

	private static final long id = 1L;
	
	private static final String ERROR_MESSAGE = "No user with id  found";

	public ImagenesNotFoundException(Long id) {
		super(String.format(ERROR_MESSAGE, id.toString()));
	}	
}
