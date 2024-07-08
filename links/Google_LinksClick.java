package links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_LinksClick {
    public static void main(String[] args) throws InterruptedException {
		
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		System.out.println("Successful initialize the browser");
		
		List<WebElement>link=driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		for(int i =0 ; i<=link.size(); i++) {
			//System.out.println(link.get(i).getText());
			 
		String pglink =	link.get(i).getText();
		    if(!pglink.isEmpty()) {
		    	link.get(i).click();
		    	System.out.println(driver.getTitle());
		    	Thread.sleep(3000);
		    }
		    else {
		    	driver.navigate().back();
		    }
		      driver.navigate().to("https://www.google.co.in");
		      link=driver.findElements(By.tagName("a"));
		    }
		    driver.close();
	}

}
