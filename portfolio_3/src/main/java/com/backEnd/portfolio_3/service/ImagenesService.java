/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backEnd.portfolio_3.service;

import com.backEnd.portfolio_3.dto.ImagenesRequestDTO;
import com.backEnd.portfolio_3.dto.ImagenesResponseDTO;
import java.util.List;

public interface ImagenesService {

	public List<ImagenesResponseDTO> getAll();
	
	public ImagenesResponseDTO save(ImagenesRequestDTO usuarioDTO);
	
	public ImagenesResponseDTO findById(Long usuarioId);
	
	public ImagenesResponseDTO update(ImagenesRequestDTO usuarioDTO, Long usuarioId);
	
	public void delete(Long usuarioId);
}
