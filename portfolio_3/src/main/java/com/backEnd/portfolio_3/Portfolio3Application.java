package com.backEnd.portfolio_3;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Portfolio3Application {

	public static void main(String[] args) {
		SpringApplication.run(Portfolio3Application.class, args);
	}
        /*
    @Bean    
        	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://portfolioarch-3a99e.web.app");
			}
		};
	}
    */            
      @Bean 

  

     public CorsFilter corsFilter() { 

  

         CorsConfiguration corsConfiguration = new CorsConfiguration(); 

  

         corsConfiguration.setAllowCredentials(true); 

  

         corsConfiguration.setAllowedOrigins(Arrays.asList("https://portfolioarch-3a99e.web.app", "http://localhost:4200")); 

  

         corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", 

                 "Accept", "Authorization", "Origin, Accept", "X-Request-With", 

                 "Access-Control-Request-Method", "Access-Control-Request-Headers")); 

  

         corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-type", "Accept", "Authorization", 

                 "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")); 

  

         corsConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS")); 

  

         UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource(); 

  

         urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration); 

  

         return new CorsFilter(urlBasedCorsConfigurationSource); 

  

     } 

 }          
                


