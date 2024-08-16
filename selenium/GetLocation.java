package selenium;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetLocation {

	public static void main(String[] args) throws AWTException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Robot robot = new Robot();
		//robot.mouseWheel(15);
		robot.delay(3000);
		
	 
		
		WebElement location=driver.findElement(By.id("name"));
		System.out.println(location.getLocation());
		
		Point p=driver.findElement(By.id("name")).getLocation();
		System.out.println(" x point is.."+p.x);
		System.out.println(" y point is.."+p.y);
		System.out.println(" x and y point is.."+p);
		
		  robot.delay(3000);
		 
		 Actions action = new Actions(driver);
		 action.moveToElement(location, 305, 254).click().perform();
		
	}

}
