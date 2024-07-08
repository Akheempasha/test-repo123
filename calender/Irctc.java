package calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Irctc {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		
	    driver = new ChromeDriver(op);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		String month = "August2024";
		String day   = "10";
		
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']")).click();
		Thread.sleep(3000);
		
	while(true) {
	 String text=driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']")).getText();
			if(text.equals(month)) {
		    	break;
		    }
		    else {
		    	driver.findElement(By.xpath("//span[@class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10']")).click();
		    	 
		    }
		    }
		driver.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),"+day+")]")).click();
		            System.out.println("Successful picked the date");
	}

}
