/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.controller;

import com.backEnd.portfolio_3.dto.ProyectRequestDTO;
import com.backEnd.portfolio_3.dto.ProyectResponseDTO;
import com.backEnd.portfolio_3.service.ProyectService;
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
@RequestMapping("/proyect")
@CrossOrigin(origins = "*")
public class ProyectController {
        
        @Autowired
	private final ProyectService proyectService;

	public ProyectController(ProyectService proyectService) {
		this.proyectService = proyectService;
	}

	@GetMapping("/list")
	public List<ProyectResponseDTO> all() {
		return proyectService.getAll();
	}

	//@PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/create")
	public ProyectResponseDTO newProyect(@Valid @RequestBody ProyectRequestDTO newProyect) {
		return proyectService.save(newProyect);
	}

	@GetMapping("/detail/{id}")
	public ProyectResponseDTO one(@PathVariable("id") Long proyectId) {
		return proyectService.findById(proyectId);
	}

	//@PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/update/{id}")
	public ProyectResponseDTO replaceProyect(@Valid @RequestBody ProyectRequestDTO newProyect, @PathVariable("id") Long proyectId) {
		return proyectService.update(newProyect, proyectId);
	}

	//@PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/delete/{id}")
	public void deleteProyect(@PathVariable("id") Long proyectId) {
		proyectService.delete(proyectId);
	}
}