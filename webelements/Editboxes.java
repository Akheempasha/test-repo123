package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Editboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	    WebElement ele=	driver.findElement(By.cssSelector("input#name"));
	    
	    ele.click();
	    Thread.sleep(3000);
	    ele.sendKeys("Akheem");
	    Thread.sleep(3000);
	    String obj=driver.findElement(By.cssSelector("input#name")).getAttribute("value");
	    System.out.println(".."+obj);
	    Thread.sleep(3000);
	    ele.clear();
	    
	    driver.close();

	}

}
