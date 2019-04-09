  package com.paratest.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	   private static ExtentReports extent;
	    private static String reportFileName = "Test-Automaton-Report.html";
	

	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }
	 
	    //Create an extent report instance
	    public static ExtentReports createInstance() {
	   
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\"+reportFileName);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle("Regression report");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("Regression report3");
	 
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	 
	        return extent;
	    }
	 
	   
	 
}
