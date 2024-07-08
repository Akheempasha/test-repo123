package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel_WebTable {

	public static void main(String[] args) throws Exception {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
         driver.manage().window().maximize();
         
        List<WebElement>rows= driver.findElements(By.xpath("//table[@style='text-align:right']//tr"));
        System.out.println(rows.size());
        
        List<WebElement>cols= driver.findElements(By.xpath("//table[@style='text-align:right']//th"));
        System.out.println(cols.size());
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1500)");
        
        
         String path = "C:\\Users\\akhee\\OneDrive\\Desktop\\populations.xlsx";
         
         
         
         Excel_Utils.setCellData(path, "Sheet1", 0, 0, "location");
         Excel_Utils.setCellData(path, "Sheet1", 0, 1, "population");
         Excel_Utils.setCellData(path, "Sheet1", 0, 2, "world");
         Excel_Utils.setCellData(path, "Sheet1", 0, 3, "data");
         Excel_Utils.setCellData(path, "Sheet1", 0, 4, "source");
         
          
        for (int r = 1; r <=rows.size(); r++) {
        		
        	String location=driver.findElement(By.xpath("//table[@style='text-align:right']//tr["+r+"]//td[2]")).getText();
        	String population=driver.findElement(By.xpath("//table[@style='text-align:right']//tr["+r+"]//td[3]")).getText();
        	String world=driver.findElement(By.xpath("//table[@style='text-align:right']//tr["+r+"]//td[4]")).getText();
        	String data=driver.findElement(By.xpath("//table[@style='text-align:right']//tr["+r+"]//td[5]")).getText();
        	String source=driver.findElement(By.xpath("//table[@style='text-align:right']//tr["+r+"]//td[6]")).getText();
		
		//	System.out.println(location+" \t "+population+" \t "+world+" \t "+data+" \t "+source);
   
				Excel_Utils.setCellData(path, "Sheet1", r, 0, location);
				Excel_Utils.setCellData(path, "Sheet1", r, 1, population);
				Excel_Utils.setCellData(path, "Sheet1", r, 2, world);
				Excel_Utils.setCellData(path, "Sheet1", r, 3, data);
				Excel_Utils.setCellData(path, "Sheet1", r, 4, source);
		     }
            System.out.println("Successful Add the data");
                   
	}

}
