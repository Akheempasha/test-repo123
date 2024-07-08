package window.handles;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handles {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement>link=driver.findElements(By.tagName("a"));
		
		System.out.println("number of links.."+link.size());
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		
		Set<String>pgHandle=driver.getWindowHandles();
		
		Iterator<String>winHandles=pgHandle.iterator();
		
		String win1= winHandles.next();
		String win2= winHandles.next();
		
		System.out.println(win1);
		System.out.println(win2);
		
		driver.switchTo().window(win2);
		System.out.println("2nd page title.."+driver.getTitle());
		
		List<WebElement>pg2=driver.findElements(By.tagName("a"));
		System.out.println(pg2.size());
		
	WebElement opencart=driver.findElement(By.xpath("//a[text()='Desktops']"));
	opencart.click();
	
	opencart.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(3000);
	opencart.sendKeys(Keys.ARROW_DOWN);
	opencart.sendKeys(Keys.ENTER);
	
	driver.switchTo().window(win1);
	System.out.println(driver.getTitle());
	
		 
		
		
	}
}
	


