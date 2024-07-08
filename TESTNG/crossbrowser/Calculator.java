package crossbrowser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Calculator {
	WebDriver driver;
	
	@Parameters ({"browser"})
	@BeforeTest
	public void launchapp(String browser) throws IOException {
		
		File myfile = new File("./Properties\\inputdata.properties");
		FileInputStream fis = new FileInputStream(myfile);
		Properties pro = new Properties();
		pro.load(fis);
		 
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Launch the Firefox broser");
			}
		else if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Launch the Chrome broser");
			}
	
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("Launch the Edge broser");
		    }
		
		else {
			throw new IllegalArgumentException("The browser type is undefined");
		     }
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	@Test
	public void calculatpercent() {
		// Click on Math Calculators
		driver.findElement(By.xpath("//div[@class='homelisttile'][3]/div[2]/a")).click();
		// Click on Percent Calculators
		driver.findElement(By.linkText("Percentage")).click();
		// Enter value 10 in the first number of the percent Calculator
		driver.findElement(By.xpath("//input[@name='cpar1']")).sendKeys("10");
		// Enter value 100 in the second number of the percent Calculator
		driver.findElement(By.xpath("//input[@name='cpar2']")).sendKeys("100");
		// Click Calculate Button
		driver.findElement(By.xpath("(//table)[1]/tbody/tr[2]/td/input[2]")).click();
		
		 // Get the Result Text based on its xpath
		String result=driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font")).getText();
		   System.out.println("Result is.."+result);
		   
		   if(result.equals("10")){
			   System.out.println("The resukt is pass");
		   }
		   else {
			   System.out.println("Result is fail");
		   }
		
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
	
	
	
	
	
}
