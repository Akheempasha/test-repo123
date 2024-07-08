package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("textarea.gLFyf")).sendKeys("selenium");
		
		driver.findElement(By.cssSelector("input[class=gNO89b]")).click();
		
		driver.close();

	}

}
