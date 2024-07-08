package object.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OHRMHomePg {
	//To assign element locator values	
	   @FindBy(name="username")
	    WebElement usernameObj;
	   
	   @FindBy (name="password")
	   WebElement passwordObj;
	   
	   @FindBy (xpath="//button[@type='submit']")
	   WebElement buttonObj;
	   
	 //Methods to perform operations on WebElement
        public void setuid(String uid) {
        	usernameObj.sendKeys(uid);
        }
	    
        public void setpwd(String pwd) {
        	passwordObj.sendKeys(pwd);
        }

        public void clickbtn() {
        	buttonObj.click();
        }

}
