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
public class Person {

	 @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(name = "name", length = 15)
	private String name;
	
	@Column(name = "surname", length = 20)
	private String surname;
        
        @Column(name = "mail")
	private String mail;
        
        @Column(name = "about", length = 250)
	private String about;
        
        @Column(name = "degree", length = 200)
	private String degree;
         
        @Column(name = "adress")
	private String address;
        
        @Column(name= "phone")
        private String phone;
	
	@Builder
	public Person(String name, String surname,String mail, String about, String degree,String address,String phone,Long id) {
		this.id = id;
		this.name = name;
		this.surname = surname;
                this.mail = mail;
                this.about = about;
                this.degree = degree;
                this.address = address;
                this.phone = phone;
	}
}