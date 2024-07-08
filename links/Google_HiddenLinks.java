 package links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_HiddenLinks {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.co.in");
	driver.manage().window().maximize();
	
	
	List<WebElement> link= driver.findElements(By.tagName("a"));
	  System.out.println(link.size());
	  
	  int count = 0;
	  for (WebElement links : link) {
		  System.out.println(links.getText());
		  System.out.println("================");
		  System.out.println(links.getAttribute("href"));
		  
		   if(!links.getText().isEmpty())
		            count++;
	}
	System.out.println("Number of visible links are.."+count);
	
	System.out.println("Number of invisble links are.."+(link.size()-count));

	}

}
