package com.coderscampus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
//git show-branch --al
//git checkout origin/Part-1

//git status
//git add .
//git commit -m "mensaje de branch"
//git push origin HEAD:Part-1

//Este archivo se encargará unicamente de procesar

//Service
//Component
//Controller
//... todos extienden de component y son lo mismo
@Component(value="customName")
public class FileProcessorService {
	// El autowired lo que hace es un new
	// se llama inyección de dependencia porque este objeto
	// (FileProcessorService) depende de otro (FileReadingService)

	// inversion of control es el mecanismo que spring tiene para hacer la
	// inyeccion de dependencias (a traves del container). Es el control que
	// spring tiene sobre los objetos y administrarlos
	
	@Autowired //dependency managed by spring
	FileReadingService frs;

	public void processFile() {
		List<String> lines = frs.readFile("crime_report.csv");
		for (String line : lines) {
			System.out.println(line);
		}
	}
}
