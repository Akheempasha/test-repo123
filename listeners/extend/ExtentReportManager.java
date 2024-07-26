package listeners.extend;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
 
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public WebDriver driver = null;

	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter("Reports.html");
		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of Report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("TestName", "Akheem");
		extent.setSystemInfo("OS", "Windows-11");
		extent.setSystemInfo("Browser Name", "Chrome");

		extent.attachReporter(sparkReporter);
		System.out.println("Test case execution is started");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // Create a new Entry in the report
		test.log(Status.PASS, "Test case Passed: " + result.getName()); // update Status
		System.out.println(result.getName()+"Passed");
	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case Failed is: " + result.getName());
		test.log(Status.FAIL, "Test case Failed Cause is: " + result.getThrowable());
		
		 try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		   }
		 catch (Exception e) {
			e.printStackTrace();
		 }

		if (result.getStatus() == ITestResult.FAILURE) {

			Date dt = new Date();
			DateFormat df = new SimpleDateFormat("DD_MM_YYYY_HH_MM_SS");

			TakesScreenshot ts = ((TakesScreenshot) driver);
			File mfile = ts.getScreenshotAs(OutputType.FILE);
			File sfile = new File("./screenshot\\" + result.getName() + df.format(dt) + ".png");
			mfile.renameTo(sfile);

			test.addScreenCaptureFromPath("orange.jpg");
		      System.out.println("ScreenShot saved");
		      System.out.println(result.getName()+"...Failed");
		
		 }

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case Skipped is: " + result.getName());
		System.out.println(result.getName()+"...Skipped");
	}

	public void onFinish(ITestContext context) {
		extent.flush();

		try {
			Desktop.getDesktop().browse(new File("Reports.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("extent reports flushed");


	}

}
