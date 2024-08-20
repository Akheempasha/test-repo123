package selenium;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks_BrokenImages {

	public static void main(String[] args) throws Exception, URISyntaxException {

     WebDriver driver = new ChromeDriver();
     driver.get("https://flipkart.com/");
     driver.manage().window().maximize();
     
     //TimeUnit.SECONDS.sleep(10);
     
     driver.manage().deleteAllCookies();
     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
     //1. get the list of all the links and images:500
     List<WebElement>links = driver.findElements(By.tagName("a"));
     System.out.println(links.size());  // 128
     links.addAll(driver.findElements(By.tagName("img")));
     System.out.println(links.size());  //153 (128+25--> img)
     
     List<String> activeLinks = new ArrayList<String>();
     
     //2. iterate links
     for (int i = 0; i < links.size(); i++) {
    	 
		String url =links.get(i).getAttribute("href");
		
		if(url != null && (!url.contains("javascript"))) {
			System.out.println(url);
		activeLinks.add(url);
		}
     }
	
     // get the size of active links list
     System.out.println("size of active links and images..."+activeLinks.size());
     
     activeLinks.parallelStream().forEach(p-> checkLinks(p));
     
     } 
     
	
     public static void checkLinks(String url) {
    	 
     try {
     URL linkurl = new URI(url).toURL();
     HttpsURLConnection connection = (HttpsURLConnection)linkurl.openConnection();
		connection.connect();
		connection.getResponseMessage();
		connection.disconnect();
		
		if(connection.getResponseCode() >= 405 && connection.getResponseCode() <= 503) {
		   System.err.println(url+"<====>"+connection.getResponseCode());
		}
		
     }
     catch(Exception e) {
    	 System.out.println(e.getMessage());
     }
		
     
 /*  for (int i = 0; i < activeLinks.size(); i++) {
    	 
    HttpsURLConnection connection = (HttpsURLConnection)new URI(activeLinks.get(i).getAttribute("href")).toURL().openConnection();
		connection.connect();
		connection.getResponseMessage();
		connection.disconnect();
	
		System.out.println(i+"-"+activeLinks.get(i).getAttribute("href")+"--->"+connection.getResponseMessage());	
	}*/
		
	}

}
