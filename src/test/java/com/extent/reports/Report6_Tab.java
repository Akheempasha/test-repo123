package com.extent.reports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class Report6_Tab {

	public static void main(String[] args)throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkRepoter = new ExtentSparkReporter(file);
		sparkRepoter.viewConfigurer().viewOrder()
		.as(new ViewName[] {
				ViewName.DASHBOARD,
				ViewName.TEST,
				ViewName.CATEGORY,
				ViewName.EXCEPTION,
				ViewName.DEVICE,
				ViewName.AUTHOR});
		
		
		extentReports.attachReporter(sparkRepoter);
		
		extentReports
		.createTest("Test-1")
		.assignAuthor("Akheem")
		.assignCategory("Smoke")
		.assignDevice("Chrome")
		.pass("This is passed test");
		
		
		extentReports
		.createTest("Test-2","Test Description")
		.assignAuthor("Pasha")
		.assignCategory("Regression")
		.assignDevice("Chrome")
		.fail("This is Failed test");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
