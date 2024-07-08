package WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.w3schools.com/html/html_tables.asp");
		 driver.manage().window().maximize();
		 
		 WebElement table=driver.findElement(By.xpath("//table[@id='customers']"));
		 
		List <WebElement> row=table.findElements(By.tagName("tr"));
		 System.out.println("Number of rows.."+row.size());
		 
		 System.out.println("company"+"\t"+"contact"+"\t"+"country");
		 
		 for(WebElement rows :row) {
			 
		 List<WebElement>col=rows.findElements(By.tagName("td"));
		 for(WebElement cols : col) {
			 
			 System.out.print(cols.getText());
			  
			 
		 }
			System.out.println(); 
			 
		 }
		 
	}

}
