package datadriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orange {

	public static void main(String[] args) throws Exception {
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().minimize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    
			String path ="C:\\Users\\akhee\\OneDrive\\Desktop\\testdata.xlsx";
			int numofRows=Excel_Utils.getRowCount(path, "Sheet1");
			
			for (int i = 9; i <= numofRows; i++) {
				
			  String uid=Excel_Utils.getCellData(path, "Sheet1", i, 1);
			 String pwd= Excel_Utils.getCellData(path, "Sheet1", i, 2);
			 
			driver.findElement(By.name("username")).sendKeys(uid);
			driver.findElement(By.name("password")).sendKeys(pwd);
			Thread.sleep(2500);
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			
			if(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed()) {
				System.out.println("Test is Passed");
				Excel_Utils.setCellData(path, "Sheet1",  i, 3,"Test Passed");
				Excel_Utils.getredColour(path, "Sheet1", i,3);
				
			}
			else {
				System.out.println("Test is Failed");
				Excel_Utils.setCellData(path, "Sheet1",  i, 3,"Test Passed");
			}
		 driver.findElement(By.xpath("(//*[name()='img'])[3]")).click();
		 driver.findElement(By.xpath("//ul[@role='menu']/li[last()]")).click();
			}
			Thread.sleep(2500);
			driver.quit();
	}

}
