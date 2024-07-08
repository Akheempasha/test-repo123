package datadriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_ExcelData {

	public static void main(String[] args) throws Exception {

		FileInputStream fo = new FileInputStream("C:\\Users\\akhee\\OneDrive\\Desktop\\testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fo);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < rows; i++) {
			for (int c = 0; c < cols; c++) {
				DataFormatter format = new DataFormatter();
				
				System.out.print(format.formatCellValue(sheet.getRow(i).getCell(c))+"\t");
			}
			System.out.println();
		}
		
		workbook.close();
		fo.close();

	}

}
