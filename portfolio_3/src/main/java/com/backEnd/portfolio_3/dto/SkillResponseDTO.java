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
public class SkillResponseDTO extends SkillRequestDTO {

	private Long Id;

	@Builder
	public SkillResponseDTO(String technology, int percentage, Long skillId) {
		super(technology, percentage);
		this.Id = skillId;		
	}	
}
