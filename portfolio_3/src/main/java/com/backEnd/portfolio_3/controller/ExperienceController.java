/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.controller;

import com.backEnd.portfolio_3.dto.ExperienceRequestDTO;
import com.backEnd.portfolio_3.dto.ExperienceResponseDTO;
import com.backEnd.portfolio_3.service.ExperienceService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
@CrossOrigin()
public class ExperienceController {
        @Autowired
	private final ExperienceService experienceService;

	public ExperienceController(ExperienceService experienceService) {
		this.experienceService =experienceService;
	}
        
        @GetMapping("/list")
	public List<ExperienceResponseDTO> all() {
		return experienceService.getAll();
	}

	
        
        @PostMapping("/create")
	public ExperienceResponseDTO newExperience(@Valid @RequestBody ExperienceRequestDTO newExperience) {
		return experienceService.save(newExperience);
	}

	@GetMapping("/detail/{id}")
	public ExperienceResponseDTO one(@PathVariable("id") Long experienceId) {
		return experienceService.findById(experienceId);
	}

	//@PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/update/{id}")
	public ExperienceResponseDTO replaceExperience(@Valid @RequestBody ExperienceRequestDTO newProyect, @PathVariable("id") Long experienceId) {
		return experienceService.update(newProyect, experienceId);
	}

	//@PreAuthorize("hasRole('ADMIN')")
         @DeleteMapping("/delete/{id}")
	public void deleteExperience(@PathVariable("id") Long experienceId) {
		experienceService.delete(experienceId);
	}
}
