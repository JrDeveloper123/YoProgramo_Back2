/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.v_05.service;

import java.util.List;


public interface ExperienceService {
        public List<ExperienceResponseDTO> getAll();
	
	public ExperienceResponseDTO save(ExperienceRequestDTO experienceDTO);
	
	public ExperienceResponseDTO findById(Long experienceId);
	
	public ExperienceResponseDTO update(ExperienceRequestDTO experienceDTO, Long experienceId);
	
	public void delete(Long experienceId);
}
