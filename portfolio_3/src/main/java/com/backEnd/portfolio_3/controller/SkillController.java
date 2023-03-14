/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.controller;

import com.backEnd.portfolio_3.dto.SkillRequestDTO;
import com.backEnd.portfolio_3.dto.SkillResponseDTO;
import com.backEnd.portfolio_3.service.SkillService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins= "https://portfolioarch-3a99e.web.app")
@RestController
@RequestMapping("/skill")

public class SkillController {
        
        @Autowired
	private final SkillService skillService;

	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}

	@GetMapping("/list")
	public List<SkillResponseDTO> all() {
		return skillService.getAll();
	}

	@PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/create")
	public SkillResponseDTO newSkill(@Valid @RequestBody SkillRequestDTO newSkill) {
		return skillService.save(newSkill);
	}

	@GetMapping("/detail/{id}")
	public SkillResponseDTO one(@PathVariable("id") Long skillId) {
		return skillService.findById(skillId);
	}

	@PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/update/{id}")
	public SkillResponseDTO replaceSkill(@Valid @RequestBody SkillRequestDTO newSkill, @PathVariable("id") Long skillId) {
		return skillService.update(newSkill, skillId);
	}

	@PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/delete/{id}")
	public void deleteSkill(@PathVariable("id") Long skillId) {
		skillService.delete(skillId);
	}
}