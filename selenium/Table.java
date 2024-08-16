package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Table {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	 List<WebElement>row=driver.findElements(By.xpath("(//table[@id='product'])[last()]//tr[position()>=5]"));
	 System.out.println(row.size());
	 
        for (WebElement rows : row) {
        	 List<WebElement>col=rows.findElements(By.tagName("td"));
        	 for (WebElement cols : col) {
        		 System.out.print(cols.getText()+" <------>");
     		}
        	 System.out.println();
			}
        	
        
	}

}
