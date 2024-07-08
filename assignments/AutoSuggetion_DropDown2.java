package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggetion_DropDown2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bjs.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("search")).sendKeys("amazon");
		
		List<WebElement>list=driver.findElements(By.xpath("//div[@class='list list-group']"));
		  System.out.println(list.size());
		  Thread.sleep(2000);
		  for(int i=0;i<=list.size(); i++) {
			  System.out.println(list.get(i).getText());
			  
			  if(list.get(i).getText().equalsIgnoreCase("amazon gifts card")) {
				  System.out.println("Target Element Clicked");
				  list.get(i).click();
			        break;
			  }
		  }
	  driver.close();
	}

}
