package assignments;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		// Full screenshot
		
		/*
		 *  TakesScreenshot ts = (TakesScreenshot)driver;
		 *  File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		 *  File myfile = new File("./Defects\\fullpage.png"); 
		 *  sourcefile.renameTo(myfile);
		 */
		
		         // group of elements
		WebElement ele = driver.findElement(By.xpath("//div[@id='SIvCob']"));

		File sourcefile = ele.getScreenshotAs(OutputType.FILE);
		File myfile = new File("./Defects\\group page.png");
		sourcefile.renameTo(myfile);

		driver.close();

	}

}
