package com.extent.reports;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RahulShetty_Automation {
	WebDriver driver=null;
	
	
	@BeforeClass
	public void setUp() {
	    driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void hiddenLinks() throws IOException, InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		
		
		int count=0;
	List<WebElement>links=driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	
	for(WebElement link : links) {
		System.out.println("number link text.."+link.getText());
		if(!link.getText().isEmpty())
			count++;
	}
	
	
	System.out.println("number of visible links.."+count);
	
	System.out.println("number of invisible links.."+(links.size()-count));
		Thread.sleep(5000);
    Set<String> broken = new HashSet<String>();
	for(WebElement linkurl : links) {
		String url =linkurl.getAttribute("href");
		
		try {
		URL urll = new  URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)urll.openConnection();
		urlConnection.connect();
		
		if(urlConnection.getResponseCode()==200) {
			
		
		 System.out.println(url+" "+urlConnection.getResponseMessage());
	   }
		
		else {
			System.err.println(url+" "+urlConnection.getResponseCode());
			urlConnection.disconnect();
		}
		}
		
		
	catch(Exception e) {
		System.out.println(e);
	}
    }
	driver.close();
}

  @Test (priority=1)
  public void allLinks_Click() throws InterruptedException {
	  
	 List<WebElement>link= driver.findElements(By.tagName("a"));
	  System.out.println(link.size());
	  
	 String[] links = new String[link.size()];
	 
	 for(int i = 0; i<link.size();i++) {
	links[i]=link.get(i).getAttribute("href");
	System.out.println(links[i]);
	 }
	   Thread.sleep(3000);
	 for(int i =0; i<link.size(); i++) {
		 driver.navigate().to(links[i]);
		 Thread.sleep(2000);
		System.out.println(driver.getTitle());
	 }
	 
 
	 
  }



}
	
	
	
	
	
	


