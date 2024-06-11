package com.extent.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 


public class Report7 {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports = new ExtentReports();
	//	File file = new File("report.html");
		
		ExtentSparkReporter sparkRepoter = new ExtentSparkReporter("allTest.html");
		ExtentSparkReporter sparkRepoter_Skipped = new ExtentSparkReporter("skipTest.html");
		  sparkRepoter_Skipped.filter().statusFilter()
		                         .as(new Status[] {Status.SKIP,Status.WARNING});
		ExtentSparkReporter sparkRepoter_failed = new ExtentSparkReporter("failTest.html");
		   sparkRepoter_failed.filter().statusFilter()
		            .as(new Status[] {Status.FAIL} );
	 
		
		extentReports.attachReporter(sparkRepoter,sparkRepoter_Skipped,sparkRepoter_failed);
		
		extentReports
		.createTest("Test-1")
		.assignAuthor("Akheem")
		.assignCategory("Smoke")
		.assignDevice("Chrome")
		.pass("This is passed test");
		
		
		extentReports
		.createTest("Test-3","Test Description")
		.assignAuthor("Pasha")
		.assignCategory("Regression")
		.assignDevice("Chrome")
		.fail("This is Failed test");
		
		extentReports
		.createTest("Test-2","Test Description")
		.assignAuthor("Pasha" , "khan","AAHil")
		.assignCategory("Regression")
		.assignDevice("Chrome","Edge")
		.skip("This is Failed test");
		
		extentReports
		.createTest("Test-4")
		.warning("Test is warned");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("allTest.html").toURI());
		Desktop.getDesktop().browse(new File("skipTest.html").toURI());
		Desktop.getDesktop().browse(new File("failTest.html").toURI());


	}

}
