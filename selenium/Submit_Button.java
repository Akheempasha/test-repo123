package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Submit_Button {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@value='female']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='FSsubmit']")).submit();

	}
}
