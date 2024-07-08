package webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Select {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement select=driver.findElement(By.cssSelector("select#country"));
		System.out.println(select.getText());
		
		Select opt = new Select(select);
		 opt.selectByIndex(2);
		 Thread.sleep(3000);
		 opt.selectByValue("australia");
		 opt.selectByVisibleText("Germany");
		 Thread.sleep(3000);
		 
		 WebElement option = opt.getFirstSelectedOption();
		      System.out.println("first selected.."+option.getText());
		      Thread.sleep(2500);
		      
		  List<WebElement>optt =opt.getOptions();
		  System.out.println(optt.size());
		  for(WebElement list : optt) {
			  System.out.println("2nd.."+list.getText());
		  }
		 
		     
		 driver.quit();
		
	}

}
