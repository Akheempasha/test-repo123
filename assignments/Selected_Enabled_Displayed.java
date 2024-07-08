package assignments;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selected_Enabled_Displayed {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice-automation.com/");
		driver.manage().window().maximize();

		WebElement link = driver.findElement(By.linkText("Form Fields"));
		if (link.isDisplayed()) {
			link.click();
			System.out.println("Displayed Successfull");
		} else {
			System.out.println("not Displayed");
		}

		WebElement ele = driver.findElement(By.id("name"));
		ele.sendKeys("Khan");
		System.out.println(ele.getAttribute("value"));

		boolean status = false;
		List<WebElement> chk = driver.findElements(By.xpath("//label[contains(@for,'drink')]"));
		System.out.println(chk.size());
		Thread.sleep(3000);
		for (WebElement chkbox : chk) {
			// System.out.println(chkbox.getText());
			String box = chkbox.getText();
			if (box.equals("Coffee")) {
				chkbox.click();
				System.out.println("Successful clicked");
				status = true;
			}
		}

		if (status = false) {
			System.out.println("Doesn't Exits in a page");
		}
		
		 		
	//	driver.findElement(By.xpath("//button[@id='submit-btn']")).sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeght)");
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.xpath("//button[@id='submit-btn']"));

		if (button.isEnabled()) {
			button.sendKeys(Keys.ENTER);
			System.out.println("Successful enabled");
		} else {
			System.out.println("button is disabled");
		}
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("accetpted");
		
}

}
