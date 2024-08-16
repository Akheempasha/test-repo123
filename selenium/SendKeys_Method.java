package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public  class SendKeys_Method {
	

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement send =driver.findElement(By.name("q"));
		send.sendKeys("Akheem");
		Thread.sleep(3000);
		send.sendKeys(Keys.CONTROL+"A",Keys.DELETE);
		Thread.sleep(3000);
		send.sendKeys("Pasha",Keys.ENTER);
		
		//Approach-2
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='Akheem'", send);
		
		
		

	}

}
