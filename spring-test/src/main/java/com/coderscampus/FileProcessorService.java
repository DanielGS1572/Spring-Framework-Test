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
    List<CrimeReportDataRow> rows = new ArrayList<>();
    
    List<String> lines = frs.readFile(filename);
    for (String line : lines)
    {
      String[] data = line.split(",");
      if (data.length == 0 || StringUtils.isEmpty(data[0]))
      {
        continue;
      }
      rows.add(new CrimeReportDataRow(data));
    }
    
    return rows;
  }
}
