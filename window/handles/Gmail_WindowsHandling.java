package window.handles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_WindowsHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/v3/signin/identifier?hl=en-gb&ifkv=AaSxoQyIjUtqsdSxdb5SeDkE9GlEon3SittMKxEQTfVJ1aOzRtzf5qOXJdIxO0ZC4wz_CbL_sBh-8g&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-1928446294%3A1716621107591009&ddm=0");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Help']")).click();
		
		Set<String> pageHandle = driver.getWindowHandles();
		Iterator<String> winHandles=pageHandle.iterator();
		
		String win1 = winHandles.next();
		String win2 = winHandles.next();
		
		driver.switchTo().window(win2);
		
		  System.out.println("2nd tab title.."+driver.getTitle());
		 System.out.println("2nd tab wID.."+driver.getWindowHandle());
		 String parent2=driver.getWindowHandle();
		driver.findElement(By.linkText("Google Account")).click();
		
		Set<String> windowHandle = driver.getWindowHandles();
		for(String windowHandles : windowHandle ) {
			System.out.println(windowHandles);
			if(!windowHandles.equals(parent2)) {
				driver.switchTo().window(windowHandles);
				
				
			}
		}
		  String child2 = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[@ aria-label='Create a Google Account']")).click();
		
		driver.switchTo().window(parent2);
		
		driver.findElement(By.linkText("Community")).click();
		
		
		driver.switchTo().window(win1);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vscvshj@gmail.com");
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		System.out.println(driver.getTitle());
		
		
		
		driver.switchTo().window(child2);
		driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("khan");
		driver.findElement(By.xpath("//input[@aria-label='Surname (optional)']")).sendKeys("saa");
	    driver.findElement(By.xpath("//span[text()='Next']")).click();
	    System.out.println(driver.getTitle());
	    
	    driver.quit();
	
	
	}

}
