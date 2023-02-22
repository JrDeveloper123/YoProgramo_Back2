/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.controller;

import com.backEnd.portfolio_3.dto.EducationRequestDTO;
import com.backEnd.portfolio_3.dto.EducationResponseDTO;
import com.backEnd.portfolio_3.service.EducationService;
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
@RequestMapping("/education")
@CrossOrigin()
public class EducationController {
        
        @Autowired
	private final EducationService educationService;

	public EducationController(EducationService educationService) {
		this.educationService = educationService;
	}

	@GetMapping("/list")
	public List<EducationResponseDTO> all() {
		return educationService.getAll();
	}

        //@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public EducationResponseDTO newEducation(@Valid @RequestBody EducationRequestDTO newEducation) {
		return educationService.save(newEducation);
	}

	@GetMapping("/detail/{id}")
	public EducationResponseDTO one(@PathVariable("id") Long educationId) {
		return educationService.findById(educationId);
	}

        // @PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public EducationResponseDTO replaceEducation(@Valid @RequestBody EducationRequestDTO newProyect, @PathVariable("id") Long educationId) {
		return educationService.update(newProyect, educationId);
	}

       //  @PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public void deleteEducation(@PathVariable("id") Long educationId) {
		educationService.delete(educationId);
	}
}
