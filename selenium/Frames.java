package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Frames {

	public static void main(String[] args)throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	 
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		/*	
		Select sc = new Select(driver.findElement(By.xpath("(//select[@id ='course'])")));
		
		String scc = sc.getFirstSelectedOption().getText();
		System.out.println(scc);
		
		List<WebElement> ele = sc.getOptions();
		for (WebElement webElement : ele) {
			System.out.println(webElement.getText());
			
		}
		Thread.sleep(3000);
		sc.selectByIndex(2);
		Thread.sleep(3000);
		sc.selectByValue("js");
		Thread.sleep(3000);
		sc.selectByVisibleText("Dot Net");
		Thread.sleep(3000);
		sc.deselectByVisibleText("-- Selenium");
		*/
		
		
		 
		
	  
	
	 
		
		

	}

}
