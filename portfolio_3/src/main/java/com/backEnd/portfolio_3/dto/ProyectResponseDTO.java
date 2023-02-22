/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProyectResponseDTO extends ProyectRequestDTO {

	private Long proyectid;

	@Builder
	public ProyectResponseDTO(String name, String detail, String urlImage, String urlProyect, Long id) {
		super(name, detail,urlImage, urlProyect);
		this.proyectid = id;		
	}	
}
