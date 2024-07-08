package WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination_Table {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
 
		   
	    
			for(int p =1; p<=4;p++) {
		    Thread.sleep(3000);
			
			if(p>1) {
				
				driver.findElement(By.xpath("//ul[@class='pagination']//a[text()="+p+"]")).click();
				Thread.sleep(3000);
			} 
			
	int row	=driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
	    for(int r=1;r<=row;r++) {
	    	   
		   
	   String id=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[1]")).getText();
	   String name=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[2]")).getText();
	   String price=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[3]")).getText();
	  
	   System.out.println(id+"\t"+name+"\t"+price);
        }
	    	  
	       }
	   }
 
	}



