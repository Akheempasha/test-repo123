package excel.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

public class Main_Method {

	public static void main(String[] args) throws Exception {

		File mfile = new File("C:\\Users\\akhee\\OneDrive\\Desktop\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(mfile);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");

		int rows = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rows - 1][col];
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < col; j++) {
				     //Approach-1
				// DataFormatter df = new DataFormatter();
				// System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
                // data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				     //Approach-2
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				// System.out.println(data[i][j]);
				     //Approach-3
				// System.out.println(sheet.getRow(i).getCell(j).toString());
				// System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());

			}
		    }
		
		book.close();
		fis.close();

			    for (String[] arr : data) {
			    	  System.out.println(Arrays.toString(arr)); 
				}

}

}
