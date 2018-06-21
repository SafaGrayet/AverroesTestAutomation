package com.Averroes.e2etests;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(format = ("pretty"), 
features = { "src/specs/features/générationID/GénérationID.feature" },
plugin = {
		"html:target/cucumber-html-report", "json:target/cucumber.json", 
		"junit:target/cucumber.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		tags = { "@GenererID" })

	@Test
	public class GenererID extends AbstractTestNGCucumberTests{
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/configs/extent-config.xml"));
	}
	
	}

