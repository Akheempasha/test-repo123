package testng.frameworkk;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OHRM_Login {
	WebDriver driver;
	
	@Test (priority = 0)
	public void UserLogin() {
		driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    //    System.out.println("Successful User login");
        
       boolean page = driver.findElement(By.xpath(" //h6[text()='Dashboard']")).isDisplayed();
       Assert.assertEquals(page,true);
       Reporter.log("Successful login operations",true);
		
	}
	@Test (priority = 1)
	public void UserLogout() {
		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("Successful User Logout");
	}
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Initialize the browser");
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		System.out.println("Close the appplication");
	}
	
	
	
	
}
