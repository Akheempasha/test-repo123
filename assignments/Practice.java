package assignments;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class Practice {

	public static void main(String[] args) throws IOException, InterruptedException   {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		op.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		System.out.println("Successful open");
		
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("dd_mm_yyyy_hh:mm:ss");
	/*	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File mfile =ts.getScreenshotAs(OutputType.FILE);
		File file = new File("./Defects\\google.png");
		mfile.renameTo(file);
	*/	
		WebElement ele=driver.findElement(By.id("SIvCob"));
		
		File files = ele.getScreenshotAs(OutputType.FILE);
		File savefile = new File("./Defects\\google2.png");
		files.renameTo(savefile);
		 
		
		 
	
}
}




