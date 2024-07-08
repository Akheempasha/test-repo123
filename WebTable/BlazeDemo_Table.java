package WebTable;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemo_Table {
 
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement opt=driver.findElement(By.name("fromPort"));
		Select ele = new Select(opt);
		ele.selectByIndex(2);
		
		WebElement opt2=driver.findElement(By.name("toPort"));
		Select ele2 = new Select(opt2);
		ele.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		String[] arr= {"$472.56","$432.98","$200.98","$765.32","$233.98"};
		
		int n=arr.length;
		Arrays.sort(arr);
		System.out.println("Print smallest price..."+arr[0]);
		
		boolean status = false;
		
		List<WebElement> row=driver.findElements(By.tagName("tr"));
		System.out.println("Number of rows.."+row.size());
		   for(int r=1;r<=row.size();r++) {
			 String rows=driver.findElement(By.xpath("//table//tr["+r+"]//td[6]")).getText();
			System.out.println(rows);
			
	 
		if(rows.equals(arr[0])){
			status = true;
		    driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[3]")).click();
			System.out.println("Successful select Smallest price");	
			 break;
				 
			 }
		if(status=false) {
			System.out.println("Not Matched");
		     }
			 }
		
		 
		 Thread.sleep(5000);
		 		
		driver.findElement(By.id("inputName")).sendKeys("anilkumar");
		driver.findElement(By.name("address")).sendKeys("sr nager");
		driver.findElement(By.name("city")).sendKeys("Hyderabad");
		driver.findElement(By.name("state")).sendKeys("Telangana");
		driver.findElement(By.name("zipCode")).sendKeys("500000");
		driver.findElement(By.name("state")).sendKeys("Telangana");
		
	WebElement elel=driver.findElement(By.xpath("//Select[@class='form-inline']"));
		  Select visa = new Select(elel);
		  visa.selectByIndex(1);
		     Thread.sleep(3000);
		  driver.findElement(By.name("creditCardNumber")).sendKeys("253165165165165");
		  driver.findElement(By.id("creditCardMonth")).sendKeys("05");
		  driver.findElement(By.name("creditCardYear")).sendKeys("2020");
		  driver.findElement(By.xpath("//input[@placeholder='John Smith']")).sendKeys("khan");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//label[@class='checkbox']")).click();
		   
		 if(driver.findElement(By.xpath("//input[@class='btn btn-primary']")).isDisplayed()) {
			 System.out.println("Successful purchase flight Displayed");
			 driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
			 Thread.sleep(3000);
				Date dt = new Date();
				DateFormat df = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
				File myfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(myfile, new File("./Defects\\flightsc"+df.format(dt)+".png"));
				  System.out.println("Screeshot Succesful completed");
			 
		 }
		 else {
			System.out.println("Unsuccessful attempt"); 
		 }
		driver.close();
	
		
		 
    }
	}

	

