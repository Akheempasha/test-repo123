package webelements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdowns_AutoSuggestion {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.cssSelector("textarea[name=q]")).sendKeys("samsung");
		
         List<WebElement>list=driver.findElements(By.xpath("//ul[@role='listbox']//li"));
         
         System.out.println("number options.."+list.size());
         
         for(WebElement lists : list) {
        	 String option=lists.getText();
        	 if(option.equals("samsung s22")) {
        		 lists.click();
        	 }
             }
	         System.out.println("Successful clicked");
	}

}
