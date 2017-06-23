package com.koushik.movieflix;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@ComponentScan
@EnableWebMvc
public class CORSConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		System.out.println("Loaded CORS");
		registry.addMapping("/**")
		.allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
        .allowedHeaders("Content-Type", "Access-Control-Allow-Origin", "X-Requested-With","Authorization", "Accept", "Origin","Access-Control-Request-Method",
                "Access-Control-Request-Headers")
        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
        .allowCredentials(true).maxAge(3600);
	}	
	
}
