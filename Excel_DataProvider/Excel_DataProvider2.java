package excel.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Excel_DataProvider2 {
	
	@Test (dataProvider = "testData",dataProviderClass = Excel_Dataprovider.class , threadPoolSize = 2)
	public void user(String uid,String pwd) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2500);
		driver.findElement(By.name("username")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(pwd);
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		Thread.sleep(2500);
		driver.quit();

	}

}
