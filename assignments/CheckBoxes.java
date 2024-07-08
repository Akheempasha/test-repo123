package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
	    WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	List<WebElement> chk = driver.findElements(By.xpath("//div[@class='form-group'][4]//div"));
		
		System.out.println(chk.size());
		 //*Approach-1
	/*	for(WebElement chkk : chk) {
			chkk.click();
			System.out.println(chkk.getText()); */
		 //*Approach-2
	/*	for (int i=0; i<chk.size(); i++) {
			chk.get(i).click();
		}*/
		//*Select last 3 chk boxes
		
	/*	for(int i = 4; i<chk.size();i++) {
			chk.get(i).click();
		}*/
		
        //* Select first 3 chk boxes selected
		for(int i =0; i<chk.size()-4;i++) {
			 chk.get(i).click();
		}
         Thread.sleep(3000);
         
		for(WebElement chkk : chk) {
			if(!chkk.isSelected()) {
				chkk.click();
			}
			else {
				System.out.println("not Selected all");
			}
	    
		}
	 
		
}

}
 