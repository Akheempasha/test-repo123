package testng.frameworkk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excel1 {
    
	@DataProvider
	public String[][] getData() throws IOException {
		 File myfile = new File("./Properties\\Book1.xlsx");
		 FileInputStream fis = new FileInputStream(myfile);
		 
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("sheet1");
		 int row=sheet.getPhysicalNumberOfRows();
		 int col=sheet.getRow(0).getLastCellNum();
		 
		 System.out.println("number of rows.."+row);
		 System.out.println("number of cols.."+col);
		 String[] [] data = new String[row-1] [col]; 
		for(int r=0;r<row-1;r++) {
			for(int c=0;c<col;c++) {
			//	System.out.println(sheet.getRow(r).getCell(c).getStringCellValue());
				data[r][c]=sheet.getRow(r+1).getCell(c).getStringCellValue();
				
			}
		       // System.out.println();
		}
		workbook.close();
		fis.close();
		for(String[] dataArr : data) {
		 
		System.out.println(Arrays.toString(dataArr));
		}
		return data;
	}

}
