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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequestDTO {
	
	@NotBlank
	@Size(max = 15, message = "Person name is too long. Max=15") 
	private String name;
	
	@NotBlank
	@Size(max = 20, message = "Person surname is too long. Max=15")
	private String surname;
        
        @NotBlank
        @Size(max = 40, message = "eMail is too long. Max=40")
	private String mail;
        
        @NotBlank
        @Size(max = 250, message = "About is too long. Max=250")
	private String about;
        
         @NotBlank
	  @Size(max = 200, message = "Degree is too long. Max=100")
	private String degree;
         
         @NotBlank
         @Size(max = 200, message = "Adress is too long. Max=20")
	private String address;
         
         @NotBlank
         private String phone;
        
}
