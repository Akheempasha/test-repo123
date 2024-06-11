package com.extent.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report5 {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");
		
		ExtentSparkReporter sparkRepoter = new ExtentSparkReporter(file);
	//	ExtentSparkReporterConfig config = sparkRepoter.config();
		sparkRepoter.config().setTheme(Theme.DARK);
		sparkRepoter.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		sparkRepoter.config().setReportName("Akheem");
		sparkRepoter.config().setDocumentTitle("Automation-Practice");
		sparkRepoter.config().setCss(".badge-primary{background-color: #df6598}");
		sparkRepoter.config().setJs("window.document.getElementsByClassName('logo')[0].style.display='none';");
		
		
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
