package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterSelection {
	WebDriver driver;

	FilterSelection(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectFilter(String filterType, String ... subMenu ) throws Exception {
		 WebElement filterElement1 = driver.findElement(By
					.xpath("//legend[contains(text(),'" + filterType + "')]"));
		scrollView(filterElement1);
		
		if(subMenu[0].equals("all")) {
			String allitem_Xpath = "//legend[contains(text(),'"+filterType+"')]//div[@class='phx-field__picker ']"
					+ "//span[@class='phx-field__indicator']";
		//	driver.findElements(By.xpath(allitem_Xpath)).stream().forEach(e->e.click());
			                 //or
			List<WebElement> alls =driver.findElements(By.xpath(allitem_Xpath));
			for (WebElement chk : alls) {
				if(!chk.isSelected()) {
					chk.click();
				//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", chk);
					
				}
			}
		}
		
		else {
         WebElement filterElement = driver.findElement(By
				.xpath("//legend[contains(text(),'" + filterType + "')]"));
            
     	scrollView(filterElement);
		for (String arg : subMenu) {
			WebElement optionElement = driver.findElement(By
					.xpath("//span[text()='" + arg + "']"));
			optionElement.click();
		}
		}
		
}
	
	public void scrollView(WebElement ele) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-100)");
		
	}
	
}
