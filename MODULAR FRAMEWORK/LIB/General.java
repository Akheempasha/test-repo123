package com.hrms.LIB;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrms.objects.ObjectsInfo;

public class General extends ObjectsInfo {
	
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Application opened");
		
	}
	public void tearDown() {
		driver.close();
		System.out.println("application closed");
		
	}
    public void adminLogin() throws InterruptedException {
    	driver.findElement(By.name(txt_username)).sendKeys(uid);
    	driver.findElement(By.name(txt_password)).sendKeys(pwd);
    	driver.findElement(By.xpath(btn_login)).click();
    	Thread.sleep(2500);
    	System.out.println("Sucessful login appln");
    }
	public void adminLogout() throws InterruptedException {
		driver.findElement(By.xpath(alt_profile)).click();
		driver.findElement(By.linkText(link_logout)).click();
		Thread.sleep(2500);
	   System.out.println("Sucessful logout");
		
	}
	public void addEmp() {
		System.out.println("Sucessful add employee");
	}
	public void deleteEmp(){
		
	System.out.println("delete emp details");	
		
	}	
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
