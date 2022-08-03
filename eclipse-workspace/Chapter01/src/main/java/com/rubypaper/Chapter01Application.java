package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.rubypaper","com.multicampus"})
public class Chapter01Application {

	public static void main(String[] args) {
		//SpringApplication.run(Chapter01Application.class, args);
		SpringApplication application = new SpringApplication(Chapter01Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
