package assignments;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Waits {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 
		     //1.implicitly wait
	//	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		
		      //2.Explicitly wait
	/*	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 
		 WebElement hrm=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		 hrm.sendKeys("Admin");
	 
		 WebElement pwd= wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		 pwd.sendKeys("admin123");
		 
		 WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		 button.click();
	*/	 
		 
		 //Fluent wait
		 
		Wait<WebDriver> myWait=new FluentWait<WebDriver>(driver)
		         .withTimeout(Duration.ofSeconds(30))
		         .pollingEvery(Duration.ofSeconds(5))
		         .ignoring(NoSuchElementException.class);
		 
		WebElement uid= myWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.name("username")));
			 
		           
		 uid.sendKeys("Admin123");
	}

}
