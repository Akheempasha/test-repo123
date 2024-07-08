package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Links {

	public static void main(String[] args) throws IOException, InterruptedException ,MalformedURLException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		Set<String> Brokenlinks = new HashSet<String>();
		 
		List <WebElement> link=driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		
		for(WebElement links : link) {
			System.out.println("==============");
			System.out.println(links.getAttribute("href"));
			System.out.println(links.getText());
			
			Thread.sleep(2000);
		String url = links.getAttribute("href");
	 
	    try {
		URL linkurl = new URL(url);
	    HttpURLConnection httpconn =(HttpURLConnection)linkurl.openConnection();
		httpconn.connect();
		
	    if(httpconn.getResponseCode() != 200) {
	    	Brokenlinks.add(url);
	    }
	       
    	     for (String brokenlinks : Brokenlinks) {
    	    	System.err.println(brokenlinks);
    	    	httpconn.disconnect();
    	    	 }
	    }
    	     catch (MalformedURLException e) {
    	    	e.printStackTrace();
    	     
    	    	}
	    }  
     driver.close();
	}	
	 
}
	

