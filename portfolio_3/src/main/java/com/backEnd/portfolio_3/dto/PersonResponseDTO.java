/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PersonResponseDTO extends PersonRequestDTO {

	private Long personId;

	@Builder
	public PersonResponseDTO(String name, String surname, String mail, String about,String degree,String address,String phone, Long personId) {
		super(name, surname, mail, about, degree, address, phone);
		this.personId = personId;		
	}	
}
