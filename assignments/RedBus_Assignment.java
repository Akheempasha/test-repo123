package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBus_Assignment {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws Exception {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		driver = new ChromeDriver(option);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://www.redbus.in");
		driver.manage().window().maximize();

		List<String> weekendDates = getWeekEndDates("Sep 2024");

		System.out.println("Weekend Dates are : " + weekendDates);
		driver.close();

	}
	

	public static List<String> getWeekEndDates(String givenMonthYear) throws Exception {

		 driver.findElement(By.cssSelector("i[class $='datev2']")).click();
		 
		WebElement monthAndYearElement = driver
				.findElement(By.cssSelector("div[class^='DayNavigator'] div:nth-child(2)"));


		while (!monthAndYearElement.getText().contains(givenMonthYear)) {
			System.out.println(monthAndYearElement.getText().split("\\r?\\n")[0]);
			printHoliday();
			System.out.println("-----------------------");
			WebElement nextArrow = driver.findElement(By.cssSelector("div[class*='CalendarHeader'] div:nth-child(3)"));
			wait.until(ExpectedConditions.elementToBeClickable(nextArrow));

			Actions a = new Actions(driver);
			a.moveToElement(nextArrow).click().perform();
             

		}
		
		System.out.println(givenMonthYear);
		printHoliday();

		List<WebElement> weekends = driver.findElements(By.cssSelector(
				"div[class^='DayTiles_']  span:not([class$='hVMWpe'], [class$='dkWAbH'], [class$='gigHYE'])"));

		List<String> weekendDates = new ArrayList<>();

		for (WebElement weekend : weekends) {
			weekendDates.add(weekend.getText());
		}

		System.out.println("Given month and year is " + givenMonthYear);
         return weekendDates;
		
	}

	

	static void printHoliday() {
		List<WebElement> holidayCount = driver.findElements(By.cssSelector("div[class='holiday_count']"));
		String holidayCountString = "No Holidays in this Month";
		if (!holidayCount.isEmpty()) {
			holidayCountString = holidayCount.get(0).getText();
		}
		System.out.println("No. of holidays (excluding weekends) : " + holidayCountString);
	}

}