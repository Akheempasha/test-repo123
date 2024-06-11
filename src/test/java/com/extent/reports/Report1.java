package com.extent.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report1 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		Capabilities capab = ((RemoteWebDriver)driver).getCapabilities();
	
		ExtentReports extentReports = new ExtentReports();
		
		extentReports.setSystemInfo("Hostname", "LocalHost");
		extentReports.setSystemInfo("os",System.getProperty("os.name"));
		extentReports.setSystemInfo("Tester name", "Akheem");
		extentReports.setSystemInfo("Browser", capab.getBrowserName()+capab.getBrowserVersion());
		extentReports.setSystemInfo("URL", driver.getCurrentUrl());
		File file = new File("report.html");
		
		// ExtentSparkReporter sparkRepoter = new ExtentSparkReporter("report.html");
		// Approach-2
		ExtentSparkReporter sparkRepoter = new ExtentSparkReporter(file);
		sparkRepoter.config().setTheme(Theme.DARK);
		sparkRepoter.config().setReportName("Testing");
		sparkRepoter.config().setDocumentTitle("Automation testing");
		sparkRepoter.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		sparkRepoter.config().setCss(".badge-primary{background-color:#da0b2b}");
		//sparkRepoter.config().setJs("document.get");
		
		extentReports.attachReporter(sparkRepoter);
		ExtentTest test1 = extentReports.createTest("Test-1");
		test1.pass("This is passed");
		 

		ExtentTest test2 = extentReports.createTest("Test-2");
		test2.log(Status.FAIL, "This is failed");

		extentReports.createTest("Test-3").skip("This is skipped");

		extentReports.flush();

		Desktop.getDesktop().browse(new File("report.html").toURI());

	}

}
