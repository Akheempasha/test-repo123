package object.repository;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OHRMDashboardPg {
	 
	//To assign web element locator value (i.e. Dashboard element)

	@FindBy (xpath = "//h6[text()='Dashboard']")
	WebElement DashboardObj;
	
	//Method: to return status based on "Dashboard" webelement availability	
	public boolean  DashboardDisplayed() {
		boolean mystatus = false;
		
		try {
		if(DashboardObj.isDisplayed()) {
			mystatus=true;
		}
	}
     catch(Exception e) {
    	 mystatus = false;
     }
     return(mystatus);
	}
}