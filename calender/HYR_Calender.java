package calender;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HYR_Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2500);
		
		driver.findElement(By.id("first_date_picker")).click();
		
		String month = "June 2025";   // future date
		String monthh = "April 2023";
		String day   = "25";
		
		while(true) {
		String text=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		
		   if(text.equals(monthh) ) {
			   break;
		   }
		   else {
			   driver.findElement(By.xpath("//a[@title='Prev']")).click();   // previous button
			 //  driver.findElement(By.xpath("//a[@title='Next']")).click();  // Next button
		   }
		   }
		   driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[contains(text(),"+day+")]")).click();
	        System.out.println("Successful date picked");
	}

}
