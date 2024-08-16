package selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class getMethod {

	public static void main(String[] args)throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-fullscreen");
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement>chk=driver.findElements
				(By.xpath("//input[@class='form-check-input' and  (@type='checkbox')]"));
		Thread.sleep(2500);
		System.out.println(chk.size());

		driver.findElement(By.id("tuesday")).sendKeys(Keys.ENTER);
		
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(10));
		waits.until(ExpectedConditions.visibilityOfAllElements(chk));
		
		Thread.sleep(2500);
		int chks = chk.size();
	    chk.get(chks-2).click();
		chk.getFirst().click();
		chk.getLast().click();
		 
		WebElement text =driver.findElement(By.xpath("(//div[@class='form-group'])[2]/textarea"));
		
		text.sendKeys("Akheem PAsha Mohammad");
		
		File mfile = text.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(mfile, new File("./textbox.png"));
		System.out.println("Screenshot Saved");
		

	}
 
}
