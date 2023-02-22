/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backEnd.portfolio_3.service;

import com.backEnd.portfolio_3.dto.SkillRequestDTO;
import com.backEnd.portfolio_3.dto.SkillResponseDTO;
import java.util.List;

public interface SkillService {
    
	public List<SkillResponseDTO> getAll();
	
	public SkillResponseDTO save(SkillRequestDTO skillDTO);
	
	public SkillResponseDTO findById(Long skillId);
	
	public SkillResponseDTO update(SkillRequestDTO skillDTO, Long skillId);
	
	public void delete(Long skillId);
}
