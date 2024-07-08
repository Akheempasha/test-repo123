package automation.testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OrangeBaseClass {
	
	public static void setcellData(String xlfile,String sheets,int rowNum,int cellNum,String data) throws Exception {
		FileInputStream fis = new FileInputStream(xlfile);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet(sheets);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(xlfile);
		
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
		
		
	}

}
