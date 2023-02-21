/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.v_05.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Imagenes {

	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
       
        @Column(name = "profile")
	private String profile;
	
        
        @Column(name = "backImage")
	private String backImage;
       
        @Column(name = "proyect1Image")
        private String proyect1Image;
        
        
        @Column(name = "proyect2Image")
        private String proyect2Image;
	
	@Builder
	public Imagenes(String profile, String backImage, String proyect1Image, String proyect2Image,Long id) {
		
     		this.profile = profile;
                this.backImage = backImage;
                this.proyect1Image = proyect1Image;
                this.proyect2Image = proyect2Image;
                this.id = id;
	}
}
