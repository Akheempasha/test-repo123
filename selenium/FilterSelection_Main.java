package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilterSelection_Main {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.t-mobile.com/cell-phones?INTNAV=tNav%3ADevices");
		driver.manage().window().maximize();
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		TimeUnit.SECONDS.sleep(3);
		
		FilterSelection filter = new FilterSelection(driver);
	//	filter.selectFilter("Network speed","4G LTE","4G","5G");
	//	filter.selectFilter("SIM type", "eSIM");
		filter.selectFilter("Deals");
		
		System.out.println("Successful Clicked");

	}

}
