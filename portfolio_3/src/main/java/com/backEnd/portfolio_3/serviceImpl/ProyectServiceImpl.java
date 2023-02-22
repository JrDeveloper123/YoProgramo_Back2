/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.serviceImpl;

import com.backEnd.portfolio_3.dto.ProyectRequestDTO;
import com.backEnd.portfolio_3.dto.ProyectResponseDTO;
import com.backEnd.portfolio_3.exception.ProyectNotFoundException;
import com.backEnd.portfolio_3.model.Proyect;
import com.backEnd.portfolio_3.repository.ProyectRepository;
import com.backEnd.portfolio_3.service.ProyectService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectServiceImpl implements ProyectService {
    
        @Autowired
	private final ProyectRepository proyectRepository;
	
	public ProyectServiceImpl(ProyectRepository proyectRepository) {
		this.proyectRepository = proyectRepository;
	}
	
	private ProyectResponseDTO toDTO(Proyect proyect) {
		return ProyectResponseDTO.builder().id(proyect.getId())
				.name(proyect.getName()).detail(proyect.getDetail())
                                    .urlImage(proyect.getUrlImage()).urlProyect(proyect.getUrlProyect()).build();
	}
	
	private Proyect toEntity(ProyectRequestDTO proyectDTO) {
		return Proyect.builder().name(proyectDTO.getName()).detail(proyectDTO.getDetail())
                                    .urlImage(proyectDTO.getUrlImage()).urlProyect(proyectDTO.getUrlProyect()).build();
	}
	
	@Override
	public List<ProyectResponseDTO> getAll() {
		return proyectRepository.findAll().stream().map(em -> toDTO(em)).collect(Collectors.toList());
	}

	@Override
	public ProyectResponseDTO save(ProyectRequestDTO proyectDTO) {
		Proyect newProyect = this.proyectRepository.save(toEntity(proyectDTO));
		return toDTO(newProyect);
	}

	@Override
	public ProyectResponseDTO findById(Long proyectId) {
		Proyect proyect = this.proyectRepository.findById(proyectId).orElseThrow(() -> new ProyectNotFoundException(proyectId));
		return toDTO(proyect);
	}

	@Override
	public ProyectResponseDTO update(ProyectRequestDTO proyectDTO, Long proyectId) {
		return this.proyectRepository.findById(proyectId).map(p -> {
			p.setName(proyectDTO.getName());
			p.setDetail(proyectDTO.getDetail());
                        p.setUrlImage(proyectDTO.getUrlImage());
                        p.setUrlProyect(proyectDTO.getUrlProyect());
                       
			return toDTO(proyectRepository.save(p));
		}).orElseGet(() -> {
			Proyect newProyect = toEntity(proyectDTO);
			newProyect.setId(proyectId);
			return toDTO(this.proyectRepository.save(newProyect));
		});
	}

	@Override
	public void delete(Long proyectId) {
		Proyect proyect = this.proyectRepository.findById(proyectId).orElseThrow(() -> new ProyectNotFoundException(proyectId));
		this.proyectRepository.delete(proyect);
	}

}
