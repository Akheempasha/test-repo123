package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Data {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
	    driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().window().maximize();
		
		TimeUnit.SECONDS.sleep(2);
		
		String worldPopulation = "//div[@class='maincounter-number']/span";
		String todayPop = "//div[text()='Today']//parent::div//span[@class='rts-counter']";
		String thisYearPopu = "//div[text()='This year']//parent::div//span[@class='rts-counter']";
		String today_thisYear_Popu = "(//div[@class='row'])[3]//span[@class='rts-counter']";
		
		worldPopulation(today_thisYear_Popu);
		
		
	}
	
	public static void worldPopulation(String populations) {
		
	 
		while(true) {
		List<WebElement>population = driver.findElements(By
				.xpath(populations));
		
		for (int i = 0; i < population.size(); i++) {
			System.out.println(population.get(i).getText());
			
		}
		
		}
	}

}
