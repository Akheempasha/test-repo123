package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Htmlunit {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(option);
	//	WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		
		System.out.println("title is.."+driver.getTitle());

	}

}
