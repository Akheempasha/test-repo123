package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion_NewApproach {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("q")).sendKeys("selenium");

		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
          System.out.println(list.size());
          
           //Approach -2
		 int row =list.size();
		 Thread.sleep(2500);
		 list.get(row-2).click();
	}

}
