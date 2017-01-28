package com.coderscampus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class FileReadingConfiguration
{
	
	//El modelo vista controlador va muy de la mano con web applications
	// Usuario (usa) --> controlador (manipula) --> Modelo (Actualiza) --> vista (Vee) --> Usuario
	// el usuario envia una peticion a traves de la URL (a traves de esta petición se ve si esta mapeada a un controlador)
	// el controller (@Controller a nivel clase) intercepta web requests y se mapea con algun metodo a traves de @RequestMapping("/login") y regularmente esta en un metodo. Puede estar a nivel clase 
	// el modelo usa el ModelMap es como un hashmap o un diccionario de datos. Ahí guarda todos los objetos. El modelo puede ir vacio
	// la vista presenta lo que contiene el ModelMap y es un HTML o un JSP. Thymeleaf es un framework que puede inyectar objetos en HTML
  @Bean
  @Autowired
  static PropertySourcesPlaceholderConfigurer propertySourcesPlacholdConfigurer(Environment env)
  {
    return new PropertySourcesPlaceholderConfigurer();
  }

  public static void main(String[] args)
  {
	  //Regularmente si se esta construyendo una aplicación web no se interactua directamente de inmediato con el contexto
    SpringApplication.run(FileReadingConfiguration.class, args);
  }
}
