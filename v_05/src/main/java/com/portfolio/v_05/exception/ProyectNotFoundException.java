/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.v_05.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProyectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_MESSAGE = "No proyect with id %s found";

	public ProyectNotFoundException(Long proyectId) {
		super(String.format(ERROR_MESSAGE, proyectId.toString()));
	}	
}