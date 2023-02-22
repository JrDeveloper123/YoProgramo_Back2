/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backEnd.portfolio_3.service;

import com.backEnd.portfolio_3.dto.ProyectRequestDTO;
import com.backEnd.portfolio_3.dto.ProyectResponseDTO;
import java.util.List;

public interface ProyectService {

	public List<ProyectResponseDTO> getAll();
	
	public ProyectResponseDTO save(ProyectRequestDTO proyectDTO);
	
	public ProyectResponseDTO findById(Long proyectId);
	
	public ProyectResponseDTO update(ProyectRequestDTO proyectDTO, Long proyectId);
	
	public void delete(Long proyectId);
}
