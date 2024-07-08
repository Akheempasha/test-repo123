package assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.swing.plaf.FileChooserUI;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		
		
	/*	File file=driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Defects\\img.jpg");            // ChromeDriver
	   FileHandler.copy(file, destFile);
	   System.out.println("Successfully saved screenshot");
		*/
		
		/*
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("./Defects\\img1.jpg"));
		System.out.println("Successful saved screenshot");
	*/	
	/*	byte[] files = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		File desFile = new File ("./Defects\\img1.jpg");
		FileOutputStream fos = new FileOutputStream(desFile);
		fos.write(files);
		fos.close();
		System.out.println("Successful saved screenshot");
	*/	
	   
	/*	String base64Code = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		File desFile = new File ("./Defects\\img2.png");
		byte[] bytrArr=Base64.getDecoder().decode(base64Code);
		FileOutputStream fos = new FileOutputStream(desFile);
		fos.write(bytrArr);
		fos.close();
		System.out.println("Successful saved screenshot");
		*/
		
		
	}

}
