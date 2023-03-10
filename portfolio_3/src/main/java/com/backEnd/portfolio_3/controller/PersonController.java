
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.controller;

import com.backEnd.portfolio_3.dto.PersonRequestDTO;
import com.backEnd.portfolio_3.dto.PersonResponseDTO;
import com.backEnd.portfolio_3.service.PersonService;
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

@RestController
@CrossOrigin()
@RequestMapping("/person")

public class PersonController {
        
        @Autowired
	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/list")
	public List<PersonResponseDTO> all() {
		return personService.getAll();
	}

	@PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/create")
	public PersonResponseDTO newPerson(@Valid @RequestBody PersonRequestDTO newPerson) {
		return personService.save(newPerson);
	}

	@GetMapping("/detail/{id}")
	public PersonResponseDTO one(@PathVariable("id") Long personId) {
		return personService.findById(personId);
	}

	@PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/update/{id}")
	public PersonResponseDTO replacePerson(@Valid @RequestBody PersonRequestDTO newPerson, @PathVariable("id") Long personId) {
		return personService.update(newPerson, personId);
	}

	@PreAuthorize("hasRole('ADMIN')")
         @DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable("id") Long personId) {
		personService.delete(personId);
	}
        
        
        
}
