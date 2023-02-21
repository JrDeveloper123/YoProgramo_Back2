/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.v_05.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationRequestDTO {
    
    @NotBlank
    private String institution;
    @NotBlank    
    private String degree;
    @NotBlank    
    private String entry;
      
    private String discharge;
    
    private String urlInstitution;
    
    private String image;
}
