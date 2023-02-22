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
public class EducationResponseDTO  extends EducationRequestDTO{
    
    private Long educationId;

	@Builder
	public EducationResponseDTO(String institution, String degree, String entry,String discharge, Long educationId) {
		super(institution, degree, entry, discharge);
		this.educationId = educationId;		
	}	
}
