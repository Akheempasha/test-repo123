package testng.frameworkk;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Demo {
	
	@AfterMethod
	public void refreshpg() {
		System.out.println("Successful refresh the page");
		Reporter.log(null);
	}
	
	@Test (priority = 0)
	public void AdminLoging() {
		System.out.println("Successful Login Operations");
	}
	
	@Test  (priority = 1)
	public void AdminLogout() {
		System.out.println("Successful Logout Operations");
	}
	
   @BeforeClass
   public void setUp() {
	   System.out.println("Initialize the browser");
   }
   @AfterClass
   public void tearDown() {
	   System.out.println("Close the application");
   }
}
