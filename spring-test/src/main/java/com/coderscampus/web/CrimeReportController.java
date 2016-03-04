package com.coderscampus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderscampus.CrimeReport;

@Controller
public class CrimeReportController
{
  // methods inside a controller will be "invoked" when a user
  //  send a request to a particular URL
  
  @Autowired
  private CrimeReport crimeReport;
  
  @RequestMapping("/crimeReport")
  public String showReport (ModelMap model)
  {
    crimeReport.generateReport();
    model.put("rows", crimeReport.getRows());
    
    // prepended text "src/main/resources/templates/"
    // actual text "report"
    // appended text ".html"
    // final path: src/main/resources/templates/report.html
    
    return "report";
  }
}
