package javaa.streams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java8_Selenium {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println("NUmber of links are.."+links.size());
		/*
		for (WebElement element : links) {
			System.out.println(element.getText());
		}
		*/
	//	links.forEach(ele->System.out.println(ele.getText()));
		links.stream().filter(ele->  !ele.getText().equals("")).forEach(ele->System.out.println(ele.getText()));
		
		

	}

}
