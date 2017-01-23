package com.coderscampus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  
@ComponentScan //Se encarga de crear el component model
public class FileReadingApp {
	// Como se trata de una clase java lleva public static void main
	// si fuera una clase de java web app no llevaría public static void main

	public static void main(String[] args) {
		// El core de spring tiene un application context
		// Actualmente se usa a traves de anotaciones y ya no se interactua con
		// el application context
		// Antes si se interactuaba directamente y se hacia a traves de un
		// archivo de configuracion xml

		ApplicationContext context = new AnnotationConfigApplicationContext(FileReadingApp.class);

		// the application context contains a component model
		// el component model es como el DOM y contiene todos los objeto que
		// hacen la aplicacion y como los objetos de java interactuan

		// beans -> Component Model -> Application Context -> Spring Framework
		// getBean hace que Spring este consciente de este objeto
		// sprign context se encarga de la instanciacion del objeto (usando las anotaciones)
			//@Component a nivel clase --> esto hace que este en el component model
		FileProcessorService fps = (FileProcessorService) context.getBean("customName");

//		Los beans creados son de tipo singleton, solo hay uno solo
		fps.processFile();
	}
}
