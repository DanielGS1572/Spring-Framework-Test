package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class FileProcessorService
{
  @Autowired
  FileReadingService frs;
  
  
  public List<CrimeReportDataRow> processFile (String filename)
  {
//	  List<String> lines = frs.readFile("crime_report.csv"); --> en lugar de tener el nombre del archivo en hardcode
//	  se puede tener de forma dinámica (un archivo de propiedades que debe de estar en resources
    List<CrimeReportDataRow> rows = new ArrayList<CrimeReportDataRow>();
    
    List<String> lines = frs.readFile(filename);
    for (String line : lines)
    {
      String[] data = line.split(",");
      if (data.length == 0 || StringUtils.isEmpty(data[0]))		//si el primer elemento de la columna es vacio que no lo pele
      {
        continue;
      }
      rows.add(new CrimeReportDataRow(data));		//Aqui va poblando el objeto CrimeReportDataRow
    }
    
    return rows;
  }
}
