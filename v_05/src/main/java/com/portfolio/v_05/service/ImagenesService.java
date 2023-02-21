/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.v_05.service;

import java.util.List;

public interface ImagenesService {

	public List<ImagenesResponseDTO> getAll();
	
	public ImagenesResponseDTO save(ImagenesRequestDTO usuarioDTO);
	
	public ImagenesResponseDTO findById(Long usuarioId);
	
	public ImagenesResponseDTO update(ImagenesRequestDTO usuarioDTO, Long usuarioId);
	
	public void delete(Long usuarioId);
}
