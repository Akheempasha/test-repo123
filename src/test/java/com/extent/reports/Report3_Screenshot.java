package com.extent.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report3_Screenshot {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		driver = new ChromeDriver();
		Capabilities capab = ((RemoteWebDriver)driver).getCapabilities();
		driver.get("https://www.google.co.in");
		
		ExtentReports exReport = new ExtentReports();
		exReport.setSystemInfo("Hostname", "LocalHost");
		exReport.setSystemInfo("os",System.getProperty("os.name"));
		exReport.setSystemInfo("Tester name", "Akheem");
		exReport.setSystemInfo("Browser", capab.getBrowserName()+capab.getBrowserVersion());
		exReport.setSystemInfo("URL", driver.getCurrentUrl());
		
		File file = new File("report.html");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		exReport.attachReporter(sparkReport);
		
		
		
		String savefile = capturescreenShot("./screenshot\\google.img");
		
		
		exReport
		.createTest("Screenshot 1","This is attached the screenshot")
		.info("This is a info msg")
		.addScreenCaptureFromPath(savefile);
		

		exReport
		.createTest("Screenshot 2","This is attached the screenshot")
		.info("This is a info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(savefile).build());
				
		
		
		exReport.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
     public static String capturescreenShot(String files) {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File myfile = ts.getScreenshotAs(OutputType.FILE);
    	File dustfile = new File(files);
    //	FileHandler.copy(myfile, dustfile);
    //	FileUtils.copyFile(myfile, dustfile);
    	myfile.renameTo(dustfile);
		return files;
    	
    	 
     }
}
