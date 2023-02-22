/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.serviceImpl;

import com.backEnd.portfolio_3.dto.ExperienceRequestDTO;
import com.backEnd.portfolio_3.dto.ExperienceResponseDTO;
import com.backEnd.portfolio_3.exception.ExperienceNotFoundException;
import com.backEnd.portfolio_3.model.Experience;
import com.backEnd.portfolio_3.repository.ExperienceRepository;
import com.backEnd.portfolio_3.service.ExperienceService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    
    @Autowired
     private final ExperienceRepository experienceRepository;
    
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
		this.experienceRepository = experienceRepository;
	}
   private ExperienceResponseDTO toDTO(Experience experience) {
        return ExperienceResponseDTO.builder().experienceId(experience.getId())
				.company(experience.getCompany()).currentJob(experience.getCurrentJob())
                                    .description(experience.getDescription()).position(experience.getPosition())
                                        .entry(experience.getEntry()).discharge(experience.getDischarge()).build();
    }

    private Experience toEntity(ExperienceRequestDTO experienceDTO) {
		return Experience.builder().company(experienceDTO.getCompany()).currentJob(experienceDTO.getCurrentJob())
                                    .description(experienceDTO.getDescription()).position(experienceDTO.getPosition())
                                    .entry(experienceDTO.getEntry()).discharge(experienceDTO.getDischarge()).build();
	}
    
         @Override
	public List<ExperienceResponseDTO> getAll() {
		return experienceRepository.findAll().stream().map(exp -> toDTO(exp)).collect(Collectors.toList());
	}

	@Override
	public ExperienceResponseDTO save(ExperienceRequestDTO experienceDTO) {
		Experience newExperience = this.experienceRepository.save(toEntity(experienceDTO));
		return toDTO(newExperience);
	}

	@Override
	public ExperienceResponseDTO findById(Long experienceId) {
		Experience experience = this.experienceRepository.findById(experienceId).orElseThrow(() -> new ExperienceNotFoundException(experienceId));
		return toDTO(experience);
	}

	@Override
	public ExperienceResponseDTO update(ExperienceRequestDTO experienceDTO, Long experienceId) {
		return this.experienceRepository.findById(experienceId).map(experience -> {
			experience.setCompany(experienceDTO.getCompany());
			experience.setCurrentJob(experienceDTO.getCurrentJob());
                        experience.setPosition(experienceDTO.getPosition());
                        experience.setDescription(experienceDTO.getDescription());
                        experience.setEntry(experienceDTO.getEntry());
                        experience.setDischarge(experienceDTO.getDischarge());
			return toDTO(experienceRepository.save(experience));
		}).orElseGet(() -> {
			Experience newExperience = toEntity(experienceDTO);
			newExperience.setId(experienceId);
			return toDTO(this.experienceRepository.save(newExperience));
		});
	}

	@Override
	public void delete(Long experienceId) {
		Experience experience = this.experienceRepository.findById(experienceId).orElseThrow(() -> new ExperienceNotFoundException(experienceId));
		this.experienceRepository.delete(experience);
	}
}