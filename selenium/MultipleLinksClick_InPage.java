package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleLinksClick_InPage {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/sectors/bse/infra");
		driver.manage().window().maximize();
		
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr//td/a"));
		System.out.println(rows.size());
		
		  //Approach - 1
		
		for(int l =0 ; l < rows.size(); l++) {
			
	      if(!rows.get(l).getText().isEmpty()) {
	    	  
	    	  rows.get(l).click();
	
	      }
	      else {
	    	  driver.navigate().back();
	      }
	      driver.navigate().to("https://money.rediff.com/sectors/bse/infra");
	      rows  = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr//td/a"));
	         
			}
		
		    // Approach - 2
	/*	
		String [] links = new String[rows.size()];
		
		for(int l =0 ; l < rows.size(); l++) {
		    links[l] = rows.get(l).getAttribute("href");
         
		}
		
		for(int i =0 ; i < rows.size(); i++) {
			 Thread.sleep(3000);
			 driver.navigate().to(links[i]);
			 System.out.println(driver.getTitle());	 
		 }
	*/	
}
}
