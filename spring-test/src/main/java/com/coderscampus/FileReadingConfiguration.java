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
  @Bean
  @Autowired
  static PropertySourcesPlaceholderConfigurer propertySourcesPlacholdConfigurer(Environment env)
  {
    return new PropertySourcesPlaceholderConfigurer();
  }

  public static void main(String[] args)
  {
    SpringApplication.run(FileReadingConfiguration.class, args);
  }
}
