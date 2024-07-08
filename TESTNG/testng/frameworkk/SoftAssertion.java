package testng.frameworkk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
		System.out.println("Successful opened");
		
		
		SoftAssert softassert = new SoftAssert();
		String ExpectedTitle = "Welcome: Mercury Tour";
		softassert.assertEquals(driver.getTitle(),ExpectedTitle , "Title Mismatched" );
		System.out.println("Successful matched");
		
		driver.quit();
		softassert.assertAll();
		
		
		
	}

}
