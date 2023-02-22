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
public class ImagenesResponseDTO extends ImagenesRequestDTO {

	private Long id;

	@Builder
	public ImagenesResponseDTO(String profile,String backImage,String proyect1Image,String proyect2Image, Long id) {
		super( profile,backImage, proyect1Image, proyect2Image);
		this.id =id;		
	}	
}
