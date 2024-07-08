package automation.testing;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Testing_Practice {

	WebDriver driver;
	ExtentReports exReports;
	ExtentTest test;

	@BeforeSuite
	public void Reports() {
		exReports = new ExtentReports();
		exReports.setSystemInfo("Name", "Akheem");
		exReports.setSystemInfo("os", "Windows 11");
		exReports.setSystemInfo("Testing", "Regression");
		exReports.setSystemInfo("Browser", "Chrome");

		ExtentSparkReporter sparkReport = new ExtentSparkReporter("reports.html");
	//	ExtentSparkReporter sparkReport_fail = new ExtentSparkReporter("failreports.html");
	//	sparkReport_fail.filter().statusFilter().as(new Status[] { Status.FAIL });
		exReports.attachReporter(sparkReport);

		test = exReports.createTest("Automation-testing");
		System.out.println("Extent report");

	}
   // @Parameters("Browser")
	@BeforeTest 
	public void setUp(ITestContext context) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        
	//	if(Browser.contentEquals("Chrome"))
		driver = new ChromeDriver(options);
		// driver.get(Url);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Automation Testing Practice";
		assertEquals(actualTitle, expectedTitle, "Title is matched");
		assertTrue(true);
		System.out.println("Successfull initialaize");
		exReports.createTest(context.getName());

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browser = cap.getBrowserName() + " " + cap.getBrowserVersion();

		test.assignDevice(browser);
		test.assignAuthor("akheem");
	}

	@Test(priority = 1,dataProvider="textData")
	public void userDetailes(String name ,String email ) throws InterruptedException, IOException {

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(2500);
		driver.findElement(By.id("phone")).sendKeys("512111351351");
		driver.findElement(By.id("textarea")).sendKeys("kdsfjdb fhsjkgfs gfjsgfsfskfbsfb");
		System.out.println("userdetailes Added");
		Thread.sleep(2500);

		/*
		 * Date dt = new Date(); 
		 * DateFormat df = new SimpleDateFormat("dd_mm_yyyy hh:mm:ss"); 
		 * File myfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileHandler.copy(myfile, new File("./screenshot\\automation.img"));
		 * test.addScreenCaptureFromPath("./screenshot\\automation.img");
		 test.pass("Test is passed");
		 */ 
         
	}

	@Test(priority = 2 , timeOut =1500)
	public void radioButton() {
		driver.findElement(By.xpath("//input[@id='male']")).click();
		System.out.println("Male radio button Selected");

	}

	@Test(priority = 3)
	public void checkBoxes() throws InterruptedException {
		List<WebElement> chk = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		chk.size();
		for (int i = 0; i < chk.size(); i++) {
			chk.get(i).click();
			Thread.sleep(3000);
			// unselect check boxes
			chk.get(i).click();
		}
	}

	@Test(priority = 4)
	public void dropdown() throws InterruptedException {
		WebElement opt = driver.findElement(By.xpath("//select[@id='country']"));
		System.out.println("Number of dropdowns.." + opt.getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", opt);

		Select ele = new Select(opt);
		Thread.sleep(3000);
		ele.selectByIndex(3);
		Thread.sleep(2500);
		ele.selectByVisibleText("Australia");
		ele.selectByValue("japan");

		String opts = ele.getFirstSelectedOption().getText();
		System.out.println("Selected dropdown.." + opts);

		if (opts.equals("Japan")) {
			System.out.println("Already Selected dropdown");
		} else {
			ele.selectByVisibleText("Japan");
			System.out.println("WD Selected dropdown");
		}

	}

	@Test(priority = 5)
	public void colorsDD() throws InterruptedException {
		WebElement op = driver.findElement(By.xpath("//select[@id='colors']"));
		System.out.println("Number of dropdowns.." + op.getText());

		Select elel = new Select(op);
		Thread.sleep(2500);
//	  elel.selectByIndex(3);
//	  Thread.sleep(2500);
//	  elel.selectByValue("blue");
//	  Thread.sleep(2500);
		elel.selectByVisibleText("White");

		String option = elel.getFirstSelectedOption().getText();
		System.out.println("First selected.." + option);
		Thread.sleep(2500);
		List<WebElement> options = elel.getOptions();
		System.out.println("Number of size.." + options.size());
		Thread.sleep(2000);

		// Approach-2 get all text in consloe
		/*
		 * for(int i =0; i<=options.size();i++) {
		 * System.out.println("Number of text.."+options.get(i).getText()); }
		 */
	}

	@Test(priority = 6)
	public void date() throws InterruptedException {
		// Expected Date
		String month = "May 2025";
		String day = "16";

		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(5000);

		while (true) {
			// Month & Year
			String text = driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
			if (text.equals(month)) {
				break;
			} else {
				// Next Button
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}

		}
		// Pick The Date
		driver.findElement(
				By.xpath("//div[@id='ui-datepicker-div']//table/tbody[1]/tr[3]/td/a[contains(text()," + day + ")]"))
				.click();

		System.out.println("Successful dateppicked");

	}

	@Test(priority = 7)
	public void newWindow() throws InterruptedException {
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

		Set<String> pgHandles = driver.getWindowHandles();

		Iterator<String> winHandles = pgHandles.iterator();

		String win1 = winHandles.next();
		String win2 = winHandles.next();

		System.out.println(win1);
		System.out.println(win2);

		driver.switchTo().window(win2);
		System.out.println("2nd pg title.." + driver.getTitle());

		List<WebElement> pg2 = driver.findElements(By.tagName("a"));
		System.out.println(pg2.size());

		WebElement opencart = driver.findElement(By.xpath("//a[text()='Desktops']"));
		opencart.click();

		opencart.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		opencart.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		opencart.sendKeys(Keys.ENTER);

		driver.close();
		Thread.sleep(2500);
		// Switch to Parent Window
		driver.switchTo().window(win1);
		System.out.println(driver.getTitle());
	}

	@Test(priority = 8,dependsOnMethods = "newWindow",alwaysRun = true)
	public void jsAlert() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick='myFunctionAlert()']")).click();
		Thread.sleep(3000);
		Alert js = driver.switchTo().alert();
		js.accept();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@onclick='myFunctionConfirm()']")).click();
		js.dismiss();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@onclick='myFunctionPrompt()']")).click();
		js.sendKeys("My name is Akheem");
		String msg = js.getText();
		System.out.println(msg);
		js.accept();

	}

	@Test(priority = 9)
	public void drag_Drop() {

		WebElement ele1 = driver.findElement(By.id("draggable"));
		WebElement ele2 = driver.findElement(By.id("droppable"));

		Actions add = new Actions(driver);
		add.dragAndDrop(ele1, ele2).perform();
		System.out.println("Successfully Droped");
	}

	@Test(priority = 10)
	public void webTable() {
		// find total number of rows in a table
		int row = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Number of rows.." + row);
		// find total number of cols in a table
		int col = driver.findElements(By.xpath("//table[@name='BookTable']//tr/th")).size();
		System.out.println("Number of col.." + col);

		System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price" + "\t");
		// read all tha data from rows and cols
		for (int r = 2; r <= row; r++) {
			for (int c = 1; c <= col; c++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.print(value + "\t");
			}
			System.out.println();
		}

		// print book names whose the author is mukesh
		for (int r = 2; r <= row; r++) {
			String authorname = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]"))
					.getText();
			if (authorname.equals("Mukesh")) {
				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]"))
						.getText();
				System.out.println(bookname + "\t" + authorname);
			}
		}

		// print all the price names
		// All price Values addition
		int total = 0;
		for (int r = 2; r <= row; r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
			total = total + Integer.parseInt(price);

			System.out.println("Total price of the books." + total);
		}
	}

	@Test(priority = 11)
	public void newTab() throws InterruptedException {

		driver.findElement(By.className("wikipedia-search-input")).sendKeys("selenium");

		driver.findElement(By.className("wikipedia-search-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();

		System.out.println(driver.getTitle());

		Set<String> pgHandle = driver.getWindowHandles();

		Iterator<String> winHandle = pgHandle.iterator();

		String win1 = winHandle.next();
		String win2 = winHandle.next();
		System.out.println(win1 + "   &   " + win2);

		driver.switchTo().window(win2);
		System.out.println(driver.getTitle());

		WebElement link = driver.findElement(By.xpath("//a[@href='#History']"));
		link.getAttribute("href");
		link.getText();
		System.out.println(link);
		if (link.getText().equals("History")) {
			link.click();
			System.out.println("Sucessfully Displayed");
		} else {
			System.out.println("link not identified");
		}

		driver.close();
		driver.switchTo().window(win1);
		System.out.println(driver.getTitle());
	}

	@Test(priority = 12)
	public void slider() throws InterruptedException {
		WebElement slider = driver.findElement(By.xpath(".//*[@style='left: 0%;']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", slider);

		js.executeScript("arguments[0].setAttribute('style','backgrond:yellow;border:2px dashed red')", slider);
		Thread.sleep(5000);
		Actions action = new Actions(driver);

		action.dragAndDropBy(slider, 300, 0).perform();
		Thread.sleep(3000);
		action.clickAndHold(slider).moveByOffset(-150, 0).release().perform();

	}

//	@Test(enabled = false)
	@Test(priority = 13, enabled = false)
	public void resizable() throws InterruptedException {
		// ExplicitWait
		WebDriverWait obj = new WebDriverWait(driver, Duration.ofSeconds(10));
		obj.until(ExpectedConditions.presenceOfElementLocated(By.id("resizable")));

		WebElement siz = driver.findElement(By.id("resizable"));

		Actions action = new Actions(driver);

		action.dragAndDropBy(siz, 290, 200);
		action.perform();

	}

	@Test(priority = 14)
	public void brokenLinks() throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println(link.size());

		for (WebElement links : link) {
			String linkurl = links.getAttribute("href");
			try {
				URL url = new URL(linkurl);

				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
				httpConn.setConnectTimeout(3000);
				httpConn.connect();

				if (httpConn.getResponseCode() == 200) {

					System.out.println(linkurl + " - " + httpConn.getResponseMessage());
				}
				else {
					System.err.println(linkurl + " - " + httpConn.getResponseCode());

					httpConn.disconnect();
				 }
			     }
			catch (Exception e) {
				System.out.println(e);

			}

		}

	}

	@Test(priority = 15)
	public void hiddenlinks() {

		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println(link.size());

		int count = 0;
		for (WebElement links : link) {
			// System.out.println(links.getText());
			System.out.println(links.getAttribute("href") + " && " + links.getText());

			if (!links.getText().isEmpty()) {
				count++;
			}
		    }
		System.out.println("Number of visible links are." + count);

		System.err.println("Number of Invisible links are.." + (link.size() - count));

	}

	@Test(priority = 16)
	public void iFrames() {

		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//input[@class='text_field']")).sendKeys("khan kumar");

		driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-1_0']")).click();

		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

		WebElement cal = driver.findElement(By.xpath("//Select[@class='ui-datepicker-year']"));
		Select year = new Select(cal);
		year.selectByVisibleText("1974");

		String month = "February";
		String day = "17";

		while (true) {
			String text = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if (text.equals(month)) {
				break;
			}

			else {
				driver.findElement(By.xpath("//a[@data-handler='prev']")).click();

			}
		}
		driver.findElement(
				By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[contains(text()," + day + ")]"))
				.click();
		System.out.println("Successful Date picked");

		WebElement job = driver.findElement(By.id("RESULT_RadioButton-3"));
		Select list = new Select(job);
		list.selectByValue("Radio-1");

		driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		System.out.println("Successful completed iFrames");
	}

	@Test(priority = 17)
	public void paginationTable() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		int num = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
		System.out.println("pagination Buttons.." + num);

		for (int p = 0; p <= 4; p++) {
			if (p > 0) {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//ul[@class='pagination']//a[text()=" + p + "]")).click();

				List<WebElement> chk = driver.findElements(By.xpath("//table[@id='productTable']//tr//td//input"));
				for (int i = 0; i < chk.size(); i++) {
					Thread.sleep(3000);
					chk.get(i).click();

				}

				int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
				// System.out.println("Number of Rows.."+rows);
				Thread.sleep(3000);

				for (int r = 1; r <= rows; r++) {

					String ID = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[1]"))
							.getText();
					String Name = driver
							.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[2]"))
							.getText();
					String Price = driver
							.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[3]"))
							.getText();
					String Select = driver
							.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[4]"))
							.getText();

					System.out.println(ID + "\t" + Name + "\t" + Price + "\t" + Select);

				}
			}
		}
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
	public void checkStatus(Method m, ITestResult result) throws InterruptedException, IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Date dt = new Date();
			DateFormat df = new SimpleDateFormat("DD_MM_YYYY_HH_MM_SS");
		 
			File myfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(myfile, new File("./screenshot\\practice1"+df.format(dt)+".png"));
			 
			
			test.addScreenCaptureFromPath("./screenshot\\practice1.png");
			test.fail(result.getThrowable());

		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(m.getName() + "is passed");

		}

		test.assignCategory(m.getAnnotation(Test.class).groups());
		Thread.sleep(3000);

	}

	@DataProvider
	public String[][] textData() {
		String[][] data= {{"Akheem","Pasha123@gmail.com"}};
		return data;
		
	}
	
	
	
}
