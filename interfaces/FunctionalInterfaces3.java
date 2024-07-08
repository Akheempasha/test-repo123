package interfaces;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;

public class FunctionalInterfaces3 extends FunctionalInterfaces2{
 
	public void login() {
		try {
		pro.load(fis);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(pro.getProperty("uid"));
		driver.findElement(By.name("password")).sendKeys(pro.getProperty("pwd"));
		
		if(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed()) {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		  System.out.println("Successful login");
		}	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}

	 
	public void logout() {
		 driver.findElement(By.xpath("//i[contains(@class,'oxd-userdropdown-icon')]")).click();
		 
		 String button=driver.findElement(By.linkText("Logout")).getText();
		 if(!button.isEmpty()) {
		 
		 driver.findElement(By.linkText("Logout")).click();
		 System.out.println("Successful clicked");
		 }
	}

}
