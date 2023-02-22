/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.model;

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
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(name = "company", length = 25)
    private String company;
    
    @Column(name = "currentJob")
    private int currentJob;
    
    @Column(name = "descrption", length = 200)
    private String description;
    
    @Column(name = "position", length = 25)
    private String position;
    
    @Column(name = "entry")
    private String entry;
    
    @Column(name = "discharge")
    private String discharge;
    
     @Builder
	public Experience( Long id,String company, int currentJob, String description, String position, String entry, String discharge) {
		this.id = id;
		this.company = company;
		this.currentJob = currentJob;
                this.description =description;
                this.position = position;
                this.entry = entry;
                this.discharge = discharge;
                
	}
}