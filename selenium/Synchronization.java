package selenium;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		
	    //implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("orangehrm");
		
	List<WebElement> text=driver.findElements(By.xpath("//ul[@jsname='bw4e9b']/li"));
	
	for (WebElement texts : text) {
		//System.out.println(texts.getText());
		   Thread.sleep(2500);
		if(texts.getText().equals("orangehrm demo")) {
			texts.click();
			break;
		}
	}
	  //ExplicitlyWait
	WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement link=waits.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='byrV5b']/cite)[1]")));
		 Actions action = new Actions(driver);
		 action.moveToElement(link).click().perform();
		
		if(driver.getTitle().contains("OrangeHRM")) {
			System.out.println("Application opened");
			System.out.println("Title.."+driver.getTitle());
			System.out.println("Url..."+driver.getCurrentUrl());
		}
		
	//FluentWait
	Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				                .withTimeout(Duration.ofSeconds(30))
				                .pollingEvery(Duration.ofSeconds(5))
				                .ignoring(NoSuchElementException.class);
		
	WebElement uid=	fwait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
	uid.sendKeys("Admin");
	System.out.println(uid.getAttribute("value"));
	
	driver.navigate().back();
	
	
	}
}
