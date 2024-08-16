package selenium;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class File_Downloading_Using_FluentWait {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://git-scm.com/download/win");

		  driver.findElement(By.xpath("//a[text()='Click here to download ']")).click();

		String downloadPath = "C:\\Users\\akhee\\Downloads";
		String fileName = "Git-2.46.0-64-bit.exe";
		File file = new File(downloadPath, fileName);

		FluentWait<File> waits = new FluentWait<File>(file)
				.withTimeout(Duration.ofMinutes(5))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class)
				.withMessage("file is not Downloaded");
		
		 try {
		boolean isDisplayed = waits.until(f -> f.exists() && f.canRead());
		
		if (isDisplayed) {
			System.out.println("file is completly 100% downloaded");
		}
        }
		catch(Exception e) {
			System.out.println("file is not completly downloaded");
		}

	}

}
