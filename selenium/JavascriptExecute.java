package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavascriptExecute {

	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(option);
		
		((JavascriptExecutor)driver).executeScript
		            ("window.location='https://testautomationpractice.blogspot.com/'");
	    ((JavascriptExecutor)driver).executeScript("location.reload();");
	        Thread.sleep(3000);
	    ((JavascriptExecutor)driver).executeScript("history.go(0);");
		
 /*            //or
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		
		js.executeScript("window.location='https://testautomationpractice.blogspot.com/'");
		
		js.executeScript("window.document.getElementById('name').value='Akheem'");
		
		js.executeScript("document.getElementById('male').click()");
		
		WebElement classs=driver.findElement(By.className("active"));
		
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true);", classs);
		js.executeScript("arguments[0].setAttribute('style','background:red;border:2px dashed red')", classs);
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,-500)");
		driver.switchTo().frame(0);
	//	js.executeScript("document.getElementsByClassName('submit_button')[0].click()");
		
		js.executeScript("document.getElementsByClassName('submit_button')[0].style.backgroundColor = 'green';");
		js.executeScript("document.getElementsByClassName('submit_button')[0].style.border = '2px dashed red';");
*/
			
	}

}
