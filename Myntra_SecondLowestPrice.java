package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myntra_SecondLowestPrice {
	public static WebDriver driver;
	public static int secoundlowestprice;

	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
	    driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String parentWindow = driver.getWindowHandle();
		
	 // lowestSecondPrice();	
		lowestSecondPrice2(2);
		windowHandle(parentWindow);
		selectAgeGroupSize(2);
		addCart();
	}

	
	
	
	public static void lowestSecondPrice() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("a[data-group='kids']"))).perform();
		
		driver.findElement(By.cssSelector
				   ("ul[class='desktop-navBlock'] li[data-reactid='344'] a")).click();
		
		List<WebElement>priceList =driver.findElements(By.cssSelector("span[class='product-discountedPrice']"));
		
        WebElement lowestElementPrice = null; 
        WebElement secondlowestElementPrice = null;
        
        int lowestprices = Integer.MAX_VALUE;
        int secondlowest = Integer.MAX_VALUE;
		
		for (WebElement priceElement : priceList) {
			int prices = Integer.valueOf(priceElement.getText().replaceAll("[^0-9]", ""));
			if(prices < lowestprices) {
				secondlowest = lowestprices;
				secondlowestElementPrice =  lowestElementPrice;
				lowestprices = prices;
				lowestElementPrice = priceElement;	
			}
			else if(prices < secondlowest && prices != lowestprices) {
				secondlowest = prices;
				secondlowestElementPrice = priceElement;
		    }
		 	
	     }
		
		System.out.println("***"+lowestElementPrice.getText());
		System.out.println("##"+secondlowestElementPrice.getText());
		
			if(secondlowestElementPrice != null) { 
				secondlowestElementPrice.click();
				System.out.println("lowest price is : "+lowestprices);
				System.out.println("second lowest price is :"+secondlowest);
			}
			else {
				System.out.println("no valid second lowest price found");
			}
			
		}	
	
	public static int lowestSecondPrice2(int num) throws Exception {
		//Mouse Hover on Kids
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("a[data-group='kids']"))).perform();
		// click on T-shirt
		driver.findElement(By.cssSelector
				("ul[class='desktop-navBlock'] li[data-reactid='344'] a")).click();
		// click second lowest price
		List<WebElement>priceList =driver.findElements(By.cssSelector("span[class='product-discountedPrice']"));
		
		List<Integer> prices =  priceList.stream()
				                       .map(WebElement::getText)
				                       .filter(text-> !text.isEmpty())
				                       .map(text->text.replaceAll("[^0-9]", ""))
				                       .map(Integer::valueOf)
				                      // .sorted(Collections.reverseOrder())	
				                       .sorted()
				                       .collect(Collectors.toList());
		System.out.println(prices);
		
		secoundlowestprice = prices.get(num);
	 	System.out.println("second lowestprice : "+secoundlowestprice);
			for (int i = 0 ;i < priceList.size(); i++) {
			Integer pri =Integer.valueOf(priceList.get(i).getText().replaceAll("[^0-9]", ""));
			if(pri == secoundlowestprice) {
				System.out.println("Second lowest price is :"+pri);
				priceList.get(i).click();
				break;
			}
		}
			return secoundlowestprice;
			
		}
	
	public static void windowHandle(String parentWindow) {
		Set<String> winHandle = driver.getWindowHandles();
		for (String s : winHandle) {
			if(!parentWindow.equals(s)) {
				driver.switchTo().window(s);
			}
		}
		System.out.println(driver.getTitle());		
	}
	
	public static void selectAgeGroupSize(int num ) throws InterruptedException {
		List<WebElement> selectSize = driver.findElements(By.
				   cssSelector("div[class = 'size-buttons-size-buttons'] button"));
		System.out.println(selectSize.size());
		
		WebElement specificelement = selectSize.get(num);
		specificelement.click();
		System.out.println(specificelement.getText());
	}
	
	public static void addCart() throws Exception {
		driver.findElement(By.cssSelector
				                    ("div[class *='pdp-add-to-bag']")).click();
		TimeUnit.SECONDS.sleep(3);
		WebElement ele =driver.findElement(By.xpath
				                    ("//span[text()='Bag']"));
		fluentwait(ele);
		ele.click();
		String price =driver.findElement(By.xpath("(//span[@class='priceDetail-base-value '])[2]")).getText();
		int tPrice = Integer.parseInt(price.replaceAll("[^0-9]", "").trim());
	    WebElement order = driver.findElement(By.xpath("//div[text()='PLACE ORDER']"));
	    scrollView(order);
	    
	    if(secoundlowestprice == tPrice) {
		System.out.println("secondlowestprice and addToCartprice are equal : "+tPrice);
		order.click();
	      }
	}
	
	 public static void fluentwait(WebElement ele) {
		 
		 FluentWait<WebDriver> waits = new FluentWait<WebDriver>(driver)
				                          .withTimeout(Duration.ofSeconds(10))
				                          .pollingEvery(Duration.ofSeconds(2))
				                          .ignoring(Exception.class)
				                          .withMessage("Element not clcickable");
		 waits.until(ExpectedConditions.elementToBeClickable(ele));	 
	 }
	 
	 public static void userlogin() {
		 if(driver.findElement(By.cssSelector("div[class='welcome-header']")).isDisplayed()) {
			System.out.println("Successful item add to cart ");
		 }
	 }
	 
	 public static void scrollView(WebElement ele) {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", ele);
		 js.executeScript("window.scrollBy(0,-100);");
	 }
		
	}


