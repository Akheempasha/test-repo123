package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukri {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://resume.naukri.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='LOGIN']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fficon fficon-DownArrowBig']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@*='Enter your active Email ID / Username']")).sendKeys("MaheshAdepu");
		driver.findElement(By.xpath("//input[@*='Enter your password']")).sendKeys("Chinna");
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
           TimeUnit.SECONDS.sleep(3);
           try {
		if(driver.findElement(By.xpath("//a[text()='Register for fre']")).isEnabled() && 
				driver.findElement(By.xpath("//a[text()='Register for free']")).isDisplayed()) {
			
		driver.findElement(By.xpath("//a[text()='Register for free']")).click();
                System.out.println("Successfull Clickeed");
		}
           }
           catch(Exception e) {
        	   System.out.println("Not Clicked");
		
           }
	}

}
