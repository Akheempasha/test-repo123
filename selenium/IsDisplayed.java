package selenium;

 

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IsDisplayed {

	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.google.com");
		
		System.out.println("Before click Telugu");
		
		List<WebElement>list= driver.findElements(By.xpath("//a[.='తెలుగు']"));
		System.out.println(list.size());
		
		if(list.size()!=-1) {
			System.out.println("Displayed");
		}
		else {
			System.out.println("not Displayed");
		}
			
			 
	}
}
 
