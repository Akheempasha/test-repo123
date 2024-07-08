package assignments;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class XPATHvsCSS {

	public static void main(String[] args)throws Exception {
		
		 WebDriver driver = new EdgeDriver();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.location='https://testautomationpractice.blogspot.com/'");
		 driver.manage().window().maximize();
		 
		 Instant startTime = Instant.now();
		 System.out.println(startTime.toString());
		 
		 driver.findElement(By.xpath("//input[@class='form-control'][1]")).sendKeys("Akheem");
	 //  driver.findElement(By.cssSelector("input[class='form-control'][id='name']")).sendKeys("Akheem");
		 
		 Instant endTime = Instant.now();
		 System.out.println(endTime.toString());
		 
		 Duration time = Duration.between(startTime, endTime);
		 System.out.println("Time taken: "+time.toMillis() +" mill seconds");
		 
		 Thread.sleep(2500);
		 driver.quit();
		 
	}

}
