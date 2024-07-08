package webelements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyperLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		boolean mystatus = false;
		String expLink = "REGISTER";
		int count = 0;

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
              // print all links 
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement linkss : links) {
			System.out.println(linkss.getText());
		}
		Thread.sleep(3000);
                //Click all links
		String[] alllinks = new String[links.size()];

		for (int i = 0; i < links.size(); i++) {
			alllinks[i] = links.get(i).getAttribute("href");
		}

		for (int i = 0; i < links.size(); i++) {
			driver.navigate().to(alllinks[i]);
			System.out.println(driver.getTitle());
		}

		Thread.sleep(3000);
               //Broken links
		for (WebElement linnk : links) {
			String Url = linnk.getAttribute("href");

			URL myUrl = new URL(Url);
			HttpURLConnection urlConection = (HttpURLConnection) myUrl.openConnection();
			urlConection.connect();

			if (urlConection.getResponseCode() == 200) {

				System.out.println(Url + "---" + urlConection.getResponseMessage());
			} else {
				System.err.println(Url + "---" + urlConection.getResponseCode());
				urlConection.disconnect();
			}
		}

		Thread.sleep(3000);
             //hidden links
		for (int i = 0; i < links.size(); i++) {
			String total = links.get(i).getText();
			if (!total.isEmpty()) {
				count++;
			}
		}

		System.out.println("Number of visible links.." + count);
		System.err.println("Hidden links.." + (links.size() - count));

		Thread.sleep(3000);

		for (WebElement link : links) {
			if (link.getText().equals(expLink)) {
				link.click();
				System.out.println("Successful clicked");
				mystatus = true;
				break;
			}
		}
		if (mystatus = false) {
			System.out.println("unsuccessful clicked");
		}

	}
}