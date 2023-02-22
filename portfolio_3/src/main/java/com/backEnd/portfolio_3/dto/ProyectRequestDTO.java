/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectRequestDTO {
	
	@NotBlank
	@Size(max = 50, message = "Proyect name is too long. Max=50") 
	private String name;
	
	@NotBlank
	@Size(max = 250, message = "Proyect detail is too long. Max=250")
	private String detail;
        
        private String urlImage;
        @URL
        private String urlProyect;
}
