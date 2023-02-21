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
import javax.validation.constraints.NotBlank;
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
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "institution", length = 25)
    private String institution;
    
    @Column(name = "degree", length = 55)
    private String degree;
        
    @Column(name = "entry")
    private String entry;
    
    @Column(name = "discharge")
     private String discharge;
   
    @Column(name = "urlInstitution")
     private String urlInstitution;
    
    @Column(name = "image")
     private String image;
    
    
    
    @Builder
	public Education(String institution, String degree, String entry, String discharge,String urlInstitution,String image, Long id) {
		this.id = id;
		this.institution = institution;
		this.degree = degree;
                this.entry = entry;
                this.discharge = discharge;
                this.urlInstitution = urlInstitution;
                this.image= image;
                
	}
}