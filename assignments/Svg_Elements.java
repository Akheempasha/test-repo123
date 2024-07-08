package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Svg_Elements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		  driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		  driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		  driver.findElement(By.cssSelector("button[type='submit']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath(" //ul[@class='oxd-main-menu']//child::a//child::*")).click();
		  Thread.sleep(3000);
	      driver.navigate().back();
	      
	      driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item']//*[name()='svg'])[2]")).click();
	      Thread.sleep(3000);
	      driver.navigate().back();
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("(//*[local-name()='svg']//parent::*)[21]")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("(//*[name()='path' and contains(@d,'175.534')]//ancestor::*)[12]")).click();
	      
	   //  driver.findElement(By.xpath("//i[contains(@class,'bi-caret-down-fill')]")).click();
	       driver.findElement(By.cssSelector("i[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	
	    //   driver.findElement(By.xpath(" //a[contains(@href,'logout')]")).click();
	       
	     //  driver.findElement(By.linkText("Logout")).click();
	       driver.findElement(By.cssSelector("a.oxd-userdropdown-link[href='/web/index.php/auth/logout']")).click();
	       
	       
	  WebElement button= driver.findElement(By.xpath("//button[text()=' Login ']"));
	       if(button.isDisplayed()) {
	          System.out.println("Successful logout");
	       }
	         driver.quit();
}

}
