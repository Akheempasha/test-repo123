package test.cases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import object.repository.OHRMDashboardPg;
import object.repository.OHRMHomePg;

public class OHRMLoginValidation {

	public static void main(String[] args) throws IOException {
		//To Initialize Browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		   //implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//To initialize "object.repository" package classes
        
		OHRMHomePg ohp =PageFactory.initElements(driver, OHRMHomePg.class);
   OHRMDashboardPg odp = PageFactory.initElements(driver, OHRMDashboardPg.class);
   
   //To perform login operations
   ohp.setuid("Admin");
   ohp.setpwd("admin123");
   ohp.clickbtn();
   
 //to verify login successful or not
   if(odp.DashboardDisplayed()) {
	   System.out.println("Successful login");
     }
   else {
	   File myfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(myfile,new File("./Defects1\\ohrm"+".png"));
	   
	   System.out.println("Unsuccessful login");
         }
			
}

}
