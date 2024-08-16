package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table4 {
	static WebDriver driver;
	
	public  static void selet(String brands) {

		List<WebElement> list = driver.findElements(By
				.xpath("//legend[normalize-space(text())='Brands']//span[@class='phx:weight-normal']"));
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).getText());
			
			switch(brands) {
			
			case "Apple": 
				list.get(i).click(); 
				break;
			case "Google": list.get(i).click();  break;
			case "Motorola": list.get(i).click(); break;
			case "Nokia":	  break;
			}
		//	list.get(i).click();	
			}
		}

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.t-mobile.com/cell-phones?INTNAV=tNav%3ADevices");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
	String brand = driver.findElement(By.xpath("//legend[normalize-space(text())='Brands']")).getText();
		
		selet(brand);
		
	}

	}	
		
		

		 

	


