/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


 

@Configuration
@EnableWebMvc
public class WebConfiguration  implements WebMvcConfigurer{
    @Override
    
    public void addCorsMappings(CorsRegistry registry){
       
        registry.addMapping("/**").allowedOrigins("https://portfolioarch-3a99e.firebaseapp.com/").allowedMethods("*").allowedHeaders("*");
        
    }
    
}



