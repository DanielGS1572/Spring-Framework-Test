package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component		//esto hace que este dentro del contexto de spring
@Scope("prototype")
//@Autowired no se permite a nivel clase
public class CrimeReport
{
	
	//Con spring no se debe de poner logica dentro del constructor!!
  private List<CrimeReportDataRow> rows = new ArrayList<CrimeReportDataRow>();
  
  @Value("${report.filename}")		//inyeccion en runtime
  private String filename;
  
  //AQUI NO TIENE LA ANOTACION DE @autowired porque en vez que este en la propiedad puede estar en el setter method	
  //ver que recibo como parametro esta misma propiedad
  private FileProcessorService fileProcessorService;
  
  public void generateReport () 
  {
    this.setRows(fileProcessorService.processFile(filename));		//filename viene del archivo de propiedades	
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
