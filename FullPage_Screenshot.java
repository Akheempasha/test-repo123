package testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class Full_Screenshot {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	
	WebDriver driver = new ChromeDriver();
    driver.get("https://google.com");
    driver.manage().window().maximize();
    Thread.sleep(2000);
    driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
    Thread.sleep(2500);
    //FullPage--> add dependency in pom--> Sutterbug with selenium
    Shutterbug.shootPage(driver, Capture.FULL, true).save("D:\\OpenCart_POM\\Opencart_v1\\screenshots\\");
    //normalPage
    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileHandler.copy(screenshot, new File("./screenshots\\page.png"));
    System.out.println("screenshot complted");
}
}
