package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Commands {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");    //1.get
		driver.manage().window().maximize();       //2.maximize
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	String url=	driver.getCurrentUrl();            //3.getCurrenrurl
	System.out.println(url);                       
	 
	System.out.println(driver.getTitle());         //4.getTitle
	
	String pageSource =driver.getPageSource();     //5.getPageSource
	//System.out.println(pageSource);
	
	driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
	Thread.sleep(2000);
	driver.navigate().back();                       //6.navigate().back()
	Thread.sleep(2000);                                       
	driver.navigate().forward();                    //7.navigate().forward()
	Thread.sleep(2000);
	driver.navigate().refresh();                    //8.navigate().refresh()
	Thread.sleep(2000);
	driver.switchTo().newWindow(WindowType.TAB);    //9.New Tab
	Thread.sleep(2000);
	driver.navigate().to("https://www.selenium.dev/");//13 navigate().to()
	Thread.sleep(2000);
	driver.close();                                 //10.close()
	driver.navigate().back();
	Thread.sleep(2000);
	driver.switchTo().newWindow(WindowType.WINDOW); //11.New Window
	Thread.sleep(2000);
	driver.quit();                                   //12.quit();
	
		
	}

}
