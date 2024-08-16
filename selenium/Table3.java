package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	List<WebElement> rows =driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
	List<WebElement> cols =driver.findElements(By.xpath("//table[@class='dataTable']//tr//th"));
	
	for (int i = 1; i < rows.size(); i++) {
		for (int j = 1; j < cols.size(); j++) {
	String table=driver.findElement(By
			.xpath("//table[@class='dataTable']//tr["+i+"]//td["+j+"]")).getText();
	 
	//double value = 714.90;
	 
	    if(table.equals("Advani Hotels"))
	   System.out.print(i+" : "+j);
	    break;
		}

	}
    
	}

}
