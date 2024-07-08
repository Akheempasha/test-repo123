package excel.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
 

public class Excel_Dataprovider {
	
    @DataProvider
	public static String[][] testData() throws Exception {
		
		File mfile = new File("C:\\Users\\akhee\\OneDrive\\Desktop\\testdata.xlsx");
	    FileInputStream fis = new FileInputStream(mfile);
	    XSSFWorkbook book = new XSSFWorkbook(fis);
	    XSSFSheet sheet = book.getSheet("Sheet1");
	    
	    int rows = sheet.getPhysicalNumberOfRows();
	    int col  = sheet.getRow(0).getLastCellNum();
	    
	    String [][] data = new String[rows-1][col];
	    for (int i = 0; i <rows-1; i++) {
	    	for (int j = 0; j < col; j++) {
	    	data[i][j]=sheet.getRow(i+1).getCell(j).toString();
	    	System.out.println(data[i][j]);
	    		
			}
	        }
	    book.close();
	    fis.close();
	     
	    return data;
	}

}
