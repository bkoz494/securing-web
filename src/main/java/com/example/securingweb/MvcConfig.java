package com.example.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	//dodajemy wyglądy stron z resources/templates np. home.html, hello.html itd
	public void addViewControllers(ViewControllerRegistry registry) {
		//w parametrze addViewController definujemy ścieżke, dla której będzie wyświetlany
		//widok ustawiany w setViewName
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
	}

}