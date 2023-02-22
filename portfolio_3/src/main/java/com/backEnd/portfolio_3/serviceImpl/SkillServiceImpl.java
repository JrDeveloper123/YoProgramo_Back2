/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.serviceImpl;

import com.backEnd.portfolio_3.dto.SkillRequestDTO;
import com.backEnd.portfolio_3.dto.SkillResponseDTO;
import com.backEnd.portfolio_3.exception.SkillNotFoundException;
import com.backEnd.portfolio_3.model.Skill;
import com.backEnd.portfolio_3.repository.SkillRepository;
import com.backEnd.portfolio_3.service.SkillService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
    
        @Autowired
	private final SkillRepository skillRepository;
	
	public SkillServiceImpl(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}
	
	private SkillResponseDTO toDTO(Skill skill) {
		return SkillResponseDTO.builder().skillId(skill.getId())
				.technology(skill.getTechnology()).percentage(skill.getPercentage())
                                   .build();
	}
	
	private Skill toEntity(SkillRequestDTO skillDTO) {
		return Skill.builder().technology(skillDTO.getTechnology()).percentage(skillDTO.getPercentage())
                                    .build();
	}
	
	@Override
	public List<SkillResponseDTO> getAll() {
		return skillRepository.findAll().stream().map(skl -> toDTO(skl)).collect(Collectors.toList());
	}

	@Override
	public SkillResponseDTO save(SkillRequestDTO skillDTO) {
		Skill newSkill = this.skillRepository.save(toEntity(skillDTO));
		return toDTO(newSkill);
	}

	@Override
	public SkillResponseDTO findById(Long skillId) {
		Skill skill = this.skillRepository.findById(skillId).orElseThrow(() -> new SkillNotFoundException(skillId));
		return toDTO(skill);
	}

	@Override
	public SkillResponseDTO update(SkillRequestDTO skillDTO, Long skillId) {
		return this.skillRepository.findById(skillId).map(skill -> {
			skill.setTechnology(skillDTO.getTechnology());
			skill.setPercentage(skillDTO.getPercentage());
      			return toDTO(skillRepository.save(skill));
		}).orElseGet(() -> {
			Skill newSkill = toEntity(skillDTO);
			newSkill.setId(skillId);
			return toDTO(this.skillRepository.save(newSkill));
		});
	}

	@Override
	public void delete(Long skillId) {
		Skill skill = this.skillRepository.findById(skillId).orElseThrow(() -> new SkillNotFoundException(skillId));
		this.skillRepository.delete(skill);
	}

}