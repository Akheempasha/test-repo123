package window.handles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/v3/signin/identifier?hl=en-gb&ifkv=AaSxoQyIjUtqsdSxdb5SeDkE9GlEon3SittMKxEQTfVJ1aOzRtzf5qOXJdIxO0ZC4wz_CbL_sBh-8g&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-1928446294%3A1716621107591009&ddm=0");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Help']")).click();
		
		Set<String> pageHandle = driver.getWindowHandles();
		
		Iterator<String> winHandles=pageHandle.iterator();
		
		while(winHandles.hasNext()) {
		//	System.out.println(winHandles.next());
			String child =winHandles.next();
		
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				System.out.println(driver.switchTo().window(child).getTitle());
				driver.close();
			}
		
		    }
		
		driver.switchTo().window(parent);
	   System.out.println(driver.switchTo().window(parent).getTitle());
	
		
		 

	}

}
