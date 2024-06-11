package com.extent.reports;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Version {

	public static void main(String[] args) {
	/*	WebDriver driver = new ChromeDriver();
		
		Capabilities capab = ((RemoteWebDriver)driver).getCapabilities();
		System.out.println(capab.getBrowserName());
		System.out.println(capab.getBrowserVersion());
		driver.quit();
	*/
	//	System.getProperties().list(System.out);
		
	 	System.out.println(System.getProperty("os.name"));
		
		System.out.println(System.getProperty("java.version"));
		
	}

}
