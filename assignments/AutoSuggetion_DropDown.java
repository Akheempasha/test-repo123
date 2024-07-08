package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggetion_DropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		 Thread.sleep(2500);
		
	List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
	        System.out.println(list.size());
	       
	        for(int i =0 ; i<=list.size();i++) {
	        	System.out.println(list.get(i).getText());
	        	
	        	if(list.get(i).getText().equals("selenium")) {
	        		list.get(i).click();
	        		break;
	        	}
	        }
    driver.close();
	}

}
