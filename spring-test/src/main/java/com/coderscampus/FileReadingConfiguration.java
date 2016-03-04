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
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class FileReadingConfiguration
{
  @Bean
  @Autowired
  static PropertySourcesPlaceholderConfigurer propertySourcesPlacholdConfigurer(Environment env)
  {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
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
    ConfigurableApplicationContext context = SpringApplication.run(FileReadingConfiguration.class, args);
    
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

    // for (CrimeReportDataRow row : crimeReport.getRows())
    // {
    // System.out.println(row);
    // }
  }
}
