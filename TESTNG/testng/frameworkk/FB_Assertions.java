package testng.frameworkk;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FB_Assertions {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		System.out.println("Fb Opened");
	}
  
	@Test
	public void fbLogin() {
		driver.findElement(By.cssSelector("#email")).sendKeys("H Y R",Keys.ENTER);
		
		//1.Title Assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to Facebook";
		assertEquals(actualTitle, expectedTitle,"Titla is Matched");
		
		SoftAssert softassert = new SoftAssert();
		
		// 2.Url Assertion
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "https://www.facebook.com";
		softassert.assertNotEquals(actualurl, expectedurl, "Url is Matched");
		
		//3.getText Assertion
		String actualText =driver.findElement(By.cssSelector("#email")).getAttribute("value");
		String expectedText = "";
		assertEquals(actualText, expectedText,"text is Matches");
		
		//4.Border color
		String actualcolor =driver.findElement(By.cssSelector("#email")).getCssValue("border") ;
		String expectedcolor = "0.8px solid rgb(240, 40, 73)";
		assertEquals(actualcolor, expectedcolor,"color is Matched");
		
		//5.error msg
		
		String actualerror =driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		String expextderror = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		assertEquals(actualerror, expextderror,"error msg is Matched");
		assertTrue(actualerror==expextderror);
		
		driver.quit();
		softassert.assertAll();
		
		
		
	}
}
