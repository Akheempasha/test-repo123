package assignments;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchCase {
	

	public static void main(String[] args) {
		WebDriver driver = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Browser name");
		String browser = sc.nextLine();
		sc.close();
		
		switch(browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "FF":
			driver = new FirefoxDriver();
			driver.get("https://www.google.co.in");
			driver.manage().window().maximize();
			System.out.println("Successfull Firefox login");
			driver.close();	
			break;
			
		case "Edge":
			driver = new EdgeDriver();
			driver.get("https://www.google.co.in");
			driver.manage().window().maximize();
			System.out.println("Successfull Edge login");
			driver.close();
			break;
			
	    default :
	    	System.out.println("Invalid Browser name");
			
		}
		  // or
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		System.out.println("Successfull browser open");
		driver.close();
		 
	}
}
