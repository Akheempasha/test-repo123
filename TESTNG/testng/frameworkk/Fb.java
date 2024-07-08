package testng.frameworkk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fb {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		
		driver.findElement(By.className("_6luy")).sendKeys("adcsc");
	}

}
