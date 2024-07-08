package automation.testing;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass  {
	
	WebDriver driver;
	ExtentReports exReports;
	ExtentTest test;
	
	@BeforeSuite
	public void Reports() {
		exReports = new ExtentReports();
		exReports.setSystemInfo("Name","Akheem");
		exReports.setSystemInfo("os","Windows 11" );
		exReports.setSystemInfo("Testing","Regression");
		exReports.setSystemInfo("Browser","Chrome");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("reports.html");
		ExtentSparkReporter sparkReport_fail = new ExtentSparkReporter("failreports.html");
		sparkReport_fail.filter().statusFilter().as(new Status[] {Status.FAIL});
		exReports.attachReporter(sparkReport,sparkReport_fail);
		
		test = exReports.createTest("Automation-testing");
		System.out.println("Extent report");
		
	}
	
	
	
	@Parameters({"Browser"})
	@BeforeTest
	public void setup(String Browser) {
		switch(Browser.toLowerCase()) {
		
		case "chrome":
			driver = new ChromeDriver();
			System.out.println("Initialize the ChromeBrowser");
			break;
		
		case "edge":
			driver = new EdgeDriver();
			System.out.println("Initialize the EdgeBrowser");
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			System.out.println("Initialize the FirefoxBrowser");
			break;
		
		default :
			System.out.println("Invalid Browser name");
			break;
		  }
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com");
		test.info("Navigate to url");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
		String browser=cap.getBrowserName()+" "+cap.getBrowserVersion();
		
		test.assignDevice("chrome","firefox","edge");
		test.assignAuthor("akheem");
		
}
     
	@AfterTest
	public void closeappl() throws InterruptedException {
		Thread.sleep(2500);
		driver.close();
		System.out.println("Successful Closed The Appln");
		
	}
    
	@AfterSuite
	public void endReport() throws IOException {
		exReports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
	//	Desktop.getDesktop().browse(new File("failreports.html").toURI());
		
		System.out.println("Extent report flushed");
	}
	
	@AfterMethod
	public void checkStatus(Method m,ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File myfile = ts.getScreenshotAs(OutputType.FILE);
			File dustfile = new File("./screenshot\\practice.png");
			myfile.renameTo(dustfile);
			test.addScreenCaptureFromPath("./screenshot\\practice.img");
			test.fail(result.getThrowable());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.pass(m.getName()+ "is passed");
			
		}
	
		test.assignCategory(m.getAnnotation(Test.class).groups());
	
	}











}
