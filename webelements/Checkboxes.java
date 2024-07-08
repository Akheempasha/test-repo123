package webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement>chk=driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//input[@type='checkbox']"));
         System.out.println(chk.size());
                 
         for(WebElement chkboxes : chk) {
        	 if(!chkboxes.isSelected()) {
        		 chkboxes.click();	
        	 }
        	 }
     System.out.println("Successful clicked all tha boxes");
	
     for(int i=0;i<chk.size();i++) {
    	//System.out.println(chk.get(i).getText());
    	 WebElement obj=chk.get(i);
    	 if(obj.isSelected()) {
    		 obj.click();
    	 }
         }
	System.err.println("Successfull Unclicked all the boxes");
	
	 

	
	
	
	}

}
