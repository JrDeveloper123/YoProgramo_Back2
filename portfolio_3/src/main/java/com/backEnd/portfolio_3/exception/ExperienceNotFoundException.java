/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExperienceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_MESSAGE = "No experience with id %s found";

	public ExperienceNotFoundException(Long experienceId) {
		super(String.format(ERROR_MESSAGE, experienceId.toString()));
	}	
}
