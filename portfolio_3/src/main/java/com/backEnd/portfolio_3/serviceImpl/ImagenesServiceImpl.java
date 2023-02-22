/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.serviceImpl;

import com.backEnd.portfolio_3.dto.ImagenesRequestDTO;
import com.backEnd.portfolio_3.dto.ImagenesResponseDTO;
import com.backEnd.portfolio_3.exception.ImagenesNotFoundException;
import com.backEnd.portfolio_3.model.Imagenes;
import com.backEnd.portfolio_3.repository.ImagenesRepository;
import com.backEnd.portfolio_3.service.ImagenesService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ImagenesServiceImpl implements ImagenesService {

	private final ImagenesRepository imagenesRepository;
	
	public ImagenesServiceImpl(ImagenesRepository imagenesRepository) {
		this.imagenesRepository = imagenesRepository;
	}
	
	private ImagenesResponseDTO toDTO(Imagenes imagenes) {
		return ImagenesResponseDTO.builder().id(imagenes.getId())
				.profile(imagenes.getProfile()).backImage(imagenes.getBackImage())
                                    .proyect1Image(imagenes.getProyect1Image()).proyect2Image(imagenes.getProyect2Image())
                                        .build();
	}
	
	private Imagenes toEntity(ImagenesRequestDTO imagenesDTO) {
		return Imagenes.builder().profile(imagenesDTO.getProfile()).backImage(imagenesDTO.getBackImage())
                                    .proyect1Image(imagenesDTO.getProyect1Image()).proyect2Image(imagenesDTO.getProyect2Image())
                                        .build();
	}
	
	@Override
	public List<ImagenesResponseDTO> getAll() {
		return imagenesRepository.findAll().stream().map(image -> toDTO(image)).collect(Collectors.toList());
	}

	@Override
	public ImagenesResponseDTO save(ImagenesRequestDTO imagenesDTO) {
		Imagenes newImagenes= this.imagenesRepository.save(toEntity(imagenesDTO));
		return toDTO(newImagenes);
	}

	@Override
	public ImagenesResponseDTO findById(Long id) {
		Imagenes imagenes = this.imagenesRepository.findById(id).orElseThrow(() -> new ImagenesNotFoundException(id));
		return toDTO(imagenes);
	}

	@Override
	public ImagenesResponseDTO update(ImagenesRequestDTO imagenesDTO, Long id) {
		return this.imagenesRepository.findById(id).map(image -> {
			image.setProfile(imagenesDTO.getProfile());
			image.setBackImage(imagenesDTO.getBackImage());
                        image.setProyect1Image(imagenesDTO.getProyect1Image());
                        image.setProyect2Image(imagenesDTO.getProyect2Image());
			return toDTO(imagenesRepository.save(image));
		}).orElseGet(() -> {
			Imagenes newImagenes = toEntity(imagenesDTO);
			newImagenes.setId(id);
			return toDTO(this.imagenesRepository.save(newImagenes));
		});
	}

	@Override
	public void delete(Long id) {
		Imagenes imagen = this.imagenesRepository.findById(id).orElseThrow(() -> new ImagenesNotFoundException(id));
		this.imagenesRepository.delete(imagen);
	}

}
