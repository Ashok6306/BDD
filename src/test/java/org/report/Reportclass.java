package org.report;

import java.io.File;
import java.util.LinkedList;
import java.util.List;



import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reportclass {


public static void generateJVMReport(String json) {
	
	File file = new File("C:\\eclipse\\BDDSauceDemo\\Result");
	Configuration con  = new Configuration(file, "Saucedemo purchase verify");
	con.addClassifications("User Id", "001" );
	con.addClassifications("User", "A.K");
	con.addClassifications("Version", "JDK_1.8");
	List<String> li = new LinkedList<String>();
	li.add(json);
	ReportBuilder report = new ReportBuilder(li, con);
	report.generateReports();
}
	
	
	
	
}
