package selenium;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMap_Selenium {
    public static WebDriver driver;  
    
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName("user"));
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(userPass("user"));
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
	     }
	
	
	
	
	
	public static HashMap<String, String> credential_Data() {
		HashMap<String, String> mapData = new HashMap<String, String>();
		
		mapData.put("employee", "Akheem : test@123");
		mapData.put("user",     "Admin : admin123");
		mapData.put("Manager",  "Sunny : test001");
		mapData.put("owner", "MainAdmin : admin");
		mapData.put("agent", "saiKumer : Sai@123");
		
		return mapData;
	}
	
	public static String userName(String role) {
		String detailes =credential_Data().get(role).split(" : ")[0];
		return detailes;
	}
    
	public static String userPass(String role) {
		String detailes =credential_Data().get(role).split(" : ")[1];
		return detailes;
	}
}
