package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='filesToUpload']"))
		.sendKeys("C:\\Users\\akhee\\OneDrive\\Desktop\\Resumes\\Prathyusha.pdf");
		
	}

}
