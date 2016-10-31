package com.bancker.ergosoft;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class ErgosoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErgosoftApplication.class, args);
	}

	@Bean
	CommandLineRunner init(@Value("${fileManagement.rootPath}") String ROOT) {
		return (String[] args) -> {
			new File(ROOT).mkdir();
		};
	}

	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
		registration.addUrlMappings("/h2console/*");
		registration.addInitParameter("webAllowOthers", "true");
		return registration;
	}

}
