package assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropPractice2 extends PropPractice0  {

	public static void main(String[] args) throws IOException  {
		 
		
		File file = new File("path");
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(file);
		pro.load(fis);
		
		
		WebDriver driver = new ChromeDriver();
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("username")).sendKeys(pro.getProperty("user"));
		driver.findElement(By.name("password")).sendKeys(pro.getProperty("pwd"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		  System.out.println("Successful login");
		
		
	}

}
