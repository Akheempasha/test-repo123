package selenium;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Flipkart_Assignment {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	    driver = new ChromeDriver();
		driver.get("https://flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("div[class='_2SmNnR'] input")).sendKeys("samsung mobiles",Keys.ENTER);
	    Thread.sleep(3000);
	    List<WebElement>	 productlist = driver.findElements
		          (By.xpath("//div[@class='yKfJKb row']//div[@class='KzDlHZ']"));
	     
	    while(true) {
	    	 WebElement nxtButton = driver.findElement(By.cssSelector("nav[class='WSL9JP'] a[class='_9QVEpD']:last-child"));
	    	 if(nxtButton.isDisplayed()) {
	    		
	    		 for (int j = 0; j < productlist.size(); j++) {	
	    			 try {
	    			 System.out.println(productlist.get(j).getText());
	    			 }
	    		 
	    		  catch(StaleElementReferenceException e) {
	    			 productlist = driver.findElements
		    		          (By.xpath("//div[@class='yKfJKb row']//div[@class='KzDlHZ']"));
	    			 System.out.println(productlist.get(j).getText());
	    		    }
	    		  catch(NoSuchElementException e1) {
	    			 System.out.println("complete all product list");
	    		    }
	    		 }
	    	 Thread.sleep(2000);
	    	 scrollDown() ;
	    	 Thread.sleep(2000);
	    	 nxtButton.click();
	        }
	     } 
	  }
	        
	    
	    		
   
	
	    
	
	
	
	
	
	
	
	
	    public static void fluentWaits(List<WebElement> productlist ) {
	    	FluentWait<WebDriver> waits = new FluentWait<WebDriver>(driver)
 		              .withTimeout(Duration.ofSeconds(30))
                       .pollingEvery(Duration.ofSeconds(5))
                       .ignoring(Exception.class)
                       .withMessage("Element not Visible");
            waits.until(ExpectedConditions.visibilityOfAllElements(productlist));
	    }
	    
	    public static void scrollDown() {
	    	WebElement nxtButton = driver.findElement(By.cssSelector("nav[class='WSL9JP'] a[class='_9QVEpD']:last-child"));
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].scrollIntoView(true);",nxtButton );
	    	js.executeScript("window.scrollBy(0,-100)", nxtButton);
	    }
	   
	
}
	
		
		
