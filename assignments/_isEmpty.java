package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _isEmpty {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	List<WebElement> chk =	driver.findElements(By.
			xpath("//div[@class='form-check form-check-inline']//input[@type='checkbox']"));
	
	System.out.println(chk.size());
	
	for(int i = 4; i<=chk.size();i++) {
		if(!chk.isEmpty())
			chk.get(i).click();
	}

	}

}
