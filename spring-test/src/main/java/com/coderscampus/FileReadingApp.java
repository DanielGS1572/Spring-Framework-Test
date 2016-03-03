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
@PropertySource("classpath:application.properties")
public class FileReadingApp
{
  
  @Bean
  static PropertySourcesPlaceholderConfigurer propertySourcesPlacholdConfigurer ()
  {
    return new PropertySourcesPlaceholderConfigurer();
  }
  
  public static void main (String[] args)
  {
    ApplicationContext context = new AnnotationConfigApplicationContext(FileReadingApp.class);
    
    // the application context contains a component model
    
    // beans -> Component Model -> Application Context -> Spring Framework
    
    List<CrimeReport> reports = new ArrayList<>();
    
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
    
//    for (CrimeReportDataRow row : crimeReport.getRows())
//    {
//      System.out.println(row);
//    }
  }
}
