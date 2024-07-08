package WebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemo2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement opt=driver.findElement(By.name("fromPort"));
		Select ele = new Select(opt);
		ele.selectByIndex(2);
		
		WebElement opt2=driver.findElement(By.name("toPort"));
		Select ele2 = new Select(opt2);
		ele.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table']//tr"));
		System.out.println(rows.size());
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='table']//tr//th"));
		System.out.println(cols.size());
		
		for(int r=1;r<=rows.size();r++) {
			for(int c=1	;c<=cols.size();c++) {
		String table=driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]/td["+c+"]")).getText();
		         System.out.print(table+"\t");
			}
		         System.out.println();
		}

	}

}
