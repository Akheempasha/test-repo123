package links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_DropDown {

	public static void main(String[] args) throws InterruptedException {
	    WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement ele=driver.findElement(By.xpath("//select[@id='country']"));
		System.out.println(ele.getText());
		
		Select drop = new Select(ele);
		
		drop.selectByVisibleText("Germany");
		Thread.sleep(3000);
		drop.selectByIndex(6);
		Thread.sleep(3000);
		drop.selectByValue("france");
		 
	   	List<WebElement>all=drop.getOptions();
		
		System.out.println("number of option in dropdown.."+all.size());
	 
		
		
		
	}

}
