package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CrimeReport
{
  private List<CrimeReportDataRow> rows = new ArrayList<>();
  
  @Value("${report.filename}")
  private String filename;
  
  private FileProcessorService fileProcessorService;
  
  public void generateReport () 
  {
    System.out.println("Loading filename: " + filename);
    this.setRows(fileProcessorService.processFile(filename));
  }
  
  public List<CrimeReportDataRow> getRows()
  {
    return rows;
  }

  public void setRows(List<CrimeReportDataRow> rows)
  {
    this.rows = rows;
  }

  @Autowired
  public void setFileProcessorService(FileProcessorService fileProcessorService)
  {
    this.fileProcessorService = fileProcessorService;
  }
  
  
}
