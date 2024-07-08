package links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_DropDown2 {

	public static void main(String[] args) throws InterruptedException {
		
		    WebDriver driver = new ChromeDriver();
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2500);
            
			Select drop=new Select(driver.findElement(By.xpath("//select[@id='country']")));
			
		    String opt =drop.getFirstSelectedOption().getText();
			System.out.println(opt);
			
			if(opt.equals("United States")) {
				System.out.println("State already selected");
			}
			else {
				drop.selectByVisibleText("United States");
				System.out.println("WD selected year");
			}
			
			WebElement opts = driver.findElement(By.xpath("//select[@id='country']"));
			
			System.out.println(opts.getText());
			
			List<WebElement> size = drop.getOptions();
			System.out.println(size.size());
			
				
			 
			
	 

	}

}
