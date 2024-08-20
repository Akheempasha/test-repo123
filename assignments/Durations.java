package selenium;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Durations {

	public static void main(String[] args) {
	/*	
		Instant stTime = Instant.now();
		System.out.println(stTime);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		
		Instant endTime = Instant.now();
		System.out.println(endTime);
		
		Duration time = Duration.between(stTime, endTime);
		System.out.println("Time Taken: "+time.toMillis()+"milli Seconds");   //3.5 sec
	*/
	
	long stTime = System.currentTimeMillis();
	WebDriver driver = new ChromeDriver();
	driver.get("https://google.com");
	driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
	long endTime = System.currentTimeMillis();
	
	System.out.println("Total Duration.."+(endTime-stTime));  //4.5
	driver.quit();

	}
}
