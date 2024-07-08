package testng.frameworkk;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvoiderss {

	@Test(dataProvider = "dataUser")
	public void UserLogin(String uid, String pwd) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("Initialize the browser");
		driver.findElement(By.name("username")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Successful User login");
		driver.quit();

	}

	
	
	
	@DataProvider(parallel = true)
	public Object[][] dataUser() {

		Object[][] login = { { "Admin", "admin123" }, 
		                     {"admin","admin123"},
		                      };

		return login;

		/*
		 * Object[][] login = new Object[3][2]; login[0][0]= "Admin"; login[0][1]=
		 * "admin123";
		 * 
		 * login[1][0]= "Admin"; login[1][1]= "admin"; //Only using one TestCase
		 * 
		 * login[2][0]= "dmin"; login[2][1]= "admin123";
		 * 
		 * return login;
		 */
	}
}
