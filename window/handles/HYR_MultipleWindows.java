package window.handles;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HYR_MultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		System.out.println("parent window.."+driver.getTitle());
		System.out.println("parent window id.."+driver.getWindowHandle());
		String parentwindow=driver.getWindowHandle();
		String parentTitle =driver.getTitle();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	
		driver.findElement(By.xpath("(//button[@class='whButtons'])[4]")).click();
 
		Set<String> windowHandle = driver.getWindowHandles();
		for(String windowHandles:windowHandle) {
			System.out.println("Total WID.."+windowHandles);
		      if(!driver.getTitle().contains("Alerts")) {
				driver.switchTo().window(windowHandles);
			    
			}
		}
		 
	 System.out.println(driver.getTitle());	
	 driver.findElement(By.xpath("//*[text()='Contact']")).click();
	 
	 
	 driver.switchTo().window(parentwindow);
	 
	 System.out.println(driver.getTitle());
		 
		}
		
	}


