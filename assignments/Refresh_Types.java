package assignments;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Refresh_Types {

	public static void main(String[] args) throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		 
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		   //1.Approach-1
//		driver.navigate().refresh();
//		System.out.println("refresh"+"1");
		   //2.Java script
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("history.go(0)");
//		System.out.println("history"+"2");
//		   Thread.sleep(3000);
//		js.executeScript("location.reload(true)");
//		System.out.println("location"+"3");
//		 Thread.sleep(3000);
//		  //3.Action class
		Actions action = new Actions(driver);
		 
		action.keyDown(Keys.F5).keyDown(Keys.F5).perform();
		        
		        
//		System.out.println("action-1"+"4");
//		 Thread.sleep(3000);
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
//		System.out.println("action-2"+"5");
//		Thread.sleep(3000);
//		action.sendKeys(Keys.chord(Keys.CONTROL,"r"));
//		System.out.println("action-3"+"6");
//		
//	     //4.Robot class
//		Thread.sleep(3000);
//		Robot rb = new Robot();
//		rb.keyPress(KeyEvent.VK_CONTROL);
//		rb.keyPress(KeyEvent.VK_R);
//		
//		rb.keyRelease(KeyEvent.VK_CONTROL);
//		rb.keyRelease(KeyEvent.VK_R);
//		System.out.println("robot-1"+"7");
//		
//		Thread.sleep(3000);
//		rb.keyPress(KeyEvent.VK_CONTROL);
//		rb.keyPress(KeyEvent.VK_F5);
//		 
//		
//		rb.keyRelease(KeyEvent.VK_CONTROL);
//		rb.keyRelease(KeyEvent.VK_F5);
//		System.out.println("robot-2"+"8");
		
	//	driver.quit();
		
		
	
	}

}
