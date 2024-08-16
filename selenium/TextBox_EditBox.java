package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 

public class TextBox_EditBox {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		
		WebElement Test=driver.findElement(By.id("userName"));
		
		Test.sendKeys("Akheem");
		Test.clear();
		Test.sendKeys("Akheem PAsha");
		System.out.println(Test.getAttribute("value"));
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
		
		if(driver.findElement(By.id("noRadio")).isEnabled()==true) {
			System.out.println("RadioButton Enabled");
		}
		else {
			System.out.println("RadbioButton Disabled");
		}
		
		
		
	}

}
