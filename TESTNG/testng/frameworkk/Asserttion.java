package testng.frameworkk;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Asserttion {
	WebDriver driver;
 //@Ignore
	
	@BeforeClass
	public void setup() {
	    driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
		
	}
  // @Ignore
   @Test (priority = 0 ) //(enabled = false or true)
   public void UserLogin() throws InterruptedException {
	   driver.findElement(By.name("userName")).sendKeys("mercury");
	   driver.findElement(By.name("password")).sendKeys("mercury");
	   driver.findElement(By.name("submit")).click();
	   Thread.sleep(3000);
	   
	   String expectedresult = "Login: Mercury Tours";
	   String actualresult   = driver.getTitle();
	   
	   Assert.assertEquals(expectedresult, actualresult ,"Title is Matched");
	   System.out.println("Successful login operations");
	   
   }
   @Test (priority = 1)
   public void UserLogout() throws InterruptedException {
	   driver.findElement(By.xpath("//a[text()='SIGN-OFF']")).click();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(driver.getTitle());
	   Thread.sleep(2000);
	   boolean title = driver.findElement(By.xpath("//title[text()='Welcome: Mercury Tours']")).isDisplayed();
	   Assert.assertEquals(title,true,"[Successful Title Displayed]");
	   System.out.println("Successful logout");
   }
	
   @AfterClass 
   public void tearDown() {
	   driver.close();
   }
   	
}
