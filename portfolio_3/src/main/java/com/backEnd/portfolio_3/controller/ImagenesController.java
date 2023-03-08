/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.controller;

import com.backEnd.portfolio_3.dto.ImagenesRequestDTO;
import com.backEnd.portfolio_3.dto.ImagenesResponseDTO;
import com.backEnd.portfolio_3.service.ImagenesService;
import java.util.List;
import javax.validation.Valid;
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
@RequestMapping("/image")
@CrossOrigin(/*origins = {"http://portfolioyoprog.web.app"}*/)
public class ImagenesController {

	private final ImagenesService imagenesService;

	public ImagenesController(ImagenesService imagenesService) {
		this.imagenesService =  imagenesService;
	}

	@GetMapping("/list")
	public List<ImagenesResponseDTO> all() {
		return imagenesService.getAll();
	}

        @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ImagenesResponseDTO newUsuario(@Valid @RequestBody ImagenesRequestDTO newImagenes) {
		return imagenesService.save(newImagenes);
	}

	@GetMapping("/detail/{Id}")
	public ImagenesResponseDTO one(@PathVariable("Id") Long Id) {
		return imagenesService.findById(Id);
	}

        @PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ImagenesResponseDTO replaceImagenes(@Valid @RequestBody ImagenesRequestDTO newImagenes, @PathVariable("id") Long id) {
		return imagenesService.update(newImagenes, id);
	}

        @PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public void deleteImagenes(@PathVariable("id") Long id) {
		imagenesService.delete(id);
	}
}
