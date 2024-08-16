package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterSelection {
	WebDriver driver;

	FilterSelection(WebDriver driver) {
		this.driver = driver;
	}
	public void selectFilter(String filterType, String... args) throws InterruptedException {
         WebElement filterElement = driver.findElement(By
				.xpath("//legend[contains(text(),'" + filterType + "')]"));
              filterElement.click();

		TimeUnit.SECONDS.sleep(3);

		for (String arg : args) {

			WebElement optionElement = driver.findElement(By
					.xpath("//span[text()='" + arg + "']"));
			optionElement.click();
		}
		
		
		
}
}
