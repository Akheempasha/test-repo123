package datadriven;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Excel_LinkText  {

	public static void main(String[] args)throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.eenadu.net/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		 
	/*	 
		FileOutputStream fo = new FileOutputStream("C:\\Users\\akhee\\OneDrive\\Desktop\\testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet =workbook.createSheet();
	*/	
		   String path = "C:\\Users\\akhee\\OneDrive\\Desktop\\getText.xlsx";
		 
		
		for (int i = 0; i < links.size(); i++) {
			
			Excel_Utils.setCellData(path, "Sheet1", i, 0,links.get(i).getText()+"ok" );
		}
		
		/*	
			XSSFRow row =sheet.createRow(i);
			row.createCell(0).setCellValue(links.get(i).getText()+"ok");
			//System.out.println(links.get(i).getText());
	
		  }
		workbook.write(fo);
		workbook.close();
		fo.close();
		*/	 
	 
	 System.out.println("writing data in excel was completed");
	// driver.quit();
	}

}
