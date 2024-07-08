package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PushButtons {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		String obj=driver.findElement(By.cssSelector("button[name=login]")).getText();
		System.out.println(obj);
		
		String object=driver.findElement(By.cssSelector("button[name=login]")).getAttribute("name");
		System.out.println("attribute.."+object);
		
		
		WebElement btn = driver.findElement(By.cssSelector("button[name=login]"));
		if(btn.isEnabled()) {
			btn.click();
			System.out.println("Button enabled");
		}
		else {
			System.out.println("Button disabled");
		}
		
		
		
		
	}

}
