package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
 

public class JavaScript {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		Thread.sleep(2000);
		js.executeScript("window.location='https://testautomationpractice.blogspot.com/'");
		
		js.executeScript("window.scrollBy(0,500)"," ");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		WebElement radio= driver.findElement(By.id("female"));
		js.executeScript("arguments[0].click();", radio);
		
		
		
		
		
		
		
		
		
		
		
		
//		js.executeScript("window.open();");
		
		
/*		js.executeScript("window.document.getElementById('name').value='Akheem'");
		
		js.executeScript("location.reload()");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
     	System.out.println(js.executeScript("return window.pageYOffset;"));  //1595
		js.executeScript("document.evaluate(\"//input[@id='male']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.click();");
		
		js.executeScript("history.go(0)");
		Thread.sleep(2500);
		js.executeScript("document.getElementById('name').scrollIntoView();");

     	js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");		
*/ 
		
}
}
