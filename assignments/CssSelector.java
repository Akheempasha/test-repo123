package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CssSelector {

	public static void main(String[] args) throws Exception {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.oyorooms.com/");
		 driver.manage().window().maximize();
		     // id
		 driver.findElement(By.cssSelector("input#autoComplete__home")).sendKeys("Hyderabad");
		 Thread.sleep(3000);
		  //contains
	List<WebElement> city= driver.findElements(By.cssSelector("span[class*='locationName']"));
             System.out.println("Number of citys.."+city.size());
              boolean status = false;
             try {
             for(int i=0;i<city.size();i++) {
            	 System.out.println(city.get(i).getText());
            	 status =true;
             	 if(city.get(i).getText().equals("Gachibowli, Hyderabad, Telangana")) {
            		 city.get(i).click();
            			 break;
            	 }
            	 else if(status = false) {
                   System.out.println("not clicked");
            	 }
            	 
            	 
            	 }
          
                //ends-with
             driver.findElement(By.cssSelector("div[class $='_dateRangePicker']")).click();
             
             WebElement month =driver.findElement(By.xpath("(//select[@class='DateRangePicker__MonthHeaderSelect'])[1]"));
               Select ele = new Select(month);
               ele.selectByVisibleText("December");
               Thread.sleep(3000);
               WebElement year =driver.findElement(By.xpath("(//select[@class='DateRangePicker__MonthHeaderSelect'])[2]"));  
               Select elel = new Select(year);
               elel.selectByValue("2024");
              
               driver.findElement(By.xpath("(//table[@class='DateRangePicker__MonthDates']//tr//td/span[text()='26'])[2]")).click();
               Thread.sleep(3000);
               driver.findElement(By.xpath("(//table[@class='DateRangePicker__MonthDates']//tr//td/span[text()='28'])[2]")).click();
               System.out.println("Successful clicked");
              }
             catch(Exception e) {
            	 throw  e;
             }
             
             driver.findElement(By.cssSelector("div[class $= 'guestRoomPicker--home ']")).click();
             driver.findElement(By.cssSelector("span[class='guestRoomPickerPopUp__plus'] svg")).click();
             driver.findElement(By.cssSelector("span[class='guestRoomPickerPopUp__plus'] svg")).click();
             Thread.sleep(2500);
             driver.findElement(By.cssSelector("div[class$='homeSearchWidget__search'] button")).click();
             
	}
}
