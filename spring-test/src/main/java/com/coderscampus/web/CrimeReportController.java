package com.coderscampus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderscampus.CrimeReport;

//Al controller siempre se le pondra en el nombre la palabra controller para poder identificarlo e ir dentro en un paquete especifico
@Controller
public class CrimeReportController {
	// methods inside a controller will be "invoked" when a user
	// send a request to a particular URL

	@Autowired
	private CrimeReport crimeReport;	// Se instancia el reporteador

	@RequestMapping("/crimeReport") // cuando introduzcan una URL la
									// interceptara y hara match y entrara a
									// este metodo
	public String showReport(ModelMap model) // Cuando se usa ModelMap no se
												// tiene que hacer autowired, de
												// esto se encarga spring
												// (siempre y cuando se le pase
												// como parametro al metodo y la
												// clase tenga la anotacion de
												// controller)
	{
		crimeReport.generateReport();
		model.put("rows", crimeReport.getRows());		//Aqui se mete la información al modelo

		// prepended text "src/main/resources/templates/"
		// actual text "report"
		// appended text ".html"
		// final path: src/main/resources/templates/report.html

		return "report"; // este return regresa la vista que es un HTML o un JSP
							// --> que esta dentro de
							// resources/templates/report.html (spring boot esta
							// configurado que busque por default en esta
							// ubicacion)
		// en el html se va a imprimir el resultado del reporte
	}
}
