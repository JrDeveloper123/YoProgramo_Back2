/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backEnd.portfolio_3.service;

import com.backEnd.portfolio_3.dto.PersonRequestDTO;
import com.backEnd.portfolio_3.dto.PersonResponseDTO;
import java.util.List;

public interface PersonService {

	public List<PersonResponseDTO> getAll();
	
	public PersonResponseDTO save(PersonRequestDTO personDTO);
	
	public PersonResponseDTO findById(Long personId);
	
	public PersonResponseDTO update(PersonRequestDTO personDTO, Long personId);
	
	public void delete(Long personId);
}
