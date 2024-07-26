package listeners.extend;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.extend.ExtentReportManager.class)
public class OrangeHRM {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 0)
	public void testlogo() {
		boolean status=driver.findElement(By.xpath
				("//img[@alt='company-branding']")).isDisplayed();
		
		Assert.assertTrue(true);
	}
	
	@Test(priority = 1)
	public void testAppurl() {
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority = 2 ,dependsOnMethods = {"testAppurl"} )
	public void testHomepageTitle() {
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
