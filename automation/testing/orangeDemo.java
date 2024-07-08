package automation.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
public class orangeDemo {
	 WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("Successful open");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void userLogin() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\akhee\\OneDrive\\Desktop\\testdata.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		
		String path = "C:\\Users\\akhee\\OneDrive\\Desktop\\testdata.xlsx";
		
		
		for (int r = 1; r <= row; r++) {

			String id = sheet.getRow(r).getCell(0).toString();
			String pwd = sheet.getRow(r).getCell(1).toString();

			driver.findElement(By.name("username")).sendKeys(id);
			driver.findElement(By.name("password")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			 
			if(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed()) {
				System.out.println("Test is Passed");
				OrangeBaseClass.setcellData(path, "Sheet1", r, 2,"Test Passed");
			}
			else {
				System.out.println("Test is Failed");
				OrangeBaseClass.setcellData(path, "Sheet1", r, 2,"Test Failed");
			}
			Thread.sleep(2500);
			driver.findElement(By.xpath("//img[@alt='profile picture']")).click();

			driver.findElement(By.linkText("Logout")).click();
			
		    }

		book.close();
		fis.close();
	}

	@AfterMethod
	public void screeShot(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File mfile = new File("./screenshot\\orange.png");
			File dustFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyDirectory(mfile, dustFile);
			System.out.println("Screenshot saved");
		}
			
		 else if (result.getStatus() == ITestResult.SUCCESS) {

			File myfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(myfile, new File("./screenshot\\orange1.png"));	 
			System.out.println("Screenshot not saved");
		 }

	}

	@AfterClass
	public void teatDown() throws IOException, Exception {
		
		Thread.sleep(2500);
		driver.quit();
	}
	
 

}
