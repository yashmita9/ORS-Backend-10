package com.rays;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rays.common.FrontCtl;

/**
 * Yashmita Rathore
 *
 */
@SpringBootApplication
public class ProjectOrsApplication extends SpringBootServletInitializer {

	@Autowired
	private Environment env;

	@Autowired
	FrontCtl frontCtl;

	public static void main(String[] args) {
		SpringApplication.run(ProjectOrsApplication.class, args);

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		WebMvcConfigurer w = new WebMvcConfigurer() {

			public void addCorsMappings(CorsRegistry registry){
				CorsRegistration cors = registry.addMapping("/**");
				cors.allowedOrigins("http://localhost:4200");
				cors.allowedMethods("GET", "POST", "PUT", "DELETE");
				cors.allowedHeaders("*");
				cors.allowCredentials(true);
			}
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry){
				registry.addResourceHandler("/**").addResourceLocations("classpath:/public/");
			}

		};

		return w;
	}
}
