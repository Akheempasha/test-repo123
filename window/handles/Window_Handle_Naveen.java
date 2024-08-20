package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handle_Naveen {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	    driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']")).click();
		driver.findElement(By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']")).click();
		driver.findElement(By.cssSelector("a[href *= 'youtube']")).click();
		
		int windowCount =driver.getWindowHandles().size();
		System.out.println(windowCount);
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> winHandle = driver.getWindowHandles();
		Thread.sleep(2500);
		
		if(switchToWindow("YouTube",winHandle)) {
			System.out.println(driver.getTitle()+" : "+driver.getCurrentUrl());
		}
		
		closeOneWindow("Facebook", winHandle);
		Thread.sleep(3000);
		closeAllWindows(winHandle ,parentWindow);
		Thread.sleep(2000);
		if(switchParentWindow(parentWindow)) {
			System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static boolean switchToWindow(String winTitle, Set<String> winHandle) {
		for (String s : winHandle) {
             String title =  driver.switchTo().window(s).getTitle();		
			 if(title.contains(winTitle)) {
				System.out.println("found the right window");
				return true;
			}
		}
		return false;
		
	}
	
	public static  boolean switchParentWindow(String parentWindow ) {
		driver.switchTo().window(parentWindow);
		return true;
	}
	
	public static void closeAllWindows(Set<String> winHandle, String parentWindow) {
		for (String e : winHandle) {
			if(!e.equals(parentWindow)) {
				driver.switchTo().window(e).close();	
			}
		}	
	}
	
	public static void closeOneWindow(String winTitle,Set<String> winHandle) {
		for (String e : winHandle) {
			if(driver.switchTo().window(e).getTitle().contains(winTitle)) {
				driver.switchTo().window(e).close();
				System.out.println("Successfull close the window");
					
			}
		}	
	}

}
