package com.coderscampus.web;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderscampus.CrimeReport;
import com.coderscampus.CrimeReportDataRow;
import com.coderscampus.ReportFormBackingObject;

@Controller
public class CrimeReportController
{
  // methods inside a controller will be "invoked" when a user
  // send a request to a particular URL

  @Autowired
  private CrimeReport crimeReport;
//  @RequestMapping(value = "/crimeReport") Si se tiene esta instruccion sola hace todas las siguientes instrucciones
//  @RequestMapping(value = "/crimeReport", method = RequestMethod.POST)
//  @RequestMapping(value = "/crimeReport", method = RequestMethod.GET)
//  @RequestMapping(value = "/crimeReport", method = RequestMethod.DELETE)
//  @RequestMapping(value = "/crimeReport", method = RequestMethod.HEAD)
//  @RequestMapping(value = "/crimeReport", method = RequestMethod.OPTIONS)
  
  //SE DECALARA UN SOLO @RequestMapping por metodo
  // y este metodo se ejecutara cuando se haga un get
  // el metodo get es lo mismo que introducir la URL y presionar enter (o refresh)
  @RequestMapping(value = "/crimeReport", method = RequestMethod.GET)
  
  public String showReport(ModelMap model)
  {
    crimeReport.generateReport();
    model.put("rows", crimeReport.getRows());
    model.put("rfbo", new ReportFormBackingObject());	// ReportFormBackingObject() --> Es un simple pojo que se agregar al modelo

    // prepended text "src/main/resources/templates/"
    // actual text "report"
    // appended text ".html"
    // final path: src/main/resources/templates/report.html

    return "report";
  }

  @RequestMapping(value = "/crimeReport", method = RequestMethod.POST)
  public String showReportPostAsc(@ModelAttribute("rfbo") ReportFormBackingObject rfbo, ModelMap model)
  {
    String sortingOrder = rfbo.getSortingOrder();
    model.put("rfbo", new ReportFormBackingObject());
    
    List<CrimeReportDataRow> rows = crimeReport.getRows();
    
    if ("asc".equals(sortingOrder))
    {
      Collections.sort(rows, new Comparator<CrimeReportDataRow>()
      {
        @Override
        public int compare(CrimeReportDataRow o1, CrimeReportDataRow o2)
        {
          return o1.getCrimeInstanceNumber().compareTo(o2.getCrimeInstanceNumber());
        }
      });
    }
    else
    {
      Collections.sort(rows, new Comparator<CrimeReportDataRow>()
      {
        @Override
        public int compare(CrimeReportDataRow o1, CrimeReportDataRow o2)
        {
          return o2.getCrimeInstanceNumber().compareTo(o1.getCrimeInstanceNumber());
        }
      });
    }
    
    model.put("rows", rows);

    return "report";
  }
  
  @RequestMapping(value = "/crimeReport", method = RequestMethod.POST, params="sortingBtn=asc") //con params se revisa que es lo que se esta enviando
  public String showReportPostAsc(ModelMap model)
  {
    List<CrimeReportDataRow> rows = crimeReport.getRows();
    model.put("rfbo", new ReportFormBackingObject());
    
    Collections.sort(rows, new Comparator<CrimeReportDataRow>()
    {

      @Override
      public int compare(CrimeReportDataRow o1, CrimeReportDataRow o2)
      {
        return o1.getCrimeInstanceNumber().compareTo(o2.getCrimeInstanceNumber());
      }
    });

    model.put("rows", rows);

    return "report";
  }
  
  @RequestMapping(value = "/crimeReport", method = RequestMethod.POST, params="sortingBtn=desc")
  public String showReportPostDesc(ModelMap model)
  {
    List<CrimeReportDataRow> rows = crimeReport.getRows();
    model.put("rfbo", new ReportFormBackingObject());
    
    Collections.sort(rows, new Comparator<CrimeReportDataRow>()
    {
      @Override
      public int compare(CrimeReportDataRow o1, CrimeReportDataRow o2)
      {
        return o2.getCrimeInstanceNumber().compareTo(o1.getCrimeInstanceNumber());
      }
    });

    model.put("rows", rows);

    return "report";
  }
}
