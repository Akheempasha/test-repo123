package selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> th =driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
        
        for (WebElement webElement : th) {
			System.out.print(webElement.getText()+"\t");
		}
        System.out.println();
        
        List<WebElement> rows =driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        List<WebElement> cols =driver.findElements(By.xpath("//table[@name='BookTable']//tr/th"));
        
        for (int i = 2; i <= rows.size(); i++) {
        	for (int j = 1; j <= cols.size(); j++) {
        	String table=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
        	System.out.print(table+"\t");
			}
        	System.out.println();
			
		}
		
	}

}
