package calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		String day = "17";
		
		driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-May-2025']//div[text()="+day+"]")).click();
		
	 	

	}

}
