package selenium;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_Assignment2 {
   static  WebDriver driver;
   
	public static void main(String[] args) throws InterruptedException {
	ChromeOptions option = new ChromeOptions();	
	option.addArguments("--disable-notifications");
	option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	//disableImage(option);
    driver = new ChromeDriver(option);
	driver.get("https://www.amazon.com");
	driver.manage().window().maximize();
	
	TimeUnit.SECONDS.sleep(10);
	
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung laptops",Keys.ENTER);
    Thread.sleep(3000);
    
    try {
    WebElement filteroption =driver.findElement(By.xpath("//span[text()='Filters']"));
    
    if(filteroption.isDisplayed()) {
    	filteroption.click();
	//  checkBoxes("Hard Drive Size", "1 TB");
	  checkBoxes("Deals & Discounts", "All Discounts");
    }
    }
    catch(Exception e) {
    //  checkBoxes("Hard Disk Size", "1 TB");
      checkBoxes("Deals & Discounts", "All Discounts");
    	}
	Thread.sleep(3000);
    priceList_min();
    
    
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void checkBoxes(String filter, String... arg) {
		
	WebElement filterMenu =	driver.findElement(By.xpath
				("//span[@class='a-size-base a-color-base puis-bold-weight-text' and (text()='"+filter+"')]"));
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOf(filterMenu));
	 filterMenu.click();
	 
	 for (String args : arg) {
     	 WebElement filterEle =	driver.findElement(By.xpath
				("//span[@class='a-size-base a-color-base' and (text()='"+args+"')]//parent::*"));
	
     	 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", filterEle);
		 
		 WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		 waits.until(ExpectedConditions.elementToBeClickable(filterEle));
	     filterEle.click();
	}
	 
	 
	}
	
	public static void priceList_min() {
		
	List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	
	WebElement lowestPriceElement = null;
	double lowestPrice = Double.MAX_VALUE;
	
	try {
    for (int i = 0; i < pricelist.size(); i++) {
    	
		String price = pricelist.get(i).getText().replace(",", "");
		double prices = Double.valueOf(price);
		
		if(prices < lowestPrice) {
			lowestPrice = prices;
			lowestPriceElement = pricelist.get(i);
		  }
		System.out.println(price);
       }
         if(lowestPriceElement != null) {    
			lowestPriceElement.click();
			System.out.println("Clicked on the product with the lowest price..."+lowestPrice);
		  }
		else {
			System.out.println("No valid prices found");
		}
	    }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}
    
 
	 public static void disableImage(ChromeOptions option) {
		 HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("images", 2);
		 HashMap<String, Object> prefs = new HashMap<String, Object>();
		 prefs.put("profile.default_content_setting_values", map);
		 
		 option.setExperimentalOption("prefs", prefs);
		  
	 }	
}
