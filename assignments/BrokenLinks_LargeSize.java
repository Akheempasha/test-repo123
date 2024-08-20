package selenium;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks_LargeSize {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.eenadu.net");
		driver.manage().window().maximize();
		
		TimeUnit.SECONDS.sleep(1);
		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println("NUmber of links are.."+links.size());
		
		List<String> urlLinks = new ArrayList<String>();
		
		for (WebElement e : links) {
			String url =e.getAttribute("href");
			//checkBrokenLinks(url);
			  urlLinks.add(url);
			
		}
		
		 long stTime = System.currentTimeMillis();
		 		
		 urlLinks.parallelStream().forEach(e-> checkBrokenLinks(e));  // parallel execution   time 10 -sec
	  //   urlLinks.stream().forEach(e->	checkBrokenLinks(e));     // sequal execution      time 2 - sec
		 long endTime = System.currentTimeMillis();	
		 
		 System.out.println("total time taken.."+(endTime-stTime));
		
		 driver.quit();
	}		
	
	
	
	public static void checkBrokenLinks(String linkUrl) {
		
            try {		
			URL url = new URI(linkUrl).toURL();
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			//urlConnection.setConnectTimeout(5000);
			urlConnection.connect();
			
			if(urlConnection.getResponseCode() >= 400) {
				System.err.println(linkUrl + "--->"+ urlConnection.getResponseMessage() + "is a broken link");
			}
			else {
				System.out.println(linkUrl + "--->"+ urlConnection.getResponseCode());
			}
            }
            catch(Exception e) {
            	System.out.println(e.getMessage());
            }
		
	}

}
