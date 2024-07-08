package testng.frameworkk;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	  WebDriver driver;
	  
  @BeforeTest
  @Parameters ({"browsername","Url"})
  public void setup(String browsername, String Url) {
	
	switch (browsername.toLowerCase()){
	
	case "chrome":
		driver = new ChromeDriver();
		System.out.println("Tests are running in chromebrowser");
		break;
	case "ff":
		driver = new FirefoxDriver();
		System.out.println("Tests are running in Firefoxbrowser");
		break;
	
	case "edge":
		driver = new EdgeDriver();
		System.out.println("Tests are running in EdgeBrowser");
	 
    default:
    	System.out.println("Browser name is invalid");
    	break;
	}

driver.manage().window().maximize();
driver.get(Url );
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
System.out.println("Successful open the url");


}

   @AfterTest
   public void tearDown() {
	   driver.close();
	   System.out.println("Close the application");
   }
 
  @Test (priority = 1)
  @Parameters ({"username","password"})
  public void userLogin(String username,String password) throws InterruptedException {
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(2500);
	  System.out.println("Successful login operations");
	  
  }
  @Test (priority = 1)
  public void userLogout() {
	  driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
	  
	  driver.findElement(By.linkText("Logout")).click();
	  System.out.println("Successful logout");
	  
  }

}
