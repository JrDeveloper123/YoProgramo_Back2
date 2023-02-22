/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.serviceImpl;

import com.backEnd.portfolio_3.dto.EducationRequestDTO;
import com.backEnd.portfolio_3.dto.EducationResponseDTO;
import com.backEnd.portfolio_3.exception.EducationNotFoundException;
import com.backEnd.portfolio_3.model.Education;
import com.backEnd.portfolio_3.repository.EducationRepository;
import com.backEnd.portfolio_3.service.EducationService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService{
    @Autowired
    private final EducationRepository educationRepository;
    
    public EducationServiceImpl(EducationRepository educationRepository) {
		this.educationRepository = educationRepository;
	}
   private EducationResponseDTO toDTO(Education education) {
        return EducationResponseDTO.builder().educationId(education.getId())
				.institution(education.getInstitution()).degree(education.getDegree())
                                    .entry(education.getEntry()).discharge(education.getDischarge()).build();
    }

    private Education toEntity(EducationRequestDTO educationDTO) {
		return Education.builder().institution(educationDTO.getInstitution()).degree(educationDTO.getDegree())
                                    .entry(educationDTO.getEntry()).discharge(educationDTO.getDischarge()).build();
	}
    
    @Override
	public List<EducationResponseDTO> getAll() {
		return educationRepository.findAll().stream().map(em -> toDTO(em)).collect(Collectors.toList());
	}

	@Override
	public EducationResponseDTO save(EducationRequestDTO educationDTO) {
		Education newEducation = this.educationRepository.save(toEntity(educationDTO));
		return toDTO(newEducation);
	}

	@Override
	public EducationResponseDTO findById(Long educationId) {
		Education education = this.educationRepository.findById(educationId).orElseThrow(() -> new EducationNotFoundException(educationId));
		return toDTO(education);
	}

	@Override
	public EducationResponseDTO update(EducationRequestDTO educationDTO, Long educationId) {
		return this.educationRepository.findById(educationId).map(education -> {
			education.setInstitution(educationDTO.getInstitution());
			education.setDegree(educationDTO.getDegree());
                        education.setEntry(educationDTO.getEntry());
                        education.setDischarge(educationDTO.getDischarge());
			return toDTO(educationRepository.save(education));
		}).orElseGet(() -> {
			Education newEducation = toEntity(educationDTO);
			newEducation.setId(educationId);
			return toDTO(this.educationRepository.save(newEducation));
		});
	}

	@Override
	public void delete(Long educationId) {
		Education education = this.educationRepository.findById(educationId).orElseThrow(() -> new EducationNotFoundException(educationId));
		this.educationRepository.delete(education);
	}

}
