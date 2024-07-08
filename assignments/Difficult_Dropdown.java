package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Difficult_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		

		System.out.println("Initialize the browser");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Successful User login");
		Thread.sleep(3000);
		//Select Info 
		driver.findElement(By.cssSelector("a[href='/web/index.php/pim/viewMyDetails']")).click();
		Thread.sleep(3000);
		//Click on Dropdown
		driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]")).click();
		Thread.sleep(3000);
		//Read all data
	 List<WebElement>list=driver.findElements(By.xpath("//div[@role='listbox']//div"));
		
		System.out.println(list.size());
		
		
		boolean status = false;
		
		for(int i=0;i<=list.size();i++) {
		//	System.out.print(list.get(i).getText());
			String option = list.get(i).getText();
			System.out.println(option);
			status = true;
			if(option.equalsIgnoreCase("North Korean")) {
				list.get(i).click();
				System.out.println("Successful Clicked");
			}
			else {
				status = false;
				System.out.println("Unsuccessful Attempt");
			}
			}
		    
}
}
