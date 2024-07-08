package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Googlelang {
	
	
	WebDriver driver;
	
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		System.out.println("Initialize the browser");
		
	}

	public void langSelec(String langu) throws Exception {
		driver.findElement(By.linkText(langu)).click();
		Thread.sleep(3000);
         System.out.println("Select the language..."+langu);
         
	}
	
	public void close() {
		driver.close();
		System.out.println("Close the application");
	}
	
}
