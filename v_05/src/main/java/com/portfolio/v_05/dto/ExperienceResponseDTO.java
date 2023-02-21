/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.v_05.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExperienceResponseDTO  extends ExperienceRequestDTO{
    
    private Long experienceId;

	@Builder
	public ExperienceResponseDTO(String company, int currentJob, String position, String description, String entry, String discharge, Long experienceId) {
		super(company, currentJob, position, description, entry, discharge);
		this.experienceId = experienceId;		
	}	
}