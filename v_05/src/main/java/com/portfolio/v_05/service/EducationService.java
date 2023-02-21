/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.v_05.service;

import java.util.List;


public interface EducationService {
    
    
        public List<EducationResponseDTO> getAll();
	
	public EducationResponseDTO save(EducationRequestDTO educationDTO);
	
	public EducationResponseDTO findById(Long educationId);
	
	public EducationResponseDTO update(EducationRequestDTO proyectDTO, Long educationId);
	
	public void delete(Long educationId);
}
