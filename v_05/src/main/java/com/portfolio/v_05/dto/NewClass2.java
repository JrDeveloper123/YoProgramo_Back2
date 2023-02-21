/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.v_05.dto;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagenesRequestDTO {
	
	
        @URL
	private String profile;
	
        @URL	
	private String backImage;
       
        @URL
        private String proyect1Image;
       
        @URL
        private String proyect2Image;
}
