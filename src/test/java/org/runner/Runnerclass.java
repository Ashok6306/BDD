package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.Reportclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\eclipse\\BDDSauceDemo\\src\\test\\resources\\Feature\\saucedemo.feature",glue = "org.step",plugin = {"html:Result\\htmlReport", "junit:Result\\junitReport.xml", "json:Result\\jsonReport.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runnerclass{
	@AfterClass
	public static void report() {
		
		Reportclass.generateJVMReport("Result\\jsonReport.json");
	}
}