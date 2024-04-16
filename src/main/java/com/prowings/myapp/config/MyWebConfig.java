package com.prowings.myapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prowings.myapp")
@PropertySource("classpath:application.properties")
@Getter
public class MyWebConfig implements WebMvcConfigurer {
	
//	@Value("${url}")
//	private String url;
//	@Value("${uname}")
//	private String uname;
//	@Value("${password}")
//	private String pwd;
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
