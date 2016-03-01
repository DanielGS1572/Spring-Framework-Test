package com.coderscampus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileProcessorService
{
  @Autowired
  FileReadingService frs;
  
  public void processFile ()
  {
    List<String> lines = frs.readFile("crime_report.csv");
    for (String line : lines)
    {
      System.out.println(line);
    }
  }
}
