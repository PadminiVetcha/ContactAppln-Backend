package com.contacts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ContactsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsAppApplication.class, args);
	}
	
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:8080")
//                //.allowedOrigins("http://localhost:3000")
//                .allowedMethods("PUT", "POST", "DELETE", "PATCH");
//            }
//        };
//    }
}
