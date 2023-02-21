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
public class Proyect {

	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "detail", length = 250)
	private String detail;
        
        @Column(name = "urlImage")
	private String urlImage;
        
        @Column(name = "urlProyect")
	private String urlProyect;
        
        
	
	@Builder
	public Proyect(String name, String detail, String urlImage, String urlProyect, Long id) {
		this.id = id;
		this.name = name;
		this.detail = detail;
                this.urlImage = urlImage;
                this.urlProyect = urlProyect;
                
	}
}