package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ScrollToElement {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");

		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));

		Actions action = new Actions(driver);
		
//	action.scrollToElement(date).click(date).perform();
	action.moveToElement(date).perform();
	//action.pause(Duration.ofSeconds(3));
	action.pause(5000);
	action.click(date).perform();
	
/*
		if (date.isEnabled() && date.isDisplayed()) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", date);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();",date);
			System.out.println("Element is clicked");

		} 
		else {
			System.out.println("Unable to click element");
		}
*/		
		Thread.sleep(6000);
		driver.quit();

	}

}
