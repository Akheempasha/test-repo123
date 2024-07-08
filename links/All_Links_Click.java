package links;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class All_Links_Click {

	public static void main(String[] args) {
	 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		
		
		List <WebElement> link = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links.."+link.size());
		     // Get All Text
		for (WebElement links : link) {
			System.out.println(links.getText());
			System.out.println(links);
		}
		  //Get All Links

		String[] linkss = new String[link.size()];
		
		for(int i=0; i<link.size();i++) {
		linkss[i]=link.get(i).getAttribute("href");
			System.out.println(linkss[i]);
			
		}
		   //Click All The Links
		for (int i =0 ; i<link.size(); i++) {
			driver.navigate().to(linkss[i]);
			System.out.println(driver.getTitle());
		}
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		

	}

}
