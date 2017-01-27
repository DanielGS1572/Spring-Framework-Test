package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration		// usa un archivo de configuracion
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration	//hace que funcionen los archivos de propiedades
//@Profile("dev")	//--> Los perfiles son para cambiar de ambiente, que por ejemplo apunte a una base de datos diferente --> solo aplica para spring-boot
// por eso se configura en el pom, y usa archivos .properties que estan en resources
public class FileReadingConfiguration
{
  @Bean
  @Autowired
  static PropertySourcesPlaceholderConfigurer propertySourcesPlacholdConfigurer(Environment env)
  {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean							//Creación del bean con cierto Qualifier, para llamarlo se usa autowired y se especifica el Qualifier, ver CrimeReport.java
  @Qualifier("ascReport")
  static CrimeReportResult crimeReportResultAsc()
  {
    return new CrimeReportResult("asc");
  }

  @Bean
  @Qualifier("descReport")
  static CrimeReportResult crimeReportResultDesc()
  {
    return new CrimeReportResult("desc");
  }

  public static void main(String[] args)
  {
    ConfigurableApplicationContext context = SpringApplication.run(FileReadingConfiguration.class, args);	//instruccion especifica de springboot para obtener el contexto
    
    // the application context contains a component model

    // beans -> Component Model -> Application Context -> Spring Framework

    List<CrimeReport> reports = new ArrayList<CrimeReport>();

    reports.add((CrimeReport) context.getBean("crimeReport"));
    reports.add((CrimeReport) context.getBean("crimeReport"));
    reports.add((CrimeReport) context.getBean("crimeReport"));
    reports.add((CrimeReport) context.getBean("crimeReport"));
    reports.add((CrimeReport) context.getBean("crimeReport"));
    reports.add((CrimeReport) context.getBean("crimeReport"));

    for (CrimeReport report : reports)
    {
      report.generateReport();
      System.out.println(report);
    }

    // for (CrimeReportDataRow row : crimeReport.getRows())
    // {
    // System.out.println(row);
    // }
  }
}
