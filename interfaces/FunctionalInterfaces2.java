package interfaces;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class FunctionalInterfaces2 implements FunctionalInterfaces ,Homepg{
    
	 WebDriver driver;
	 FileInputStream fis;
	 Properties pro;
      
	public void setup() throws IOException, InterruptedException {
		  fis = new FileInputStream("./Prop\\test.properties");
		  pro = new Properties();
		pro.load(fis);
		
        Thread.sleep(3000);
		driver = new ChromeDriver();
		driver.get(pro.getProperty("Baseurl"));
		driver.manage().window().maximize();
		
	}

	 
	public void homepg() {
		
		if(driver.getTitle().contains("HRM")) {
		 System.out.println(driver.getTitle());
		}
		
	}

	 
	abstract public void login();
	 

	 
	abstract public  void logout();
		 

	 
	 
	
	 
	
}
