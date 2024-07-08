package window.handles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferentWays_Handle {

	public static void main(String[] args) {
		 
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		String parentWin = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
		       //1.Approach
	/*	Set<String> winHandle =  driver.getWindowHandles();
		
		String window1 =(String)winHandle.toArray()[0];
		String window2 =(String)winHandle.toArray()[1];
		
		driver.switchTo().window(window2);
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		driver.navigate().refresh();
   */
	        //2.Approach
   /*	Set<String> winHandle =  driver.getWindowHandles();
		
		Iterator<String> winHandles = winHandle.iterator();
		String win1=winHandles.next();
		String win2=winHandles.next();
		
		driver.switchTo().window(win2);
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		driver.navigate().refresh();
	*/	
	
		//3.Approach
	
	/*	Set<String> winHandle =  driver.getWindowHandles();
	
	   for(String winHandles : winHandle) {
		 //  if(!winHandles.equals(parentWin)) {     only for 2 windows we can use this method
			     // or
		   if(!driver.getTitle().equals("Your Store")) {	   // multiple windows 
			   driver.switchTo().window(winHandles);
		   }
	       }
	
	    System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		driver.navigate().refresh();
	*/
	    
		//4.Approach
	/*	Set<String> winHandle =  driver.getWindowHandles();
		Iterator<String> winHandles = winHandle.iterator();
		while(winHandles.hasNext()) {
			String child =winHandles.next();
		 if(!parentWin.equals(child)) {
			 driver.switchTo().window(child);
		 }
		 }
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		driver.navigate().refresh();
	*/	
	
		//5.Approach
		
		List<String> winHandle = new ArrayList<String>(driver.getWindowHandles()); 
		
		String win1 = winHandle.get(0);
		String win2 = winHandle.get(1);
		
		
		driver.switchTo().window(win2);
		
		driver.findElement(By.cssSelector("img[title='MacBook']")).click();
		
		
		
		
		
		
		
		
	}

}
