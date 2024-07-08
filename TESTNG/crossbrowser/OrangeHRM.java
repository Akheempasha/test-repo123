package crossbrowser;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRM {
	WebDriver driver;
	
	@Parameters({"testbrowser","baseUrl"})
	@BeforeTest
	public void openBrowser(String testbrowser,String baseUrl) {
		
		switch(testbrowser.toUpperCase()) {
		
		case "FIREFOX":
			driver = new FirefoxDriver();
			System.out.println("Tests are running in Firefoxbrowser");
			break;
		 
	    case "CHROME":
		    driver = new ChromeDriver();
		    System.out.println("Tests are running in chromebrowser");
		    break;
		    
	    case "EDGE":
		    driver = new EdgeDriver();
		    System.out.println("Tests are running in Edgebrowser");
		    break;
	    default :
	    	System.out.println("Browser is UnIdentified");
	}
	driver.get(baseUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
  
 // @Test	(dataProvider = "LoginData")
	@Test 
	@Parameters ({"username","pwd"})
  public void userLogin(String user,String pw) {
	  
	  driver.findElement(By.name("username")).sendKeys(user);
	  driver.findElement(By.name("password")).sendKeys(pw);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  try {
	  if(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed()) {
		  System.out.println("Successful login operations");
		  
		  driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
		  
		  driver.findElement(By.linkText("Logout")).click();
	  }
	  }
	  catch(Exception e) {
		  System.out.println("Unsuccessful login operation");
		  
	  }
  }

  @AfterTest
  public void close() {
	  driver.close();
	  System.out.println("Close the application");
  }
   // Approah-2 dataprovider
/*
  @DataProvider (name="LoginData")
   public Object[][] getData(){
	  Object[][]data= {{"Admin","admin123"}};
	return data;
	  
  }
*/
}
