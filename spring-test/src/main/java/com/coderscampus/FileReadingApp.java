package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties") // se puede hacer inyeccion
													// en tiempo de ejecución a
													// través de un archivo de
													// propiedades
public class FileReadingApp {

	@Bean //Este bean debe de existir pues va de la mano con la anotacion de @PropertySource
	static PropertySourcesPlaceholderConfigurer propertySourcesPlacholdConfigurer() // el
																					// bean
																					// se
																					// declara
																					// como
																					// estatico
																					// pues
																					// el
																					// metodo
																					// main
																					// es
																					// estatico
	{
		return new PropertySourcesPlaceholderConfigurer();		// Esto prepara para la lectura del archivo, pero falta algo para hacer uso de...[FileProcessorService.java*]	
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(FileReadingApp.class);

		// the application context contains a component model

		// beans -> Component Model -> Application Context -> Spring Framework

		List<CrimeReport> reports = new ArrayList<CrimeReport>();
		
		CrimeReport crimeReport = (CrimeReport) context.getBean("crimeReport");
		crimeReport.generateReport();
		
		reports.add((CrimeReport) context.getBean("crimeReport"));		//crea una instancia de CrimeReport
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));
		reports.add((CrimeReport) context.getBean("crimeReport"));

		for (CrimeReport report : reports) {
			report.generateReport();
			System.out.println(report);
		}

		// for (CrimeReportDataRow row : crimeReport.getRows())
		// {
		// System.out.println(row);
		// }
	}
}
