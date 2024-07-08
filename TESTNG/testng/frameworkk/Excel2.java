package testng.frameworkk;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Excel2 {

	@Test(dataProvider = "getData",dataProviderClass = Excel1.class)
	public void testLogin(String username, String password) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Assert.assertTrue(driver.findElement(By.linkText("Dashboard")).isDisplayed());
		System.out.println("Successful login operations");
	    Thread.sleep(2500);
	    driver.quit();

	}

}
